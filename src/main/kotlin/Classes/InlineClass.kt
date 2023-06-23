package Classes


/**
 *      Inline (value) classlar.
 *      Constructorinda sadece 1 parametre olmalidir.
 *      Class icerisinde 1 den cok backing fieldli degisken tanimlanamaz. 1 backing fieldli degisken de zaten
 *      constructordaki parametredir. Bu yuzden degisken tanimlamak istediginde property seklinde bir tanim
 *      yapilmak zorundadir. Setlenme islemi value classlarda gerceklesemez yukaridaki sebepten dolayi.
 *      Su anlik value class kullanmak icin uzerine @JvmInline anotationi kullanmak gerekmektedir.
 */


//val balance: Int = 25000

open class BankAccount2(val balance: Int) {
    val branchCode: Long = 3245
}

interface Print {
    fun printBalance()
}

@JvmInline
value class BankAccount3(val balance: Int): Print {
    init {
        print("Balance: $balance")
    }

//    val accountNumber: Long = 12314121252
    val accountNumber: Long
    get() {
        return 12342345
    }

    fun getAccountNumber2(): Long {
        return 12342345
    }

    override fun printBalance() {
        print("Interface print - balance: $balance")
    }
}

/**
 *      value class'lar @JvmInline annotation olmadan henuz kullanilamiyorlar.
 *
 *      value class'lar suan icin sadece tek bir degisken kabul etmektedir. Birden fazla degisken kabul edilmemektedir.
 *      Ancak value class'larin dokumantasyonunda inline class'larin ileride birden fazla degisken alabilmesine
 *      izin verilecegi yaziyor.
 *
 *      inline class'lar ile init block'u kullanılabilir.
 *
 *      inline class'larin belirtilen constructor'lari java kodunda private olarak bulunurlar. Bundan dolayi zaten
 *      istesek de bu constrcutor'larla nesne olusturamayiz. Ama bunu yapabili gorunmemizin sebebi, gerçekte
 *      o nesnenin hic yaratilmiyor olusu sebebiyle.
 *      Bizim nesne olustururken gordugumuz sey aslinda const. icindeki degiskenin kendisi.
 *
 *      Inline class'lar icinde property tanimlanmasina izin verilir. Ancak bu property'nin backing field'i olamaz.
 *
 *      Inline class 'lar herhangi bir interface'i implement edebilirler, bir baska class'i miras alamazlar.
 *
 *      Inline class'lar miras alinamaz. Cunku default olarak final'lardir ve degistirilemezler.
 *      Open keyword'uyle beraber kullanilamaz. final keyword'u vermek de redundant uyarisi verir.
 *      abstract keyword'u ile de kullanılamaz.
 */

interface I

@JvmInline
value class Foo2(val i: Int) : I

fun asInline(f: Foo2) {}
fun <T> asGeneric(x: T) {}
fun asInterface(i: I) {}
fun asNullable(i: Foo2?) {}

fun <T> id(x: T): T = x

fun main() {
    val balance2: BankAccount2 = BankAccount2(25000)
    val balance3: BankAccount3 = BankAccount3(25000) // nesne gibi gozukse de aslinda sadece balance3 = 25000

    /*  Reference (class nesnesi)
        _________________________________
        |                               |
        |  bankAccount2                 |32kb
        |_______________________________|

        Primitive
        _________________________________
        |                               |
        |  25000                        |4kb
        |_______________________________|

        Erisimde cok daha performansli daha hizli bir sonuc elde etmis oluruz.

     */

    val f = Foo2(42) // f'in tipi int -> primitive -> unboxed
//    val f2: Int = 42

    asInline(f)     // unboxed: used as Foo2 itself (Primitive)
    asGeneric(f)    // boxed: used as generic type T (Reference)
    asInterface(f)  // boxed: used as type I (Reference)
    asNullable(f)   // boxed: used as Foo2?, which is different from Foo2 (Reference)
    // sadece duz bir funtion da kullanilirsa primitive ozelligini kullanabiliriz. Diger durumlarda mantikli degil. Kullanmanin bir esprisi kalmaz.

    // below, 'f' first is boxed (while being passed to 'id') and then unboxed (when returned)
    // In the end, 'c' contains unboxed representation (just '42'), as 'f'
    val c = id(f)
}