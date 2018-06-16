object Allergies {
  def allergicTo(allergen: Allergen.Value, score: Int): Boolean =
    ((1 << allergen.id) & score) > 0

  def list(score: Int): List[Allergen.Value] =
    Allergen
      .values
      .filter(allergicTo(_, score))
      .toList
}

object Allergen extends Enumeration {
  val Eggs, Peanuts, Shellfish, Strawberries, Tomatoes, Chocolate, Pollen, Cats = Value
}
