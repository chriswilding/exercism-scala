class DNA(strand: String) {
  private val validNucleotides = Map('A' -> 0, 'C' -> 0, 'G' -> 0, 'T' -> 0)

  def nucleotideCounts(): Either[Unit, Map[Char, Int]] = {
    val counts = validNucleotides ++ strand
      .groupBy(identity)
      .mapValues(_.length)

    if (counts.keySet == validNucleotides.keySet) Right(counts)
    else Left()
  }
}
