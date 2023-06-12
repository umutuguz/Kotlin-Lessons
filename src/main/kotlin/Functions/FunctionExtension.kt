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
     *
     *      Best practice main fonksiyonun hemen altina fonskiyonlar siralanmalidir. En üste yazilmaz.
      */
    // normal bir print etme islemi asagidaki gibidir.
    val pi: Double = 3 + 0.14
    println(pi)

    val schoolNumber: Int = 1341
    println(schoolNumber)

    val tcIdentityNumber: Long = 20260185176
    println(tcIdentityNumber)

    // extension functionlar ister direkt valuelar uzerinden cagrilabilir.
    (3+0.14).log("")
    37 log "4"
    tcIdentityNumber.log("")


    // normal fonskiyon ile kullanilan hali
    log2(schoolNumber)
    log2(pi)
    log2(tcIdentityNumber)


    // extension functionlar sari renkte gozukurler.
    val result = "4" extPlus "9"
    val result2 = "4".extPlus("9")

    /**
     *      Extension functionlar bir classin icerisidne yazildilarsa kullanim alani sadece o classin icerisi olur.
     *      Classin disinda, global cagrim yapilamaz.
     *      Int.extToString() methodu Shape classi icinde yazilmistir. Dolayisiyla shape classi disinda erisilemez.
     */
    //4.extToString()

    // Yine de extension methodu veren asagidaki main gibi bir method ile erisilebilir.
    val shape = Shape()
    shape.setNumber(45)
    shape.main()
}

// normal bir fonksiyon ve top level bir functiondir.
fun log2(number: Number) {
    println(number)
}

/**
 *      Number (reciever) classina extension olarak yazilmis log fonksiyonu. Ayni zamanda infix yapilmistir.
 *      this ifadesi, extension yapilan degeri verir. 3 log "4" yaparsaniz,
 *      asagidaki kod size emptyParam = "4", this = 3 olarak verilir.
 *      Top level functiondir.
 */

infix fun Number.log(emptyParam: String) {
    println(emptyParam + this)
}


/**
 *      Infix extension function expression formunda kullanilabilir.
 *      Top level bi functiondir. Duz dosyada global bir konumda yazilmistir.
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

        // bu shape classinin methodunu isaret eder.
        this.extToString()
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

/**
 *      Bir classin, yazilmis extension fonksiyonunun aynisini (isim ayni, parametre sayisi ve typelari ayni, ayrica geri donus tipi de ayni olmali)
 *      kendi icinde barindiriyorsa, bu durumda yazilan fonksiyon gecersizdir. Sinifin member functioni cagrilir.
 */

fun Shape.setNumber(intNumber: Int) {   // Bu extension function gecersizdir. Hicbir yerde calismaz. Shape classi icindeki setNumber calisir.
    val result = intNumber * intNumber
    println(result)
}

/**
 *      Bir classa extension function yazilabildigi gibi extension property de yazilabilir.
 *      Bunun sebebi aslinda property'lerin get() ve set() methodlarindan olusmasindan dolayidir.
 *      Bu extension property'lerin icerisinde field tanimlanamaz.
 *      Dolayisiyla aslinda gercek anlamda bir degisken extension yapilamaz.
 *      Bu konu property vs field konusu ile beraber classlar islenirken detayli anlatilacaktir.
 */

var Shape.type
    get() = "Rectangle"
    set(value) {
        type = value
    }


/**
 *      Open (Extend edilebilir) bir classa, classin icinde bir open (override edilebilir) extension function
 *      yazilirsa bu classi miras (inherit) alan classlar, ilgili extension functionu override
 */

class Rectangle: Shape() {
    override fun Int.extToString() {
    }
}


/**
 *      NOTES:
 *      Nullable extension function da yazilabilir.
 *      Companion objectlere de extension yazilabilir. Siniflarda ornegini yapacagiz.
 */