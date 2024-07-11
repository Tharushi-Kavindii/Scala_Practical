object InventoryManagement extends App {

  var item: Array[String] = Array("pen", "notebook", "eraser")
  var quantities: Array[Int] = Array(20, 15, 30)

  def displayInventory(): Unit = {
    println("Current Inventory:")
    for (i <- item.indices) {
      println(s"${item(i)}: ${quantities(i)}")
    }
    println()
  }

  def restockItem(itemName: String, quantity: Int): Unit = {
    val index = item.indexOf(itemName)
    if (index != -1) {
      quantities(index) += quantity
      println(s"Restocked $quantity of $itemName. New quantity: ${quantities(index)}")
    } else {
      println(s"Item '$itemName' does not exist in the inventory.")
    }
  }

  def sellItem(itemName: String, quantity: Int): Unit = {
    val index = item.indexOf(itemName)
    if (index != -1) {
      if (quantities(index) >= quantity) {
        quantities(index) -= quantity
        println(s"Sold $quantity of $itemName. Remaining quantity: ${quantities(index)}")
      } else {
        println(s"Not enough quantity of '$itemName' to sell. Current quantity: ${quantities(index)}")
      }
    } else {
      println(s"Item '$itemName' does not exist in the inventory.")
    }
  }

  displayInventory()

  restockItem("pen", 10)
  restockItem("notebook", 5)

  displayInventory()

  sellItem("eraser", 10)
  sellItem("notebook", 20)

  displayInventory()
}
