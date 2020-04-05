import scala.util.parsing.combinator.RegexParsers

class WordyParser extends RegexParsers {
    def begin: Parser[Unit] = "What is" ^^^ Unit

    def number: Parser[Int] =
        """-?\d+""".r ^^ { _.toInt }

    def operator: Parser[(Int, Int) => Int] = ("plus" | "minus" | "multiplied by" | "divided by") ^^ {
        case "plus" => (x, y) => x + y
        case "minus" => (x, y) => x - y
        case "multiplied by" => (x, y) => x * y
        case "divided by" => (x, y) => x / y
    }

    def end: Parser[Unit] = "?" ^^^ Unit

    def expression: Parser[Int] = {
        number ~ rep(operator ~ number) ^^ {
            case x ~ operatorAndY =>
                operatorAndY.foldLeft(x) {
                    case (x, opAndY) => opAndY._1(x, opAndY._2)
                }
        }
    }

    def question: Parser[Int] = {
        begin ~> expression <~ end
    }
}

object Wordy {
    def answer(input: String): Option[Int] = {
        val parser = new WordyParser
        val result = parser.parseAll(parser.question, input)
        result.map(Option.apply).getOrElse(None)
    }
}
