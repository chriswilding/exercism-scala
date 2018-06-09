object Sieve {
  def primes(n: Int): List[Int] =
    if (n == 1) List.empty
    else {
      val candidates = 3.to(n, 2).toList
      val primes = candidates.foldLeft(candidates) {
        (primes, current) => primes.filter(i => i == current || i % current != 0)
      }
      2 :: primes
    }
}
