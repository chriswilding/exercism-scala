object BinarySearch {
  def find(list: List[Int], item: Int): Option[Int] = {
    if (list == List.empty) None
    else binarySearch(list, 0, list.length - 1, item)
  }

  @annotation.tailrec
  private def binarySearch(list: List[Int], left: Int, right: Int, item: Int): Option[Int] = {
    val mid = (left + right) / 2
    val found = list(mid)

    if (left > right) None
    else if (found == item) Some(mid)
    else if (found > item) binarySearch(list, left, mid - 1, item)
    else binarySearch(list, mid + 1, right, item)
  }
}