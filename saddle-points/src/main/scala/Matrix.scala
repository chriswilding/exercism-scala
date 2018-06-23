case class Matrix(rows: List[List[Int]]) {
  val columns = rows.transpose

  def saddlePoints(): Set[(Int, Int)] = {
    val saddlePoints = for (
      x <- rows.indices;
      y <- columns.indices
      if rows(x).max == columns(y).min
    ) yield (x, y)
    saddlePoints.toSet
  }
}
