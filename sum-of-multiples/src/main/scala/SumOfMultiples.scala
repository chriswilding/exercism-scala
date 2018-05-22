object SumOfMultiples {
  def sum(factors: Set[Int], limit: Int): Int =
    if (factors.isEmpty) 0
    else {
      val sumOfMultiples = factors
        .map(factor => sumOfMultiples(factor, limit))
        .sum

    }

  private def sumOfMultiples(factor: Int, limit: Int): Int =
    ((0.5 * limit * (limit + 1)) / factor).toInt
}