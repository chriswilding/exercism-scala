object House {
  var things = Array(
    "the house",
    "the malt",
    "the rat",
    "the cat",
    "the dog",
    "the cow with the crumpled horn",
    "the maiden all forlorn",
    "the man all tattered and torn",
    "the priest all shaven and shorn",
    "the rooster that crowed in the morn",
    "the farmer sowing his corn",
    "the horse and the hound and the horn"
  )

  val verbs = Array(
    "that Jack built.",
    "that lay in",
    "that ate",
    "that killed",
    "that worried",
    "that tossed",
    "that milked",
    "that kissed",
    "that married",
    "that woke",
    "that kept",
    "that belonged to"
  )

  def recite(from: Int, to: Int): String =
    (from - 1).until(to).map(verse).mkString + "\n"

  private def verse(n: Int): String = {
    val body = n.to(0, -1).map(
      line => "%s %s".format(things(line), verbs(line))
    ).mkString(" ")

    s"This is $body\n"
  }
}
