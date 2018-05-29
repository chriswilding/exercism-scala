object Etl {
  def transform(data: Map[Int, Seq[String]]): Map[String, Int] = {
    data.toSeq.flatMap(pair => pair._2.map(letter => letter.toLowerCase -> pair._1)).toMap
  }
}