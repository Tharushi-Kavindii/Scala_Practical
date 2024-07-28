object Student{
  
  def main(args: Array[String]): Unit = {
    val studentRecord = getStudentInfoWithRetry()
    printStudentRecord(studentRecord)
  }

  def getStudentInfo(name: String, marks: Int, totalMarks: Int): (String, Int, Int, Double, Char) = {
    val percentage = (marks.toDouble / totalMarks) * 100
    val grade = percentage match {
      case p if p >= 90 => 'A'
      case p if p >= 75 => 'B'
      case p if p >= 50 => 'C'
      case _ => 'D'
    }
    (name, marks, totalMarks, percentage, grade)
  }

  def printStudentRecord(student: (String, Int, Int, Double, Char)): Unit = {
    val (name, marks, totalMarks, percentage, grade) = student
    println(s"Student Name: $name")
    println(s"Marks Obtained: $marks")
    println(s"Total Marks: $totalMarks")
    println(f"Percentage: $percentage%.2f%%")
    println(s"Grade: $grade")
  }

  def validateInput(name: String, marks: String, totalMarks: String): (Boolean, Option[String]) = {
    if (name.isEmpty) {
      (false, Some("Name cannot be empty."))
    } else {
      try {
        val m = marks.toInt
        val tm = totalMarks.toInt
        if (m >= 0 && m <= tm) (true, None)
        else (false, Some("Marks must be between 0 and the total possible marks."))
      } catch {
        case _: NumberFormatException => (false, Some("Marks and total possible marks must be integers."))
      }
    }
  }

  def getStudentInfoWithRetry(): (String, Int, Int, Double, Char) = {
    var valid = false
    var studentData: (String, Int, Int, Double, Char) = null
    while (!valid) {
      println("Enter student name:")
      val name = scala.io.StdIn.readLine()
      println("Enter marks obtained:")
      val marks = scala.io.StdIn.readLine()
      println("Enter total possible marks:")
      val totalMarks = scala.io.StdIn.readLine()

      val (isValid, errorMsg) = validateInput(name, marks, totalMarks)

      if (isValid) {
        studentData = getStudentInfo(name, marks.toInt, totalMarks.toInt)
        valid = true
      } else {
        println(s"Invalid input: ${errorMsg.getOrElse("Unknown error.")}")
      }
    }
    studentData
  }
}
