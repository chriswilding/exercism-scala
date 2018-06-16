object PrimeFactors {
  def factors(n: Long): List[Long] = {
    if (n == 1) List.empty
    else {
      getFactors(n, 2, List.empty).reverse
    }
  }

  @annotation.tailrec
  private def getFactors(n: Long, factor: Long, factors: List[Long]): List[Long] = {
    if (n == factor) factor :: factors
    else if (n % factor == 0) getFactors(n / factor, 2, factor :: factors)
    else getFactors(n, factor + 1, factors)
  }
}
