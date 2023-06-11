package `Control Flow`

fun main() {

    var numberOne = 10
    val numberTwo = 5

    println("numberOne: $numberOne")
    println("numberOne: ${numberOne++}")
    println("numberOne: $numberOne")
    println("numberOne: ${++numberOne}")

    //println("${++numberTwo}") olmaz

    print("${numberOne + numberTwo}")
    print(" ")
    println(numberOne.plus(numberTwo))
    println(numberOne+numberTwo)

    /*
        +a  a.unaryPlus()
        -a a.unaryMinus()
        ++a a.inc()
        --a a.dec()
        !a  a.not()
     */
}
