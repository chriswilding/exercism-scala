import scala.util.Random

class Robot(var name: String = Robot.getName) {
  def reset() =
    this.name = Robot.getName
}

object Robot {
  val names: Iterator[String] = Random.shuffle(
    for {
      a <- 'A' to 'Z'
      b <- 'A' to 'Z'
      n <- 0 to 999
    } yield f"$a$b$n%03d"
  ).toIterator

  def getName(): String = {
    names.next
  }
}