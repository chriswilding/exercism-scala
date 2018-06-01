object Pangrams {
  val alphabet = 'a' to 'z'

  def isPangram(input: String): Boolean = {
    val string = input.toLowerCase
    string.length > 25 && alphabet.forall(char => string.contains(char))
  }
}