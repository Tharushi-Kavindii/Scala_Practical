def stringLength(strings: List[String]): List[String] ={
    strings.filter(_.length>5)
}
def main(args: Array[String]): Unit = {
    val list =List("Apple","Mango","Banana","Pear","Orange");
    val result = stringLength(list);
    println(result);
}