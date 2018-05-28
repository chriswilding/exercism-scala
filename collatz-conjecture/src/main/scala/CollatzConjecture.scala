object CollatzConjecture {
  def steps(n: Int, step: Int = 0): Option[Int] = {
    n match {
      case n if n < 1 => None
      case 1 => Some(step)
      case even if n % 2 == 0 => steps(even / 2, step + 1)
      case odd => steps(odd * 3 + 1, step + 1)
    }
  }
}