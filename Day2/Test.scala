object Test{

    def main(args: Array[String]): Unit = {
    var a: Int = 2
    var b: Int = 3
    var c: Int = 4
    var d: Int = 5
    var k: Float = 4.3f
    var g: Float = 2.1f

    b -= 1
    println(b * a + c * d) // Evaluating the expression after decrementing b
    d -= 1

    println(a) // Printing a after incrementing
    a += 1

    println((-2) * (g - k) + c) // Evaluating the expression

    println(c) // Printing c
    c +=1

    c += 1 
    c = c * a
    println(c) // Printing c after multiplication
    a += 1
  }
}