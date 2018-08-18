object NthPrime {
  def prime(number: Int): Option[Int] = {
    number match {
      case 0 => None
      case 1 => Some(2)
      case n => {
        val stream = Stream.from(3, 2)
        buildPrimes(stream, n - 1, List.empty).headOption
      }
    }
  }

  @annotation.tailrec
  private def buildPrimes(stream: Stream[Int], count: Int, primes: List[Int]): List[Int] = {
    if (count == 0) primes
    else {
      val prime = stream.head
      val nextStream = stream.tail.filter(candidate => candidate % prime != 0)
      buildPrimes(nextStream, count - 1, prime :: primes)
    }
  }
}
