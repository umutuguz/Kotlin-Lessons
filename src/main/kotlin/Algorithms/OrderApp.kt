package Algorithms

abstract class Food(val name: String, val price: Double, internal val itemCount: Int) {
    abstract fun priceCal(): Double
}

class Noodles(itemCount: Int) : Food("Noodles", 10.0, itemCount) {
    override fun toString(): String = name

    override fun priceCal(): Double = itemCount * price
}

class Vegetables(itemCount: Int, private vararg val toppings: String) : Food("Vegetables", 2.5, itemCount) {
    override fun toString(): String {
        if (toppings.isEmpty()) {
            return "$name: Chef's Special"
        } else {
            return "$name: ${toppings.joinToString(", ")}"
        }
    }


    override fun priceCal(): Double = itemCount * price * toppings.size.toDouble()
}

class Order(private val orderNumber: Int, private val noodle: Noodles, private val vegetable: Vegetables) {

    // Bu yoldan da yapilabilir.
    private val itemList = mutableListOf<Food>()

    fun addItem(newItem: Food): Order {
        itemList.add(newItem)
        return this
    }

    fun addAll(newItems: List<Food>): Order {
        itemList.addAll(newItems)
        return this
    }


    fun orderPrint() {
        println("Order #$orderNumber")
        println("${noodle.itemCount} ${noodle.name}: $${noodle.priceCal()}")
        println("${vegetable.itemCount} $vegetable: $${vegetable.priceCal()}")
        println("Total price: $${noodle.priceCal() + vegetable.priceCal()} \n")
    }
}

fun main() {

    val noodles = Noodles(2)
    val vegetables = Vegetables(2, "Cabbage", "Sprouts", "Onion")
    val vegetables2 = Vegetables(3)
    val orderList = mutableListOf<Order>()

    val order1 = Order(1, noodles, vegetables)
    order1.orderPrint()
    orderList.add(order1)
    val order2 = Order(2, Noodles(1), Vegetables(1, "Onion", "Mushroom", "Olive"))
    order2.orderPrint()
    orderList.add(order2)
    val order3 = Order(3, Noodles(4), Vegetables(4, "Mushroom"))
    order3.orderPrint()
    orderList.add(order3)
}