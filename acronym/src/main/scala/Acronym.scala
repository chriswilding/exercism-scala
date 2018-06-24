object Acronym {
  def abbreviate(phrase: String): String =
    phrase
      .split("[^A-z]+")
      .map(_.head.toUpper)
      .mkString
}
