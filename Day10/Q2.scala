object second{
    class Rational(n:Int, d:Int){
        require(d!=0);

        private val gcdValue :Int = gcd(n.abs,d.abs)
        val numer :Int = n/gcdValue
        val denom = d /gcdValue

        def this(n:Int) = this(n,1)

        private def gcd(a:Int, b:Int) :Int = if (b == 0) a else gcd(b, a % b)

        def sub(other:Rational):Rational =
            new Rational(numer * other.denom - other.numer*denom,denom * other.denom)

        override def toString(): String = s"$numer/$denom"
    }
    def main(args: Array[String]): Unit = {
        val x = new Rational(3,4)
        val y = new Rational(5,8)
        val z = new Rational(2,7)

        val result = x.sub(y).sub(z)

        println(result)
    }
}