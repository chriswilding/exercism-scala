object SecretHandshake {
  val flags = Map(
    1 -> "wink",
    2 -> "double blink",
    4 -> "close your eyes",
    8 -> "jump"
  )

  val reverse: Int = 16

  def commands(input: Int): List[String] = {
    val list = flags.foldLeft(List[String]())((acc, pair) =>
      if ((input & pair._1) > 0) pair._2 :: acc
      else acc
    )
    if ((input & reverse) > 0) list
    else list.reverse
  }
}