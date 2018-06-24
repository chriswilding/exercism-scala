object RunLengthEncoding {
  private val encodeRegex = """([ A-z])\1*""".r
  private val decodeRegex = """([ A-z])\1*|\d+""".r

  def encode(input: String): String = {
    val matches = encodeRegex.findAllIn(input)

    val stringBuilder = new StringBuilder

    matches.foreach {
      case run if run.length == 1 => stringBuilder.append(run)
      case run => {
        stringBuilder.append(run.length)
        stringBuilder.append(run.head)
      }
    }

    stringBuilder.toString
  }

  def decode(input: String): String = {
    val matches = decodeRegex.findAllIn(input).toList
    val grouped = group(matches).reverse

    val stringBuilder = new StringBuilder

    grouped.foreach {
      case (count, char) if count == 1 => stringBuilder.append(char)
      case (count, char) => {
        for (_ <- 0 until count) {
          stringBuilder.append(char)
        }
      }
    }

    stringBuilder.toString
  }

  @annotation.tailrec
  def group(input: List[String], output: List[(Int, Char)] = List.empty): List[(Int, Char)] = {
    (input, output) match {
      case (Nil, out) => out
      case (countOrChar :: tail, out) => {
        if (countOrChar.head.isDigit) {
          val count = countOrChar.toInt
          group(tail.tail, (count, tail.head.head) :: out)
        } else {
          group(tail, (1, countOrChar.head) :: out)
        }
      }
    }
  }
}
