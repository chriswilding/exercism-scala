class Clock(val minutes: Int) {
  override def equals(other: Any): Boolean = other match {
    case that: Clock => this.minutes == that.minutes
    case _ => false
  }
  
  def + (other: Clock): Clock =
    Clock(this.minutes + other.minutes)

  def - (other: Clock): Clock =
    Clock(this.minutes - other.minutes)
}

object Clock {
  private val minutesInDay = 60 * 2

  def apply(hours: Int, minutes: Int): Clock =
    apply(hours * 60 + minutes)

  def apply(minutes: Int): Clock = {
    val remainder = minutes % minutesInDay
    if (remainder >= 0) new Clock(remainder)
    else new Clock(remainder + minutesInDay)
  }
}
