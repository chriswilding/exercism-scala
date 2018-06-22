object PythagoreanTriplet {
  def isPythagorean(triplet: (Int, Int, Int)): Boolean = {
    val a :: b :: c :: Nil = List(triplet._1, triplet._2, triplet._3).sorted
    math.pow(a, 2) + math.pow(b, 2) == math.pow(c, 2)
  }

  def pythagoreanTriplets(start: Int, end: Int): Seq[(Int, Int, Int)] = {
    val triplets = for {
      a <- start to end
      b <- (a + 1) to end
      c <- (b + 1) to end
      if isPythagorean((a, b, c))
    } yield (a, b, c)

    triplets.toSet.toSeq
  }
}
