object InterestCalculator {
  def main(args: Array[String]): Unit = {
    val deposit1 = 50000.0
    var interestEarned = calculateInterest(deposit1)
    println(f"Interest earned for a deposit of Rs. $deposit1%.2f is Rs. $interestEarned%.2f")
    val deposit2 = 150000.0
    interestEarned = calculateInterest(deposit2)
    println(f"Interest earned for a deposit of Rs. $deposit2%.2f is Rs. $interestEarned%.2f")
  }

  def calculateInterest(depositAmount: Double): Double = {
    val interestRate: Double => Double = amount => amount match {
      case x if x <= 20000 => 0.02
      case x if x <= 200000 => 0.04
      case x if x <= 2000000 => 0.035
      case _ => 0.065
    }
    
    // Calculate the interest
    depositAmount * interestRate(depositAmount)
  }
}