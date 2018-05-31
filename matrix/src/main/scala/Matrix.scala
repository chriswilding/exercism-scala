class Matrix(val matrix: String) {
  def column(i: Int): Vector[Int] = {
    val rows = matrix.split('\n')
    rows.map(r => r.split(' ')(i).toInt).toVector
  }

  def row(i: Int): Vector[Int] = {
    val r = matrix.split('\n')(i)
    r.split(' ').map(_.toInt).toVector
  }
}

object Matrix {
  def apply(matrix: String): Matrix =
    new Matrix(matrix)
}
