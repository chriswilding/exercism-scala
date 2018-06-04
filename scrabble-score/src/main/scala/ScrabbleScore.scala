object ScrabbleScore {
  val scores = Seq(
    toPairs("AEIOULNRST", 1),
    toPairs("DG", 2),
    toPairs("BCMP", 3),
    toPairs("FHVWY", 4),
    toPairs("K", 5),
    toPairs("JX", 8),
    toPairs("QZ", 10)
  ).flatten.toMap

  def score(input: String): Int = {
    input.toUpperCase.map(c => scores(c)).sum
  }

  private def toPairs(letters: String, score: Int): Seq[(Char, Int)] =
    letters.map(char => char -> score)
}