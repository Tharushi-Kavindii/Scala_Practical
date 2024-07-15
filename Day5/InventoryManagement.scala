object InventoryManagement{
def getProductList(products:List[String]) : List[String] = {

        val name = scala.io.StdIn.readLine("Enter product (or enter 'done' to finish): ");
        if (name != "done") getProductList(products :+ name);
        else products;
    }
def printProductList(products:List[String]): Any = {
    for(x <- products) 
    println((products.indexOf(x) + 1) + ":" + x );
}
def getTotalProducts(products:List[String]): Unit = {
    println(products.length);
}

def main(args: Array[String]): Unit = {
    val emptyList: List[String] = Nil;
    var productList = InventoryManagement.getProductList(emptyList);

    println("Product items are:");
    InventoryManagement.printProductList(productList);

    println("Length of the inventory: ");
    InventoryManagement.getTotalProducts(productList);
}
}
