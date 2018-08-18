object NthPrime {
  def prime(number: Int): Option[Int] = {
    number match {
      case 0 => None
      case 1 => Some(2)
      case n => {
        val stream = Stream.from(3, 2)
        Some(nth(stream, n - 1))
      }
    }
  }

  @annotation.tailrec
  private def nth(stream: Stream[Int], count: Int, nthPrime: Int = 0): Int = {
    if (count == 0) nthPrime
    else {
      val nextPrime = stream.head
      val nextStream = stream.tail.filter(candidate => candidate % nextPrime != 0)
      nth(nextStream, count - 1, nextPrime)
    }
  }
}
