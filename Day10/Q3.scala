object third {
  def main(args: Array[String]): Unit = {
    val account1 = new Account("Alice", 1000)
    val account2 = new Account("Bob", 1500)

    println(account1)
    println(account2)

    account1.transfer(account2, 300)

    println(account1)
    println(account2)
  }
}

class Account(val accountHolder: String, var balance: Double) {
  def deposit(amount: Double): Unit = {
    require(amount > 0)
    balance += amount
  }

  def withdraw(amount: Double): Unit = {
    require(amount > 0)
    require(balance >= amount)
    balance -= amount
  }

  def transfer(targetAccount: Account, amount: Double): Unit = {
    require(amount > 0)
    require(balance >= amount)

    withdraw(amount)
    targetAccount.deposit(amount)
  }

  override def toString: String = s"Account Holder: $accountHolder, Balance: $balance"
}