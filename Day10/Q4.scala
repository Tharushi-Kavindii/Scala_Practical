object fourth {
  def main(args: Array[String]): Unit = {
    val account1 = new Account("Alice", 1000)
    val account2 = new Account("Bob", -500)
    val account3 = new Account("Charlie", 2000)

    val bank = new Bank(List(account1, account2, account3))

    val accountsWithNegativeBalances = bank.getAccountsNegativeBalance()
    println("Accounts with negative balances:")
    accountsWithNegativeBalances.foreach(println)

    val totalBalance = bank.getTotalBalance()
    println(s"Total balance of all accounts: $totalBalance")

    bank.applyInterest()
    println("Final balances after applying interest:")
    bank.accounts.foreach(println)
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

  class Bank(val accounts: List[Account]) {
    def getAccountsNegativeBalance(): List[Account] = accounts.filter(_.balance < 0)

    def getTotalBalance(): Double = accounts.map(_.balance).sum

    def applyInterest(): Unit = {
      accounts.foreach(account => {
        if (account.balance > 0) {
          account.deposit(account.balance * 0.05)
        } else {
          account.balance += account.balance * 0.1
        }
      })
    }
  }
}
