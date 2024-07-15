def main(args: Array[String]): Unit = {

        def fibonacci(n:Int):Int= n match{
                case 0 => 0
                case x if x==1 => 1
                case _ => fibonacci(n-1)+fibonacci(n-2)
        }

        def fibonacciSeq(n:Int):Unit= {
                if (n > 0)  fibonacciSeq(n-1)
                println(fibonacci(n))
                }

        fibonacciSeq(15)
}