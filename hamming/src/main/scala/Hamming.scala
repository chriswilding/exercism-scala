object Hamming {
  def distance(strandA: String, strandB: String): Option[Int] =
    if (strandA.length != strandB.length)
      None
    else
      Some((strandA zip strandB).count(Function.tupled((a, b) => a != b)))
}
