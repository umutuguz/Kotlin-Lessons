package Basics

fun main() {

    val numbers = listOf(1, 2, 3, 4, 5, 6)
    val colors = listOf("green", "orange", "blue")



    println("List: $numbers")
    println("Size: ${numbers.size}")


    // Liste elemanlarini erisim
    println("First element: ${numbers[0]}")
    println("Second element: ${numbers[1]}")
    println("Last index: ${numbers.size - 1}")
    println("Last element: ${numbers[numbers.size - 1]}")
    println("First: ${numbers.first()}")
    println("Last: ${numbers.last()}")

    // contains() true false dondurur
    println("Contains 4? ${numbers.contains(4)}")
    println("Contains 7? ${numbers.contains(7)}")

//    colors.add("black")
//    colors[0] = "yellow"

    // Tersten dizme ve alfabetik siralama
    println("${colors.reversed()}")
    println("${colors.sorted()}")

    /*************************************************************************************************/

    /**
     *      Değişken bir liste için val kullanabilirsiniz çünkü entrees değişkeni listeye bir
     *      başvuru içerir ve listenin içeriği değişse bile bu başvuru değişmez.
     *
     *      bos bir list olusturulacaksa tipi belirtilmelidir.
     */
    val entrees = mutableListOf<String>()
    val moreItems = listOf("ravioli", "lasagna", "fettuccine")

    println("Add noodles: ${entrees.add("noodles")}")
    println("Entrees: $entrees")

    println("Add spaghetti: ${entrees.add("spaghetti")}")
    println("Entrees: $entrees")

    println("Add list: ${entrees.addAll(moreItems)}")
    println("Entrees: $entrees")

    // Integer string list'ine eklenemez.
//    entrees.add(10)

    println("Remove spaghetti: ${entrees.remove("spaghetti")}")
    println("Entrees: $entrees")

    println("Remove item that doesn't exist: ${entrees.remove("rice")}")
    println("Entrees: $entrees")

    println("Remove first element: ${entrees.removeAt(0)}")
    println("Entrees: $entrees")

    entrees.clear()
    println("Entrees: $entrees")

    println("Empty? ${entrees.isEmpty()}")


}