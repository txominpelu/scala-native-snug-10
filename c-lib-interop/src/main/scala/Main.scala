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
