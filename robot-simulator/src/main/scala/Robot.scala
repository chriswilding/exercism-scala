object Bearing extends Enumeration {
  val North, South, East, West = Value
}

class Robot(val bearing: Bearing.Value, val position: (Int, Int)) {
  val left = Map(
    Bearing.North -> Bearing.West,
    Bearing.South -> Bearing.East,
    Bearing.East -> Bearing.North,
    Bearing.West -> Bearing.South
  )

  val right = Map(
    Bearing.North -> Bearing.East,
    Bearing.South -> Bearing.West,
    Bearing.East -> Bearing.South,
    Bearing.West -> Bearing.North
  )

  def advance: Robot =
    this.bearing match {
      case Bearing.North => Robot(this.bearing, (coordinates._1, coordinates._2 + 1))
      case Bearing.South => Robot(this.bearing, (coordinates._1, coordinates._2 - 1))
      case Bearing.East => Robot(this.bearing, (coordinates._1 + 1, coordinates._2))
      case Bearing.West => Robot(this.bearing, (coordinates._1 - 1, coordinates._2))
    }

  def coordinates(): (Int, Int) = position

  def simulate(instructions: String): Robot = {
    instructions.foldLeft(this)((robot, instruction) => instruction match {
      case 'A' => robot.advance
      case 'L' => robot.turnLeft
      case 'R' => robot.turnRight
    })
  }

  def turnLeft: Robot = Robot(left(this.bearing), this.position)

  def turnRight: Robot = Robot(right(this.bearing), this.position)

  override def equals(other: Any): Boolean = other match {
    case that: Robot => this.bearing == that.bearing && this.position == that.position
    case _ => false
  }
}

object Robot {
  def apply(bearing: Bearing.Value, position: (Int, Int)): Robot =
    new Robot(bearing, position)
}