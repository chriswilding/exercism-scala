object Darts {
  def score(x: Double, y: Double): Int = {
    val radius = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2))
    radius match {
      case r if r <= 1 => 10
      case r if r <= 5 => 5
      case r if r <= 10 => 1
      case _ => 0
    }
  }
}
