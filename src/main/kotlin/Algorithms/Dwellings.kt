package Algorithms

import kotlin.math.PI
import kotlin.math.sqrt

abstract class Dwelling(private var residents: Int) {
    abstract val buildingMaterial: String
    abstract val capacity: Int

    fun hasRoom(): Boolean = capacity > residents

    abstract fun calculateArea(): Double

    fun getRoom() {
        if (hasRoom()) {
            residents++
            println("You have got a room. Have a nice day!")
        } else {
            println("All rooms are occupied. You can not get a room!")
        }
    }
}

class SquareCabin(residents: Int, val length: Double) : Dwelling(residents) {
    override val buildingMaterial = "Wood"

    override val capacity: Int = 6

    override fun calculateArea(): Double = length * length
}

open class RoundHut(residents: Int, private val radius: Double) : Dwelling(residents) {
    override val buildingMaterial: String
        get() = "Straw"

    override val capacity: Int
        get() = 5

    override fun calculateArea(): Double = PI * radius * radius

    fun calculateCarpetLength(): Double = sqrt(2.0) * radius
}

class RoundTower(residents: Int, radius: Double, private val floors: Int) : RoundHut(residents, radius) {

    override val buildingMaterial: String
        get() = "Stone"

    override val capacity: Int
        get() = super.capacity * floors

    override fun calculateArea(): Double = super.calculateArea() * floors
}

fun main() {

    val cabin1 = SquareCabin(6, 5.0)
    val hunt1 = RoundHut(3, 3.0)
    val tower1 = RoundTower(14, 3.0, 3)

    with(cabin1) {
        println("\nSquare Cabin\n============")
        println("buildingMaterial: $buildingMaterial")
        println("capacity: $capacity")
        println("hasRoom? ${hasRoom()} \n")
        println("Area: ${"%.3f" printFormat calculateArea()}")
    }
    with(hunt1) {
        println("\nRound Hut\n============")
        println("buildingMaterial: $buildingMaterial")
        println("capacity: $capacity")
        println("hasRoom? ${hasRoom()} \n")
        println("Area: ${"%.3f" printFormat calculateArea()}")
    }
    with(tower1) {
        println("\nRound Tower\n============")
        println("buildingMaterial: $buildingMaterial")
        println("capacity: $capacity")
        println("hasRoom? ${hasRoom()} \n")
        println("Area: ${"%.3f" printFormat calculateArea()}")
    }
}

infix fun String.printFormat(double: Double): Double = "%.3f".format(double).toDouble()