package Functions


/**
 *      Bir fonksiyon herhangi bir sinifin icerisinde degil de bir dosyasinin icerisinde boslukta tanimlaniyorsa,
 *      top level function adini alir.
 *
 *      Bir fonksiyonun olusturulurken top level tanimlama yapilamiyor, sadece bir sinifa ait fonksiyonlar yazilabiliyorsa
 *      bunlara fonksiyon degil, method denir. Bir fonksiyona fonksiyon diyebilmemiz icin top level tanimlanabiliyor olmalidir.
 */


fun main() {

    calculateAtomPhysics()
}

/**
 *      Fonksiyon icerisinde fonksiyon tanimi kotlinde yapilabilir. Bu fonksiyonlara  Local Functions denir.
 *      Sebebi ise, yazdiginiz fonksiyonun herhangi bir baska fonksiyon ya da sinif icin degistirilmesini istemeyebilirsiniz.
 *      Reflection ile fonksiyonlariniz erisilirken gizli kalsin isteyebilirsiniz.
 *      Bu gibi durumlarda bu cok onemli fonksiyonunuzu baska bir fonksiyon icerisine yazabilirsiniz.
 */

fun calculateAtomPhysics() {

    val userName = "Codemy"
    println("Inıtialize Process...")

    fun getValuesFromUserAndPrint() {
        userName.length
        val numberOne = readln().toInt()
        val numberTwo = readln().toInt()
        val result = numberOne + numberTwo
        println("$result")
    }

    getValuesFromUserAndPrint()
    println("Process has been done.")
}

/**
 *      Bir class icerisindeki fonksiyonlara uye fonksiyonlar denir.
 */

class Car {
    fun setColor(colorCodeId: Int) {

    }
}

/**
 *      Bir fonksiyon Generic type aliyorsa, Generic Function olarak adlandirilir.
 */

fun <T> setColor(colorCodeId: T) {

}