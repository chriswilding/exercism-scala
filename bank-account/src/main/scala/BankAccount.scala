trait BankAccount {

  def closeAccount(): Unit

  def getBalance: Option[Int]

  def incrementBalance(increment: Int): Option[Int]
}

object Bank {
  def openAccount(): BankAccount = new BankAccountImpl()
}

class BankAccountImpl extends BankAccount {
  var open = true
  var balance = 0

  override def closeAccount(): Unit =
    synchronized {
      open = false
    }

  override def getBalance: Option[Int] =
    synchronized {
      if (open) Some(balance)
      else None
    }

  override def incrementBalance(increment: Int): Option[Int] =
    synchronized {
      if (open) {
        balance += increment
        Some(balance)
      }
      else None
    }
}

