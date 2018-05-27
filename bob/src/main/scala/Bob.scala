object Bob {
  def response(statement: String): String = {
    statement.trim match {
      case s if isSilence(s) =>
        "Fine. Be that way!"
      case s if isYell(s) && isQuestion(s) =>
        "Calm down, I know what I'm doing!"
      case s if isYell(s) =>
        "Whoa, chill out!"
      case s if isQuestion(s) =>
        "Sure."
      case _ =>
        "Whatever."
    }
  }

  private def isSilence(statement: String): Boolean =
    statement.isEmpty

  private def isYell(statement: String): Boolean =
    statement != statement.toLowerCase && statement == statement.toUpperCase

  private def isQuestion(statement: String): Boolean =
    statement.endsWith("?")
}