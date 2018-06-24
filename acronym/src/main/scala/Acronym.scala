object Acronym {
  def abbreviate(phrase: String): String =
    phrase.split("[^A-z]+")
    .map(_(0))
    .mkString("")
    .toUpperCase
}
