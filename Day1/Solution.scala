object Solution {
  def areaOfDisk (r:Int): Double = Math.PI*r*r
  def convertFahrenheit(temp:Int):Double = temp*1.8+32
  def volumeOfSphere(r:Int):Double = 4/3*Math.PI*r*r*r


  def main(args: Array[String]): Unit = {
    println(areaOfDisk(5))
    println(convertFahrenheit(35))
    println(volumeOfSphere(5))

  }

}
