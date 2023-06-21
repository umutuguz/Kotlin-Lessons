package Classes


/**
 *      Not: Constructor icinde default deger kullanmaktansa secondary constructorlari kullan.
 *      Best practice, daha okunaklidir. Bazi senaryolarda default deger atamasi da yapmak mantiklidir.
 *
 *      Not: Classlar her zaman buyuk harfle baslamalı fonksiyonlar ise kucuk harf ile.
 *      Best practice!
 *
 *      Not: Tum secondary constructorlar primary constructora baglidir ve bir secondary constructor
 *      olusturulurken primary constructorin zorunlu degiskenlerine deger verilmek zorunludur.
 *      constructor(wheelCount: Int,color: String,name: String, madeOf: String) : this(4)
 *      : this(4) bunu gostermektedir. veya,
 *      : this(wheelCount) da verilebilir.
 *
 *      Her bir secondary constructor cagrilirken once primary de cagrilir.
 *
 *      Not: Best practice her zaman primary constructor yaz.
 *
 *      Not: Hicbir constructor blogu yazilmasa bile init calisacaktir.
 *      Default olarak bos bir constructor olusturulur eger biz olusturmadiysak.
 */
class Car(wheelCount: Int, color: String = "Red") {

    private val mWheelCount: Int
    private val mColor = color


    // init blogu primary constructorin bodysidir.
    init {
        mWheelCount = wheelCount
        "primary const. created".printLog()
        "WheelCount: $mWheelCount, Color: $mColor".printLog()
    }

    constructor(wheelCount: Int, color: String = "Red", name: String) : this(4) {  // this primary constructoru temsil eder.
        "1. secondary const. created".printLog()
    }
    constructor(wheelCount: Int,color: String,name: String, madeOf: String) : this(wheelCount) {
        "2. secondary const. created".printLog()
    }
}

fun main() {

    val car0 = Car(4)
    val car1 = Car(4, "Blue")
    val car2 = Car(4, "Blue", "Ford", "Metal")
    val car3 = Car(4, "Green", "BMW", "Plastic")
    val car4 = car(4, "Green", "BMW", "Plastic", "2023") // Ayni sekilde fonksiyon da tanimlanabilir, dikkat et.

}

fun car(i: Int, s1: String, s2: String, s3: String, s4: String){

}
fun String.printLog() {
    println(this)
    println("------------------------")
}