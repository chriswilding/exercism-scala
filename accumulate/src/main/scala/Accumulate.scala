class Accumulate {
  def accumulate[A, B](f: (A) => B, list : List[A]): List[B] =
    for {
      item <- list
    } yield f(item)
}
