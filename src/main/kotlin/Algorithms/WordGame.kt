package Algorithms

fun main() {

    fun wordPicker(word: String, compare: Char): Boolean = (word[0] == compare)

    val words = listOf("about", "acute", "awesome", "balloon", "best", "brief", "class", "coffee", "creative")

    val bWords = words.filter { wordPicker(it, 'b') || wordPicker(it, 'B') }
//    val bWords = words.filter { it[0] == 'b' }
    println(bWords)


    val filteredWords = words.filter { it.startsWith("b", ignoreCase = true) }.shuffled().take(2).sorted()
    println(filteredWords)


}