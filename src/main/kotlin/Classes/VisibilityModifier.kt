package Classes


/**
 *      Kotlinde bir degisken, fonksiyon ve class default olarak pıblic tipinde olusturulur.
 *
 *      Encapsulation:
 *      Bir classin degiskenlerini private olarak tutup bu degiskenlere eriselecek olan
 *      fonksiyonlari publicte tutmaya denir.
 *
 *      4 adet visibility modifier mevcuttur.
 *          private     Sadece class icinde ersim mevcuttur.
 *          public      Her yerde erisime acik yapar.
 *          internal    Ayni modul, class, child class da erisim saglanir.
 *          protected   Sadece class ve child classlarda erisime aciktir.
 *
 *      Not: protected top level tanimlamalarda kullanilamaz. Miras alinabilecek bir child classi olamayacagindan dolayi.
 */


//protected fun getCustomerName(): String {
//    return "Customer name"
//}

open class Foo() {

    private var shortLine = 0
    private var longLine = 0

    private val name = "Umut"
    public var surName = "Uguzlar"
    internal val age = 24
    protected  val email = "umutuguzlar7@gmail.com"

    fun printName() {
        println("Merhaba $name")
    }

    fun getName(): String {
        return name
    }

    fun calculateArea (shortLine: Int, longLine: Int): Int {
        this.shortLine = shortLine
        this.longLine = longLine
        return this.shortLine * this.longLine
    }

    private fun download(url: String) {

    }

    private fun startAds() {

    }

    fun downloadVideo(url: String) {
        startAds()
        download(url)
    }
}

fun main() {

    val foo = Foo()

    foo.surName = "Uguz"

    foo.calculateArea(3,4)

    foo.downloadVideo("youtube.com/videourl")
}