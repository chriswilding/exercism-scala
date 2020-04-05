case class Queen(x: Int, y: Int)

object Queen {
    def create(x: Int, y: Int): Option[Queen] = {
        if (isValid(x) && isValid(y)) Some(Queen(x, y))
        else None
    }

    private def isValid(position: Int) =
        position >= 0 && position <= 7
}

object QueenAttack {
    def canAttack(white: Queen, black: Queen): Boolean =
        white.x == black.x || white.y == black.y || Math.abs(white.x - black.x) == Math.abs(white.y - black.y)
}
