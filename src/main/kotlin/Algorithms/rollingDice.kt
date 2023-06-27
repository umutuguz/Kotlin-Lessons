package Algorithms

class Dice(private val sideNumber: Int) {
    fun roll(): Int = (1..sideNumber).random()
}
fun main() {
    val luckyNumber = 4
    println("Random number: ${Dice(6).roll()}")

    if (luckyNumber == Dice(6).roll()) {
        println("You won!")
    }else {
        println("You lost, try again!")
    }

    when (Dice(6).roll()) {
        luckyNumber -> println("You win!")
        1 -> println("You rolled a 1. Try again!")
        else -> print("")
    }
}