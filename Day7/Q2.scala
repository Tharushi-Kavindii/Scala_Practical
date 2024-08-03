def calculateSquare(numbers:List[Int]):List[Int] ={
    numbers.map(n => n * n)
}

def main(args: Array[String]): Unit = {
    val l =List(1,2,3,4,5);

    val res = calculateSquare(l);
    println(res)
}