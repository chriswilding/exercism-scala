case class WordCount(phrase: String) {
  def countWords(): Map[String, Int] =
    phrase
      .toLowerCase()
      .split("""'?[^\d|\w|']'?""")
      .filter(_.nonEmpty)
      .groupBy(identity)
      .mapValues(_.size)
}
