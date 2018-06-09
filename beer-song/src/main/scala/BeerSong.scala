class BottleNumber(val number: Int) {
  val action = "Take one down and pass it around"
  val container = "bottles"
  val quantity: String = number.toString

  def next: BottleNumber = BottleNumber(number - 1)

  override def toString: String =
    s"$quantity $container"
}

class BottleNumber1() extends BottleNumber(1) {
  override val action = "Take it down and pass it around"
  override val container = "bottle"
}

class BottleNumber0() extends BottleNumber(0) {
  override val action = "Go to the store and buy some more"
  override val quantity = "no more"

  override def next: BottleNumber = BottleNumber(99)
}

object BottleNumber {
  def apply(n: Int): BottleNumber = {
    n match {
      case 0 => new BottleNumber0()
      case 1 => new BottleNumber1()
      case _ => new BottleNumber(n)
    }
  }
}

object BeerSong {
  def recite(from: Int, verses: Int): String = {
    from.until(from - verses, -1).map(n => verse(n)).mkString("\n")
  }

  def verse(number: Int): String = {
    val bottleNumber = BottleNumber(number)
    val action = bottleNumber.action
    val nextBottleNumber = bottleNumber.next

    s"$bottleNumber of beer on the wall, $bottleNumber of beer.\n".capitalize +
      s"$action, $nextBottleNumber of beer on the wall.\n"
  }
}
