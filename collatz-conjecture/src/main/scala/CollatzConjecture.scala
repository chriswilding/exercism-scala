object CollatzConjecture {
  def steps(i: Int): Option[Int] = {
    if (i < 1) None
    else Some(calculate(i))
  }

  private def calculate(i: Int, step: Int = 0): Int =
    i match {
      case i if i == 1 => step
      case i if i % 2 == 0 => calculate(i / 2, step + 1)
      case i => calculate(i * 3 + 1, step + 1)
    }
}