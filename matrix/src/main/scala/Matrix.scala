class Matrix(input: String) {
  private val matrix = input.split('\n')
    .map(_.split(' ').map(_.toInt).toVector)
    .toVector

  def column(i: Int): Vector[Int] =
    matrix.map(_(i))
  
  def row(i: Int): Vector[Int] =
    matrix(i)
}

object Matrix {
  def apply(matrix: String): Matrix =
    new Matrix(matrix)
}
