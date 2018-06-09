object Sieve {
  def primes(n: Int): List[Int] =
    if (n == 1) List.empty
    else {
      val candidates = 3.to(n, 2).toList
      2 :: sieve(candidates, List.empty).reverse
    }

  @annotation.tailrec
  private def sieve(candidates: List[Int], primes: List[Int]): List[Int] =
    candidates match {
      case Nil => primes
      case head :: tail => sieve(tail.filter(n => n % head != 0), head :: primes)
    }
}
