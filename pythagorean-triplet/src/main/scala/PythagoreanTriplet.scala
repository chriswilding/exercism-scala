object PythagoreanTriplet {
  def isPythagorean(triplet: (Int, Int, Int)): Boolean = {
    val a :: b :: c :: Nil = List(triplet._1, triplet._2, triplet._3).sorted
    a * a + b * b == c * c
  }

  def pythagoreanTriplets(start: Int, end: Int): Seq[(Int, Int, Int)] =
    (start to end)
        .toList
        .combinations(3)
        .map { case a :: b :: c :: Nil => (a, b, c) }
        .filter(isPythagorean)
        .toSeq
}
