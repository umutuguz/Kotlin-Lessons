package Functions

fun main() {

    /**
     *      Daha okunakli kodlar yazmak icin kullanilir.
     *      . (nokta) kullanimi kaldirir.
     *      Bir fonksiyonu infix hale getirebilmek icin 5 sart vardir.
     *      1. infix keywordu ile baslar.
     *      2. fonksiyon bir uye fonksiyon olmalidir. (bir sinifa ait olmalidir)
     *      3. ya da bir extension fonksiyon olmalidir.
     *      4. sadece bir parametre almalidir. Bu parametre vararg olamaz.
     *      5. infix methodun parametresi default deger alamaz.
     *
     *      Yapisal olarak;
     *
     *       infix fun infixMethod(justOneParam : AwesomeParam) : Whatever {
     *
     *       }
     */

    val isStudent = false
    val isMale = true

    /**
     *      and, or, xor gibi onlarca infix method vardir.
     *      Not: Method demek class icerisindeki fonksiyondur.
     */

    if (!isStudent and isMale) {
        print("A student not a male.")
    }

}

class AwesomeClass {

    infix fun downloadImage(imageUrl: String) {

    }

    infix fun specialPlus(number: Int): Int {
        return 4
    }

    /**
     *      Bir sinif icindeyken this kullanimi size bulundugu sinifi isaret eder.
     *      Asagidaki kullanimda AwesomeClass().downloadImage(imageUrl) kullanimi olusur aslinda. (implicit)
     */

    fun logWhenImageDownloaded(imageUrl: String) {
        downloadImage(imageUrl)

        this downloadImage imageUrl
    }
}

/**
 *      Bir classin disindayken infix method cagirimi yapilirsa this kullanilamaz.
 */

fun logWhenImageDownloaded(imageUrl: String) {
    AwesomeClass() downloadImage imageUrl
    //this downloadImage imageUrl calismaz!
}