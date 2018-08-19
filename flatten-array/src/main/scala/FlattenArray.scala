object FlattenArray {
  def flatten(list: Any, next: List[Any] = List.empty): List[Any] =
    list match {
      case (head: List[Any]) :: tail => flatten(head, tail :: next)
      case null :: tail => flatten(tail, next)
      case head :: tail => head :: flatten(tail, next)
      case Nil if next.isEmpty => Nil
      case Nil => flatten(next.head, next.tail)
    }
}
