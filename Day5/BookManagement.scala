case class Book(title: String, author: String, isbn: String);

object LibraryManagement {

  var library: Set[Book] = Set(
    Book("be You", "Geo nedwick", "978"),
    Book("To the Moon", "Harmen doily", "979"),
    Book("The Prince", "fansis holaman", "980")
  )

  //add a new book 
  def addBook(book: Book): Unit = {
    library += book;
    println(s"Book added: $book");
  }

  //remove a book
  def removeBookByISBN(isbn: String): Unit = {
    library.foreach { x => 
        if (x.isbn == isbn) library -= x;
    }
    println(s"Book with ISBN $isbn removed.");
  }

  //checking the availability
  def isBookInLibrary(isbn: String): Boolean = {
  var found = false;
  library.foreach { x => 
    if (x.isbn == isbn) found = true };
  found; 
 }

  //display the current library
  def displayLibrary(): Unit = {
    println("Current Library Collection:");
    library.foreach {x => 
        println(s"Title: ${x.title}, Author: ${x.author}, ISBN: ${x.isbn}")};
        
  }

  //search for a book
  def searchBookByTitle(title: String): Unit = {
    library.foreach { x => if (x.title == title) 
        println(s"Found Book - Title: ${x.title}, Author: ${x.author}, ISBN: ${x.isbn}")};
  }
   

  //display all books by a specific author
  def displayBooksByAuthor(author: String): Unit = {
    library.foreach { x => if (x.author == author)
        println(s"Title: ${x.title}, Author: ${x.author}, ISBN: ${x.isbn}")};
  }
}


  def main(args: Array[String]): Unit = {

    println();
    LibraryManagement.displayLibrary();
    println();

    println("Adding a new book...");
    LibraryManagement.addBook(Book("Brave New World", "Aldous Huxley", "981"));
    LibraryManagement.displayLibrary();
    println();

    println("Removing a book...");
    LibraryManagement.removeBookByISBN("978");
    LibraryManagement.displayLibrary();
    println();

    println("Checking if a book with ISBN ");
    var found = LibraryManagement.isBookInLibrary("979")
    println(found);
    println();

    println("Searching for a book ");
    LibraryManagement.searchBookByTitle("The Prince");
    println();

    println("Displaying all books");
    LibraryManagement.displayBooksByAuthor("Aldous Huxley");
    println();
    
  }