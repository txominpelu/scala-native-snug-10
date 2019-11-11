import scala.scalanative._
import scala.scalanative.unsafe._

@extern
object MyStupidLib {
  def vprintf(format: CString, args: CVarArgList): CInt = extern
}

