object BracketPush {
  private val map = Map(
    '[' -> ']',
    '{' -> '}',
    '(' -> ')'
  )
  private val left = map.keySet
  private val right = map.values.toSet
  private val brackets = left ++ right

  def isPaired(input: String): Boolean = {
    @annotation.tailrec
    def loop(chars: List[Char], stack: List[Char]): Boolean = {
      (chars, stack) match {
        case (Nil, Nil) => true
        case (ch :: ct, s) if !brackets.contains(ch) => loop(ct, s)
        case (ch :: ct, s) if left.contains(ch) => loop(ct, ch :: s)
        case (ch :: ct, sh :: st) if right.contains(ch) && ch == map(sh) => loop(ct, st)
        case _ => false
      }
    }
    loop(input.toList, List.empty)
  }
}
