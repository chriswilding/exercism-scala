object Bob {
  def response(statement: String): String = {
    if (isSilence(statement)) "Fine. Be that way!"
    else if (isYellQuestion(statement)) "Calm down, I know what I'm doing!"
    else if (isYell(statement)) "Whoa, chill out!"
    else if (isQuestion(statement)) "Sure."
    else "Whatever."
  }

  private def isSilence(statement: String): Boolean =
    statement.trim.isEmpty

  private def isYellQuestion(statement: String): Boolean =
    isYell(statement) && isQuestion(statement)

  private def isYell(statement: String): Boolean =
    statement != statement.toLowerCase && statement == statement.toUpperCase

  private def isQuestion(statement: String): Boolean =
    statement.trim.endsWith("?")
}