package Loops

fun main() {

    for (counter: Int in 0..10) {
        print("$counter \t")
    }

    val countryCodeArray = arrayOf("tr","az","uk","fr")

    for (value in countryCodeArray) {
        print("$value")
    }

    for(index in countryCodeArray.indices) {    // indices bize IntRange bilgisi doner. 0..3
        print("\n$index: \t${countryCodeArray[index]}")
    }

    for ((index, value) in countryCodeArray.withIndex()) {
        print("\n$index: \t$value")
    }

    countryCodeArray.withIndex().forEach { iterable ->
        iterable.index
        iterable.value
    }

    /*
        repeat (size) seklinde herhangi bir listeye ihtiyac duymadan tekrarlayan isler yapabilirsiniz.
     */
    repeat(10) {
        print("\nIt will repeat itself 10 times. This is the $it time of the repetition.")
    }

    /*
        return kullanarak ilgili sartlar saglanirsa, donguden cikabilirsiniz.
        continue kullanarak ilgili sart saglanirsa, donguye o degeri atlayarak devam edebilirsiniz.
     */

    for (value in 0..50) {
          if (value % 2 == 0) {
              continue
          } else {
              println("$value is an odd number.")
          }
    }

    for (value in 0..50) {
        if (value % 31 == 0) {
            break
        } else {
            println("$value is a mythic number.")
        }
    }

    /*
        Ic ice for
     */

    // continue ile kullanilinca ic donguden cikip dis donguye gecilir.
    returnLabel@ for (value in 1..50) {
        for (value2 in 1..10) {
            if (value2 == 5) {
                continue@returnLabel
            } else {
                print("First for loop's value: $value and the second for loop's value: $value2")
            }
        }

        // break ile kullanildigi zaman 2 donguden de cikabilmis oluruz.
        returnLabel@ for (value in 1..50) {
            for (value2 in 1..10) {
                if (value2 == 5) {
                    break@returnLabel
                } else {
                    print("First for loop's value: $value and the second for loop's value: $value2")
                }
            }
        }
    }
}