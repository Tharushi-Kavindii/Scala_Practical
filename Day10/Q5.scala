object fifth {
  def main(args: Array[String]): Unit = {
    val words = List("apple", "banana", "cherry", "date")
    val t_Count = countLetterOccurrences(words)
    println(s"Total count of letter occurrences: $t_Count")
  }

  def countLetterOccurrences(words: List[String]): Int = {
    val w_Lengths = words.map(word => word.length)
    val totalLetterOccurrences =
      w_Lengths.reduce((total, length) => total + length)

    totalLetterOccurrences
  }
}