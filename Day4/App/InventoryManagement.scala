object InventoryManagement {

  var itemNames: Array[String] = Array("pen", "notebook", "eraser")
  var itemQuantities: Array[Int] = Array(20, 15, 30)

  def displayInventory(): Unit = {
    println("Current Inventory:")
    for (i <- itemNames.indices) {
      println(s"${itemNames(i)}: ${itemQuantities(i)}")
    }
    println()
  }

  def restockItem(itemName: String, quantity: Int): Unit = {
    val index = itemNames.indexOf(itemName)
    if (index != -1) {
      itemQuantities(index) += quantity
      println(s"Restocked $quantity of $itemName. New quantity: ${itemQuantities(index)}")
    } else {
      println(s"Item '$itemName' does not exist in the inventory.")
    }
  }

  def sellItem(itemName: String, quantity: Int): Unit = {
    val index = itemNames.indexOf(itemName)
    if (index != -1) {
      if (itemQuantities(index) >= quantity) {
        itemQuantities(index) -= quantity
        println(s"Sold $quantity of $itemName. Remaining quantity: ${itemQuantities(index)}")
      } else {
        println(s"Not enough quantity of '$itemName' to sell. Current quantity: ${itemQuantities(index)}")
      }
    } else {
      println(s"Item '$itemName' does not exist in the inventory.")
    }
  }

  def main(args: Array[String]): Unit = {
    displayInventory()


    restockItem("pen", 10)
    restockItem("notebook", 5)

    displayInventory()

    sellItem("eraser", 10)
    sellItem("notebook", 20)

    displayInventory()
  }
}
