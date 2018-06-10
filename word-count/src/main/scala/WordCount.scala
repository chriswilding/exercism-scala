case class WordCount(phrase: String) {
  def countWords(): Map[String, Int] = {
    phrase
      .toLowerCase()
      .split("""[^\d|\w|']""")
      .map(_.stripPrefix("'").stripSuffix("'"))
      .filterNot(_.isEmpty)
      .foldLeft[Map[String, Int]](Map.empty)(
      (acc, word) => {
        val count = acc.getOrElse(word, 0) + 1
        acc + (word -> count)
      }
    )
  }
}
