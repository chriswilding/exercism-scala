class School {
  type DB = Map[Int, Seq[String]]

  var grades: DB = Map()

  def add(name: String, g: Int): Unit = {
    val seq = grade(g) :+ name
    grades = grades + (g -> seq)
  }

  def db: DB = grades

  def grade(g: Int): Seq[String] =
    grades.getOrElse(g, Seq.empty)

  def sorted: DB = grades.mapValues(_.sorted).toSeq.sortBy(_._1).toMap
}
