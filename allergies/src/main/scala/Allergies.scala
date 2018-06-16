object Allergies {
  def allergicTo(allergen: Allergen.Value, score: Int): Boolean =
    (allergen.id & score) > 0

  def list(score: Int): List[Allergen.Value] =
    Allergen
      .values
      .filter(allergicTo(_, score))
      .toList
}

object Allergen extends Enumeration {
  val Eggs = Value(1)
  val Peanuts = Value(2)
  val Shellfish = Value(4)
  val Strawberries = Value(8)
  val Tomatoes = Value(16)
  val Chocolate = Value(32)
  val Pollen = Value(64)
  val Cats = Value(128)
}
