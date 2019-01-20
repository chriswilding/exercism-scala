object CryptoSquare {
  def ciphertext(input: String): String =
    if (input.isEmpty) ""
    else {
      val text = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase
      val len = text.length
      val sqrt = Math.sqrt(len)
      val colLen = sqrt.round.toInt
      val rowLen = sqrt.ceil.toInt
      val nOfSpaces = rowLen * colLen - len
      val fullRows = rowLen - nOfSpaces

      val sb = new StringBuilder()

      for (rowI <- 0 until rowLen; colI <- 0 until colLen) {
        if (rowI >= fullRows && colI == (colLen - 1))
          sb.append(' ')
        else {
          val i = colI * rowLen + rowI
          sb.append(text(i))
        }
      }

      sb.grouped(colLen).map(_.mkString).mkString(" ")
    }
}
