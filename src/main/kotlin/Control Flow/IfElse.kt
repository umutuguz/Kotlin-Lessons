package `Control Flow`

fun main() {

    print("Are you a student?")

    val answer = readln()

    // state kullanimi  -> Not: ignoreCase inputtaki kucuk buyuk harf ayrimi yapilip yapilmayacagini belirler
    if (answer.contains("Evet", ignoreCase = true)) {
        println("Yes, you are a student.")
    } else {
        println("No, you are not a student.")
    }

    // expression kullanimi -> Not: {} icerisindeki son satir deger olarak degiskene esit olacaktir

    val result: String = if (answer == "Evet") {
        "Yes, you are a student."
    } else {
        "No, you are not a student."
    }

    println(result)

     val grade = readln().toDouble()

    if (grade in 85.0..100.0) {
        println("Your grade is AA")
    } else if (grade in 70.0..84.0) {
        println("Your grade is BB")
    } else {
        println("Your grade is bad bro.")
    }

    /*
        2 farkli tipteki number degiskenler karsilastirirken equals fonksiyonu once tiplerini karsilastırır.
     */

    if (10 == 10L.toInt()){
        print("It is true.")
    }



}