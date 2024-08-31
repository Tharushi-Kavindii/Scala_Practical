object first{
    class Rational(n:Int, d:Int){
        require(d!=0);

        def neg:Rational = new Rational (-n, d)

        override def toString(): String = s"$n/$d"
    }
    def main(args: Array[String]): Unit = {
        val x = new Rational(1,2)
        val y = x.neg

        println(y)
    }
}