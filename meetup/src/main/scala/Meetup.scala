import java.time.{DayOfWeek, LocalDate}

import Schedule.Schedule

case class Meetup(month: Int, year: Int) {

  def day(dayOfWeek: Int, schedule: Schedule): LocalDate = {
    val lengthOfMonth = LocalDate.of(year, month, 1).lengthOfMonth()
    val daysInMonth = (1 to lengthOfMonth).map(LocalDate.of(year, month, _))

    schedule match {
      case Schedule.Teenth => daysInMonth.find(date =>
        date.getDayOfMonth > 12 && date.getDayOfMonth < 20 && date.getDayOfWeek.getValue == dayOfWeek).get
      case Schedule.First => daysInMonth.find(date => date.getDayOfWeek.getValue == dayOfWeek).get
      case Schedule.Second => daysInMonth.filter(date => date.getDayOfWeek.getValue == dayOfWeek).slice(1, 2)(0)
      case Schedule.Third => daysInMonth.filter(date => date.getDayOfWeek.getValue == dayOfWeek).slice(2, 3)(0)
      case Schedule.Fourth => daysInMonth.filter(date => date.getDayOfWeek.getValue == dayOfWeek).slice(3, 4)(0)
      case Schedule.Last => daysInMonth.reverse.find(date => date.getDayOfWeek.getValue == dayOfWeek).get
    }
  }
}

object Schedule extends Enumeration {
  type Schedule = Value
  val Teenth, First, Second, Third, Fourth, Last = Value
}

object Meetup {
  val Mon = DayOfWeek.MONDAY.getValue
  val Tue = DayOfWeek.TUESDAY.getValue
  val Wed = DayOfWeek.WEDNESDAY.getValue
  val Thu = DayOfWeek.THURSDAY.getValue
  val Fri = DayOfWeek.FRIDAY.getValue
  val Sat = DayOfWeek.SATURDAY.getValue
  val Sun = DayOfWeek.SUNDAY.getValue
}
