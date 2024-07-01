def sumOfEvenNumber(numbers: List[Int]): Int = {
    var sum = 0
    for (number <- numbers) {
      if (number % 2 == 0) {
        sum += number
      }
    }
    sum
  }

  def main(args: Array[String]): Unit = {
    val list = List(88, 53, 57, 95, 64, 32, 74, 81)
    val result = sumOfEvenNumber(list)
    println(result)  // Output: 258
  }