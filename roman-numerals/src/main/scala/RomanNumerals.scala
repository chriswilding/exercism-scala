import scala.annotation.tailrec

object RomanNumerals {
  private val romanToArabic = List(
    ("M", 1000),
    ("CM", 900),
    ("D", 500),
    ("CD", 400),
    ("C", 100),
    ("XC", 90),
    ("L", 50),
    ("XL", 40),
    ("X", 10),
    ("IX", 9),
    ("V", 5),
    ("IV", 4),
    ("I", 1)
  )

  @tailrec
  def roman(n: Int, output: String = ""): String = {
    if (n == 0) output
    else {
      val (r, a) = romanToArabic.maxBy(n >= _._2)
      roman(n - a, output + r)
    }
  }
}
