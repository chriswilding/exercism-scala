import java.time.{DayOfWeek, LocalDate, YearMonth}

import Schedule.Schedule

case class Meetup(month: Int, year: Int) {

  def day(dayOfWeek: Int, schedule: Schedule): LocalDate = {
    val range = schedule match {
      case Schedule.Teenth => Stream.range(13, 20)
      case Schedule.First => Stream.range(1, 8)
      case Schedule.Second => Stream.range(8, 15)
      case Schedule.Third => Stream.range(15, 22)
      case Schedule.Fourth => Stream.range(22, 29)
      case Schedule.Last => {
        val lengthOfMonth = YearMonth.of(year, month).lengthOfMonth()
        Stream.range(lengthOfMonth, lengthOfMonth - 7, -1)
      }
    }

    range
      .map(LocalDate.of(year, month, _))
      .find(_.getDayOfWeek.getValue == dayOfWeek)
      .get
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
