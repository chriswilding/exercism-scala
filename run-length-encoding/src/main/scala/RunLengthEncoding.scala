object RunLengthEncoding {
  private val encodeRegex = """([ A-z])\1*""".r
  private val decodeRegex = """([ A-z])\1*|\d+""".r

  def encode(input: String): String = {
    encodeRegex
      .findAllIn(input)
      .foldLeft(new StringBuilder)(
        (sb, run) => {
          if (run.length == 1) sb.append(run)
          else {
            sb.append(run.length)
            sb.append(run.head)
          }
        }
      )
      .toString
  }

  def decode(input: String): String = {
    val matches = decodeRegex.findAllIn(input)

    val sb = new StringBuilder

    var count = 1

    while (matches.hasNext) {
      val countOrChar = matches.next
      if (countOrChar.head.isDigit) count = countOrChar.toInt
      else {
        for (_ <- 0 until count) {
          sb.append(countOrChar)
        }
        count = 1
      }
    }
    sb.toString()
  }
}
