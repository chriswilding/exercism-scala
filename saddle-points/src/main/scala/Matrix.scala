case class Matrix(matrix: List[List[Int]]) {
  def saddlePoints(): Set[(Int, Int)] = {
    if (matrix.forall(row => row.isEmpty)) Set.empty
    else getSaddlePoints()
  }

  private def getSaddlePoints(): Set[(Int, Int)] = {
    val largest = matrix.flatMap(row => {
      val max = row.max
      row.zipWithIndex.filter(
        Function.tupled((value, _) => value == max)
      )
    })

    largest
      .foldLeft(Set.empty[(Int, Int)])(
        (acc, rowWithIndex) => {
          val column = matrix.map(column => column(rowWithIndex._2))
          val min = column.min
          val smallest = column.zipWithIndex.filter(
            Function.tupled((value, _) => value == min)
          )

          smallest.foldLeft(acc)(
            (acc, columnWithIndex) => {
              if (columnWithIndex._1 == rowWithIndex._1) {
                acc + ((columnWithIndex._2, rowWithIndex._2))
              } else acc
            }
          )
        }
      )
  }
}
