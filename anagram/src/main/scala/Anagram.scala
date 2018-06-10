object Anagram {
  def anagrams(word: String, candidates: List[String]): List[String] = {
    val lowerCaseWord = word.toLowerCase
    val sortedWord = lowerCaseWord.sorted
    candidates.filter(candidate => {
      val lowerCaseCandidate = candidate.toLowerCase
      lowerCaseCandidate != lowerCaseWord && lowerCaseCandidate.sorted == sortedWord
    })
  }
}
