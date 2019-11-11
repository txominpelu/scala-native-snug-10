import scala.scalanative._
import scala.scalanative.unsafe._

object Main {
  def myvprintf(format: CString, args: CVarArg*): CInt = {
    Zone { implicit z =>
      MyStupidLib.vprintf(format, toCVarArgList(args.toSeq))
    } 
  }

  def main(args: Array[String]): Unit = {
    myvprintf(c"Hello %s!\n", c"world")
    myvprintf(c"%d + %d = %d!\n", 3, 2, 3 + 2)
  }
}
