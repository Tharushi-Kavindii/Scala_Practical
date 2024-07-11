object FormatString{
  def toUpper(name: String): String = {
    name.toUpperCase
  }

  def toLower(name: String): String = {
    name.toLowerCase
  }

  def formatNames(name: String)(formatFunc: String => String): String = {
    formatFunc(name)
  }

  def main(args: Array[String]): Unit = {
    val names = List("Benny", "Niroshan", "Saman", "Kumara")

    names.foreach { name =>
      val formattedName = name match {
        case "Benny" => formatNames(name)(toUpper)
        case "Niroshan" => formatNames(name)(n => n.substring(0, 2).toUpperCase + n.substring(2))
        case "Saman" => formatNames(name)(toLower)
        case "Kumara" => formatNames(name)(n => n.substring(0, 1).toUpperCase + n.substring(1, n.length - 1).toLowerCase + n.substring(n.length - 1).toUpperCase)
        case _ => name
      }
      println(formattedName)
    }
  }
}