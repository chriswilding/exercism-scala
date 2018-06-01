object Raindrops {
  def convert(n: Int): String = {
    val primeFactors = Seq(3, 5, 7).filter(n % _ == 0)

    if (primeFactors.isEmpty)
      n.toString
    else
      primeFactors.map {
        case 3 => "Pling"
        case 5 => "Plang"
        case 7 => "Plong"
      }.mkString
  }
}