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

  def roman(n: Int): String = {
    val stringBuilder = new StringBuilder

    romanToArabic.foldLeft(n)(
      (remainder, romanAndArabic) => {
        val (roman, arabic) = romanAndArabic
        val times = math.floor(remainder / arabic).toInt

        if (times == 0) remainder
        else {
          for (_ <- 0 until times) {
            stringBuilder.append(roman)
          }
          remainder - (times * arabic)
        }
      }
    )

    stringBuilder.toString
  }
}
