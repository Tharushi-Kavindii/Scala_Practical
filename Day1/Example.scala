object Example {
  def easy(d1:Double):Double = 8*d1
  def tempo(d2:Double):Double = 7*d2
  def total(d1:Double,d2:Double,d3:Double) = easy(d1)+tempo(d2)+easy(d3)

  def main(args: Array[String]): Unit = {
    println(total(2,3,2))

  }

}
