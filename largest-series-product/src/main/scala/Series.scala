object Series {
  def largestProduct(length: Int, digits: String): Option[Int] = {
    if (length > digits.length) None
    else if (length < 0) None
    else if (digits.exists(!_.isDigit)) None
    else if (length == 0) Some(1)
    else {
      val result = digits
        .map(_.asDigit)
        .sliding(length)
        .map(_.product).toList
        .max
      Some(result)
    }
  }
}