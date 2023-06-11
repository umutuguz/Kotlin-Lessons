package `2 Basics`

fun main() {
    /*
        Sonlu sayılı liste oluşturmaya yarar.

        Kucukten buyuge liste olusturmak icin .. operatorunu ya da rangeTo() fonksiyonunu kullanilabilir.
     */

    val numbers = 1..100
    val number2 = 1.rangeTo(100)

    /*
        Charlardan da liste yapilabilir.
     */
    val chars = 'A'..'Z'

    /*
        Buyukten kucuge gitmek istersen downTo() fonksiyonu kullanılır.
     */
    val numbers3 = 100.downTo(1)

    /*
        until fonksiyonu kullanılarak da range olusturabilir.
     */
    val numbers4 = 10.until(100)

    /*
        step fonksiyonu ile liste olusturulurken belirli sayida atlama ile liste olusturulabilir.
     */

    val numbers5 = 1..100 step 3

    /*
        CharRange, IntRange gibi primitive typeler ile de tanim yapilabilir.
        Bu durumda first,last,step,count gibi bilgiler elde edilebilir.
     */

    val numbers6: IntProgression = 1..77 step 3
    numbers6.first
    numbers6.step

    /*
        reversed() fonksiyonu ile bir listenin tersi alinabilir. rangeTo ile olusturulan listenin downTo su elde edilmis olur.
     */

    when (10) {
        in numbers6 -> {
            println("10 sayisi numbers6 sayisinin elemanidir.")
        }

        !in numbers6 -> {
            println("10 sayisi numbers6 sayisinin elemani degildir.")
        }
    }

    val numberList = 10.until(100)

    println(numberList.count())
    println(numberList.average())
}