case class Triangle(a: Double, b: Double, c: Double) {
  def equilateral(): Boolean =
    isTriangle && a == b && b == c

  def isosceles(): Boolean =
    isTriangle && (a == b || b == c || c == a)

  def scalene(): Boolean =
    isTriangle && !equilateral && !isosceles

  private def isTriangle(): Boolean =
    a > 0 && b > 0 && c > 0 && a + b > c && b + c > a && c + a > b
}