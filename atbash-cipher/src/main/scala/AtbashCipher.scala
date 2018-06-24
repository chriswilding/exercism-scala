object AtbashCipher {
  private val alphabet = 'a' to 'z'
  private val numbers = '0' to '9'
  private val encoding = (alphabet.zip(alphabet.reverse) ++ numbers.zip(numbers)).toMap
  private val decoding = encoding.map(_.swap)

  def encode(input: String): String =
    input.toLowerCase.flatMap(encoding.get).grouped(5).mkString(" ")

  def decode(input: String): String =
    input.toLowerCase.flatMap(decoding.get).mkString
}
