object Grains {
  private val two = BigInt(2)

  def square(n: Int): Option[BigInt] =
    if (n > 0 && n < 65) Some(two.pow(n - 1))
    else None

  def total(): BigInt =
    (1 to 64).flatMap(n => square(n)).sum
}