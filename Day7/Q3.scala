def filterPrime(numbers:List[Int]):List[Int] ={
    def isPrime(n:Int):Boolean = {
        if(n <= 1) false
        else if (n == 2) true
        else !(2 until n).exists(i => n % i == 0)
    }
    numbers.filter(n => isPrime(n))
}

def main(args: Array[String]): Unit = {
    val l =List(1,2,3,4,5,6,7,8,9,10);

    val res = filterPrime(l);
    println(res)
}