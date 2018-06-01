object PhoneNumber {
  def clean(input: String): Option[String] = {
    val string: String = input.filter(_.isDigit)
    val first = string(0)
    val fourth = string(3)

    if (string.length == 10 && first != '0' && first != '1' && fourth != '0' && fourth != '1')
      Some(string)
    else if (string.length == 11 && first == '1')
      Some(string.drop(1))
    else
      None
  }
}