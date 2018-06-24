object RunLengthEncoding {
  @annotation.tailrec
  def encode(input: String, inputChar: Option[Char] = None, count: Int = 0, sb: StringBuilder = new StringBuilder): String = {
    (input, inputChar) match {
      case ("", None) => ""
      case (in, None) => encode(in.tail, Some(in.head), 1, sb)
      case ("", Some(char)) => encodeChar(sb, count, char).toString()
      case (in, Some(char)) if in.head == char => encode(in.tail, inputChar, count + 1, sb)
      case (in, Some(char)) => encode(in.tail, Some(in.head), 1, encodeChar(sb, count, char))
    }
  }

  def decode(in: String, currentChar: Option[Char] = None, count: Int = 0, out: String = ""): String = {
    if (in.isEmpty) in
    else {
      val sb = new StringBuilder
      val chars = in.toArray.iterator

      var count = ""

      while(chars.hasNext) {
        val char = chars.next
        if (char.isDigit) count = s"$count$char"
        else {
          val end = if (count.isEmpty) 1 else count.toInt
          for (_ <- 0 until end) { sb.append(char) }
          count = ""
        }
      }
      sb.toString()
    }
  }

  private def encodeChar(sb: StringBuilder, count: Int, char: Char): StringBuilder = {
    if (count == 1) sb.append(char)
    else {
      sb.append(count)
      sb.append(char)
    }
    sb
  }
}
