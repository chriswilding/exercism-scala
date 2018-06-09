object Isogram {
  def isIsogram(phrase: String): Boolean = {
    val letters = phrase.toLowerCase.toCharArray.filter(_.isLetter)
    letters.size == letters.toSet.size
  }
}
