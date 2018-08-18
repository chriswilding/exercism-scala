object Grains {
  private val one = BigInt(1)

  def square(n: Int): Option[BigInt] =
    if (n > 0 && n < 65) Some(one << n - 1)
    else None

  def total(): BigInt =
    (one << 64) - 1
}
