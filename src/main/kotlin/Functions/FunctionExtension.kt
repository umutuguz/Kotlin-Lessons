package Functions

fun main() {

    /**
     *      Bu dunyayi cekilebilir seylerin basinda gelir Extension Functions
     *
     *      Uzerinde degisiklik yapamadigimiz (readOnly) classlara, ya da yapmak istemedigimiz classlara
     *      bu classlarin icerisinde yazmadan fonksiyon tanimlayabilmemizi saglar. Boylece o classa member function
     *      kazandirabilir. Bunu yaparaken unutmamamiz gereken; yazdiginiz extension function aslinda o classin
     *      gercek bir fonksiyonu olmayacaktir.
     *
     *      Sad but true. Extension functionlar kalbimize girecek. Bir classa ait olmalari gerekmez.
     *
     *      Reciever diye adlandirdigimiz bir classa ihtiyac duyarlar. Extension yazagimiz classi ifade eder Reciever tanimi.
     *
     *      Yapisal olarak;
     *
     *      fun String.extPrint(handsomeValue: HandsomeOne): Unit {
     *
     *      }
      */

    //
    37 log "4"
}

/**
 *      Number (reciever) classina extension olarak yazilmis log fonksiyonu. Ayni zamanda infix yapilmistir.
 *      this ifadesi, extension yapilan degeri verir. 3 log "4" yaparsaniz,
 *      asagidaki kod size emptyParam = "4", this = 3 olarak verilir.
 */

infix fun Number.log(emptyParam: String) {
    println(emptyParam + this)
}


/**
 *      Infix extension function expression formunda kullanilabilir.
 */

infix fun String.extPlus(otherString: String): Int = this.toInt() + otherString.toInt()



open class Shape {

    var intNumber = 0

    fun setNumber(intNumber: Int) {
        this.intNumber = intNumber
    }

    fun main() {
        intNumber.extToString()
        intNumber.log("")
    }

    /**
     *      Bir class icinde, farkli bir classa ait extension functiın yazilirsa, bu classin icinde ayni isimde normal
     *      bir fonksiyon olsa bile, etension functionun icerisinde, ayni isme sahip fonksiyon cagrilirsa, bu extension
     *      functiona isaret eder demektir. Classin ayni isimdeki member functioni extension function icerisinde cagirmak
     *      this@sinifismi.uyefonskiyon() seklinde cagirim yapilmalidir.
     */

    open fun Int.extToString() {
        println("")


        // Int.extToString() methodunu isaret eder.
        extToString()

        //Shape ait asagidaki member functionu isaret eder.
        this@Shape.extToString()

        println("This is print of the awesome class.")
    }

    fun extToString() {
        println("This is print of the keko class.")
    }
}