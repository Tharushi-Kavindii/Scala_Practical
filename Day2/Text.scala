object Text{
    def attendees(price:Int):Int = 120+(15-price)/5+20
    def revenue(price:Int):Int = attendees(price)*price
    def cost(price:Int):Int = 500 + 3*attendees(price)
    def profit(price:Int):Double = revenue(price) - cost(price)

    def main(args: Array[String]): Unit = {
        println(profit(25))
        println(profit(20))
    }
}