object Demo {
  def bookPrice(n:Int): Double = 24.95*n
  def discount(p: Double): Double = p * 0.4
  def price(n:Int):Double = bookPrice(n) - discount(bookPrice(n))
  def shippingCost(n:Int) :Double = if(n<=50) n*3 else 50*3+(n-50)*0.75
  def totalPrice(n:Int):Double = price(n)+shippingCost(n)


  def main(args: Array[String]): Unit = {
    println(totalPrice(60))

  }

}
