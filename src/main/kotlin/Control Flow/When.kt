package `Control Flow`

import java.util.*

fun main() {

    println("What is your country's code? ")
    val countryCode = readln()


    when (countryCode.lowercase()) {
        "tr" , "az" -> println("Turkiye citizen")
        "uk" -> println("United Kingdom citizen")
    }

//    when (countryCode.toInt()) {
//        3 and 5 -> println("Odd number")
//        2 or 4 -> println("Even number")
//    }

     // Expression kullanimi whende de mevcuttur.

    val countryResult = when (countryCode.lowercase(Locale.ENGLISH)) {
        "tr" , "az" -> {
            print("Turkiye Citizen")
            "90"
        }
        "uk" -> {
            print("United Kingdom Citizen")
            "20"
        }
        else -> {
            "Person does not have a country."
        }
    }

    println(countryResult)

    // is ile !is bir classin referansi olunup olunmadügünü kontrol eder.

    val phoneNumber = 5375177057L

    when(phoneNumber) {
        is Long -> {
            print("It is a long number.")
        }
        !is Long -> {
            print("It is not a long number.")
        }
    }

    // rangeleri in !in seklinde kontrolu yapilabilir.
    val number = 3
    when (number) {
        in 0..10 -> {
            print("LAlala")
        }
        in 11..20 -> {
            print("LElele")
        }
        !in 0..11 -> {
            print("LOlolo")
        }
    }
}