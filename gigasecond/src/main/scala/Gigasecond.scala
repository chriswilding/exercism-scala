import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneOffset

object Gigasecond {
  val gigasecond = 1000000000
  val secondsInDay = 60 * 60 * 24

  def add(startDate: LocalDate): LocalDateTime = {
    val start = startDate.toEpochDay() * secondsInDay + gigasecond
    LocalDateTime.ofEpochSecond(start, 0, ZoneOffset.UTC)
  }

  def add(startDateTime: LocalDateTime): LocalDateTime = {
    val start = startDateTime.toEpochSecond(ZoneOffset.UTC) + gigasecond
    LocalDateTime.ofEpochSecond(start, 0, ZoneOffset.UTC)
  }
}