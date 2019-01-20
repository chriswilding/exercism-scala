object CryptoSquare {
  def ciphertext(input: String): String =
    if (input.isEmpty) ""
    else {
      val text = input.filter(_.isLetterOrDigit).toLowerCase
      val len = text.length
      val sqrt = Math.sqrt(len)
      val colLen = sqrt.round.toInt
      val rowLen = sqrt.ceil.toInt
      val nOfSpaces = rowLen * colLen - len
      val fullRows = rowLen - nOfSpaces

      val chars = for (
        rowI <- 0 until rowLen;
        colI <- 0 until colLen;
        i = colI * rowLen + rowI
      ) yield {
        if (rowI >= fullRows && colI == (colLen - 1))
          ' '
        else {
          text(i)
        }
      }

      chars.grouped(colLen).map(_.mkString).mkString(" ")
    }
}
