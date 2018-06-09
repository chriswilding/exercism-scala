object Series {
  def slices(length: Int, string: String): List[List[Int]] =
    string.map(_.asDigit).toList.sliding(length).toList
}
