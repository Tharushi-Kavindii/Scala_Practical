object Example{
    def normal(hours:Int):Double = 250.00*hours
    def OT(hours:Int):Double = 85.00*hours
    def gross_Pay(h1:Int,h2:Int):Double = normal(h1) + OT(h2)
    def tax(gross_Pay:Double) :Double = gross_Pay*0.12
    def net_Pay(h1: Int, h2: Int): Double = {
    val gross = gross_Pay(h1, h2)
    gross - tax(gross)
  }

    def main(args: Array[String]): Unit = {
        println(net_Pay(40,30))

    }
}