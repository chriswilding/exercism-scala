object Luhn {
    def valid(inputWithSpaces: String): Boolean = {
        val input = inputWithSpaces.toList.filterNot(_.isSpaceChar)

        if (input.length < 2) false
        else if (input.exists(!_.isDigit)) false
        else {
            val sum = input.reverse.zipWithIndex.map { charIndex =>
                val number = charIndex._1.toInt - 48
                val index = charIndex._2
                if (index % 2 == 0) number
                else {
                    val double = number * 2
                    if (double > 9) double - 9 else double
                }
            }.sum
            sum % 10 == 0
        }
    }
}
