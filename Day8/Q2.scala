def main(args: Array[String]): Unit = {
  
  print("Please enter an integer:")
  val input = scala.io.StdIn.readInt()

  val isMultipleOfThree: Int => Boolean = _ % 3 == 0
  val isMultipleOfFive: Int => Boolean = _ % 5 == 0

  // Use pattern matching to categorize the number
  val message = (input: Int) match {
    case x if isMultipleOfThree(x) && isMultipleOfFive(x) => "Multiple of Both Three and Five"
    case x if isMultipleOfThree(x) => "Multiple of Three"
    case x if isMultipleOfFive(x) => "Multiple of Five"
    case _ => "Not a Multiple of Three or Five"
  }

  // Print the result
  println(message)
}
