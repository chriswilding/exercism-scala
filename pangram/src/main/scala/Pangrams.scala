object Pangrams {
  val alphabet = 'a' to 'z'

  def isPangram(input: String): Boolean =
    input.toLowerCase.filter(_.isLetter).toSet.size == 26
}