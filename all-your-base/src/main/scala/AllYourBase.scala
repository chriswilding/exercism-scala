import scala.math.Integral.Implicits._

object AllYourBase {
  def rebase(from: Int, digits: List[Int], to: Int): Option[List[Int]] =
    if (from < 2 || to < 2 || digits.exists(d => d < 0 || d >= from)) None
    else {
      val base10 = toBase10(from, digits)
      if (base10 == 0) Some(List(0))
      else Some(toBase(to, base10))
    }

  private def toBase10(from: Int, digits: List[Int]): Int =
    digits
      .reverse
      .zipWithIndex
      .map(nWithIndex => nWithIndex._1 * math.pow(from, nWithIndex._2).toInt)
      .sum

  @annotation.tailrec
  private def toBase(to: Int, base10: Int, digits: List[Int] = List.empty): List[Int] =
    if (base10 == 0) digits
    else {
      val (quotient, remainder) = base10 /% to
      toBase(to, quotient, remainder :: digits)
    }
}
