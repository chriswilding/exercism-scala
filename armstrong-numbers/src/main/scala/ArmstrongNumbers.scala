object ArmstrongNumbers {
  def isArmstrongNumber(number: Int): Boolean = {
    val numberOfDigits = math.log10(number).toInt + 1
    armstrongSum(number, numberOfDigits, numberOfDigits) == number
  }

  @annotation.tailrec
  private def armstrongSum(number: Int, numberOfDigits: Int, n: Int, total: Int = 0): Int = {
    if (n < 1) total
    else {
      val nthDigit = (number % math.pow(10, n)).toInt / math.pow(10, n - 1).toInt
      armstrongSum(number, numberOfDigits, n - 1, total + math.pow(nthDigit, numberOfDigits).toInt)
    }
  }
}