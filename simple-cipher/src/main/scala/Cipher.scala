import scala.util.Random

case class Cipher(inputKey: Option[String]) {
  val key = inputKey match {
    case None => Random.alphanumeric.filter(_.isLetter).take(100).mkString.toLowerCase
    case Some(string) => {
      val valid = !string.isEmpty && string.toSeq.forall(c => c.isLetter && c.isLower)
      if (valid) {
        string
      } else throw new IllegalArgumentException()
    }
  }

  def encode(input: String): String =
    input.zip(key).map {
      case (inChar, inKey) => {
        val map = buildMap(inKey - 'a', true)
        map(inChar)
      }
    }.mkString

  def decode(input: String): String =
    input.zip(key).map {
      case (inChar, inKey) => {
        val map = buildMap(inKey - 'a')
        map(inChar)
      }
    }.mkString

  private def buildMap(offset: Int, encode: Boolean = false): Map[Char, Char] = {
    val rotated = Stream.continually('a' to 'z')
      .flatten
      .slice(offset, offset + 26)

    val pairs = if (encode) ('a' to 'z').zip(rotated) else rotated.zip('a' to 'z')
    pairs.toMap
  }
}
