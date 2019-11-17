
# Using library

## C Standard library

If we are using a function that belongs to the C standar library like vprinf we
only need to create an object annotate it with **@extern** and define the
methods that we want to expose (vprintf in this example):

```scala
@extern
object MyStupidLib {
  def vprintf(format: CString, args: CVarArgList): CInt = extern
}
```

## Other libraries

If your library is defined in the standard system path (e.g /usr/local/lib/) 
then you need to annotate the object that would be the wrapper to your library
with **@link("mylibname")** where mylibname is the name of the library without
the lib prefix. E.g if you want to link to the nice ncurses library that you 
can usually find in */usr/local/lib/libncurses.a* then you can link it with:


    ```scala
    @extern
    @link("ncurses")
    object MyNCursesWrapper {
        //...
    }
    ```


## Non standard path

If you want to use a path that is not standard you would need to add your path
to *build.sb* **nativeLinkingOptions** just like you would add it to link to a
library when compiling C or C++ code with gcc / clang.

    ```scala
    nativeLinkingOptions := Seq(
        "-L/usr/local/lib",
        "-L/usr/local/Cellar/ncurses/6.1/lib/"
    )
    ```

You can use this trick to link to your custom C code. You just need to write
your code, build your own library and point *nativeLinkingOptions* to where your
library is stored. You can see how to do this in [run.sh](run.sh) and [build.sbt](build.sbt).

There is ongoing work on [scala-native/scala-native#1637](https://github.com/scala-native/scala-native/pull/1637) a PR that includes compiling C / C++ files that would be available on scala native without having to proved a link to the library (no need to add *@link* or to modify *nativeLinkingOptions*).


# Example code


In this project you can see an example of how to use methods from the standard
C lib (e.g: vprintf) and methods from a custom C library (e.g: sum, multiply) that 
has been conveniently compiled and link with *nativeLinkingOptions* inside 
[run.sh](run.sh).

```scala
import scala.scalanative._
import scala.scalanative.unsafe._

@link("mystupidlib")
@extern
object MyStupidLib {
  
  def vprintf(format: CString, args: CVarArgList): CInt = extern

  def sum(a: CInt, b: CInt): CInt = extern

  def multiply(a: CInt, b: CInt): CInt = extern

}

object Main {
  def main(args: Array[String]): Unit = {
    myprintf(c"sum(%d, %d) = %d\n", 3, 2, MyStupidLib.sum(3, 2))
    myprintf(c"multiply(%d, %d) = %d\n", 3, 2, MyStupidLib.multiply(3, 2))
  }

  def myprintf(format: CString, args: CVarArg*): CInt = {
    Zone { implicit z =>
      MyStupidLib.vprintf(format, toCVarArgList(args.toSeq))
    }
  }
}
```
