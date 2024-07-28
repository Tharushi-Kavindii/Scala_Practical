def main(args: Array[String]): Unit = {

  case class Product(id: Int, name: String, quantity: Int, price: Double)

  val inventory1: Map[Int, Product] = Map(
    101 -> Product(101, "Laptop", 10, 999.99),
    102 -> Product(102, "Smartphone", 25, 499.99),
    103 -> Product(103, "Tablet", 15, 299.99)
  )

  val inventory2: Map[Int, Product] = Map(
    101 -> Product(101, "Laptop", 5, 1050.00),
    104 -> Product(104, "Smartwatch", 20, 199.99)
  )

  // I. Retrieve all product names from inventory1
  def getAllProductNames(inventory: Map[Int, Product]): List[String] = {
    inventory.values.map(_.name).toList
  }

  println(s"All product names in inventory1: ${getAllProductNames(inventory1)}")

  // II. Calculate the total value of all products in inventory1
  def getTotalValue(inventory: Map[Int, Product]): Double = {
    inventory.values.map(product => product.quantity * product.price).sum
  }

  println(s"Total value of all products in inventory1: ${getTotalValue(inventory1)}")

  // III. Check if inventory1 is empty
  def isEmpty(inventory: Map[Int, Product]): Boolean = {
    inventory.isEmpty
  }

  println(s"Is inventory1 empty? ${isEmpty(inventory1)}")

  // IV. Merge inventory1 and inventory2, updating quantities and retaining the highest price
  def mergeInventories(inv1: Map[Int, Product], inv2: Map[Int, Product]): Map[Int, Product] = {
    (inv1.keySet ++ inv2.keySet).map { id =>
      val prod1 = inv1.get(id)
      val prod2 = inv2.get(id)
      val mergedProduct = (prod1, prod2) match {
        case (Some(p1), Some(p2)) =>
          Product(p1.id, p1.name, p1.quantity + p2.quantity, math.max(p1.price, p2.price))
        case (Some(p1), None) => p1
        case (None, Some(p2)) => p2
        case _ => throw new IllegalStateException("Unexpected case when merging inventories")
      }
      id -> mergedProduct
    }.toMap
  }

  val mergedInventory = mergeInventories(inventory1, inventory2)
  println(s"Merged inventory: $mergedInventory")

  // V. Check if a product with a specific ID (e.g., 102) exists and print its details
  def getProductDetails(inventory: Map[Int, Product], productId: Int): Option[Product] = {
    inventory.get(productId)
  }

  getProductDetails(inventory1, 102) match {
    case Some(product) => println(s"Product details for ID 102: $product")
    case None => println("Product with ID 102 not found in inventory1.")
  }
}
