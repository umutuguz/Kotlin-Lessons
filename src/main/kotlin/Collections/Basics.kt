package Collections

fun main() {

    val numbers = listOf(0, 3, 8, 4, 0, 5, 5, 8, 9, 2)
    println("list: $numbers")
    println("list: ${numbers.sorted()}")

    val setOfNumbers = numbers.toSet()

    println("set:    ${setOfNumbers}")

    val set1 = setOf(1, 2, 3)
    val set2 = mutableSetOf(3, 2, 1)

    println("$set1 == $set2: ${set1 == set2}")
    println("contains 7: ${setOfNumbers.contains(7)}")

    set1.intersect(set2)
    set1.union(set2)

    val peopleAges = mutableMapOf<String, Int>(
        "Fred" to 30, "Ann" to 23
    )
    println(peopleAges)
    peopleAges.put("Barbara", 42)

    peopleAges.forEach { print("${it.key} is ${it.value}, ") }

    println(peopleAges.map { "${it.key} is ${it.value}" }.joinToString(", "))

//    val deneme2: (MutableMap<String, Int>) -> Boolean = { it.key.lenght < 4}

//    val filteredNames = peopleAges.filter { deneme2((peopleAges)) }
    val filteredNames = peopleAges.filter { it -> it.key.length < 4 }
    println("\n" + filteredNames)
    println("${"umut".length}")
//    val deneme: (Int) -> Int = { it * 3 }
//
//    println("${deneme(4)}")

    val peopleNames = listOf("Fred", "Ann", "Barbara", "Joe")

    println(peopleNames.sortedWith { str1: String, str2: String -> str1.length - str2.length })

}