
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

Other libraries need to be defined by giving the name of the library. If your
library is defined in *$LD_LIBRARY_PATH* and it's called "libmylibrary" to use
a method of that library we would do:

    ```scala
    @extern
    @link("mylibrary")
    object MyStupidLib {
        //...
    }
    ```


