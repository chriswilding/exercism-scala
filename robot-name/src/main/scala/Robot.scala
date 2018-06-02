class Robot(var name: String = Robot.getName) {
  def reset() =
    this.name = Robot.getName
}

object Robot {
  var names = for {
    a <- 'A' to 'Z'
    b <- 'A' to 'Z'
    n <- 0 to 999
  } yield f"$a$b$n%03d"

  def getName(): String = {
    val name = names.head
    names = names.drop(1)
    name
  }
}