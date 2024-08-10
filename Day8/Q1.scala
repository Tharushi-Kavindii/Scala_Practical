object Caesarcipher {
  def encrypt(text: String, shift: Int): String = {
    text.map { char =>
      if (char.isLetter) {
        val base = if (char.isUpper) 'A' else 'a'
        val shiftedChar = ((char - base + shift) % 26 + base).toChar
        if (shiftedChar < base) (shiftedChar + 26).toChar else shiftedChar
      } else {
        char
      }
    }
  }


  def decrypt(text: String, shift: Int): String = {
    encrypt(text, -shift)
  }


//   def cipher(data: String, func: (String, Int) => String, shift: Int): String = {
//     func(data, shift)
//   }

  def main(args: Array[String]): Unit = {
    print("Enter: ")
    var str=scala.io.StdIn.readLine()
    val shift = 1


    val eText = encrypt(str, shift)
    println("Encrypted: " + eText)


    val dText = decrypt(eText, shift)
    println("Decrypted: " + dText)
  }
}