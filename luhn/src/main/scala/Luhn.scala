object Luhn {
    def valid(inputWithSpaces: String): Boolean = {
        val input = inputWithSpaces.toList.filterNot(_.isSpaceChar)

        if (input.length < 2) false
        else if (input.exists(!_.isDigit)) false
        else {
            val sum = input.reverse.zipWithIndex.map {
                case (char, index) if index % 2 == 0 => char.asDigit
                case (char, _) => {
                    val double = char.asDigit * 2
                    if (double > 9) double - 9 else double
                }
            }.sum
            sum % 10 == 0
        }
    }
}
