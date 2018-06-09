object ProteinTranslation {
  def proteins(rna: String): Seq[String] =
    rna.grouped(3).map({
      case "AUG" => "Methionine"
      case "UUU" => "Phenylalanine"
      case "UUC" => "Phenylalanine"
      case "UUA" => "Leucine"
      case "UUG" => "Leucine"
      case "UCU" => "Serine"
      case "UCC" => "Serine"
      case "UCA" => "Serine"
      case "UCG" => "Serine"
      case "UAU" => "Tyrosine"
      case "UAC" => "Tyrosine"
      case "UGU" => "Cysteine"
      case "UGC" => "Cysteine"
      case "UGG" => "Tryptophan"
      case "UAA" => "STOP"
      case "UAG" => "STOP"
      case "UGA" => "STOP"
    }).takeWhile(_ != "STOP").toSeq
}
