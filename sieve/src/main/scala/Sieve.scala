object Sieve {
  def primes(n: Int): List[Int] =
    if (n == 1) List.empty
    else {
      val candidates = 3.to(math.sqrt(n).toInt, 2).toList
      val numbers = 3.to(n, 2).toList
      val primes = candidates.foldLeft(numbers) {
        (primes, current) => primes.filter(i => i == current || i % current != 0)
      }
      2 :: primes
    }
}
