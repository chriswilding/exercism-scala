object HighScores {
  def latest(scores: List[Int]): Int =
    scores.last

  def personalBest(scores: List[Int]): Int =
    scores.max

  def personalTop(scores: List[Int]): List[Int] =
    scores.sorted(Ordering.Int.reverse).take(3)

  def report(scores: List[Int]): String = {
    val l = latest(scores)
    val difference = personalBest(scores) - l

    if (difference > 0)
      s"Your latest score was $l. That's $difference short of your personal best!"
    else
      s"Your latest score was $l. That's your personal best!"
  }
}
