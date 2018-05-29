object NumberType extends Enumeration {
  val Abundant, Deficient, Perfect = Value
}

object PerfectNumbers {
  def classify(n: Int): Either[String, NumberType.Value] = {
    if (n < 1) Left("Classification is only possible for natural numbers.")
    else {
      val numberType = factors(n).sum match {
        case sum if sum == n => NumberType.Perfect
        case sum if sum > n => NumberType.Abundant
        case sum if sum < n => NumberType.Deficient
      }
      Right(numberType)
    }
  }

  private def factors(n: Int): Seq[Int] = {
    val limit = n / 2 + 1
    (1 until limit).filter(x => n % x == 0)
  }
}