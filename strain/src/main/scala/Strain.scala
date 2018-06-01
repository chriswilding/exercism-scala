object Strain {
  def keep[A](seq: Seq[A], f: A => Boolean): Seq[A] =
    for (item <- seq if f(item)) yield item

  def discard[A](seq: Seq[A], f: A => Boolean): Seq[A] =
    for (item <- seq if !f(item)) yield item
}