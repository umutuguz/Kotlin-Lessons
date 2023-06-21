package Classes


/**
 *      Abstractlar ile Interfacelerin Ortak Yonleri;
 *
 *      1. Ikisinin de icerisine eklenen bodysiz fonksiyonlar override eidlmesi zorunlu hale gelir.
 *
 *      2. Egerki override etme zorunlulugunu kaldirmak istersek abstractlar da open veya normal val tanimlayarak
 *      interfacelerde ise bir fonksiyonun bodysi varsa veya bir property'nin get fonksiyonu varsa override
 *      edilme zorunlulugu kalkar.
 *
 *      3. Abstract bir class baska bir abstract classi miras aliyorsa ya da interface baska bir interface'i miras
 *      aliyorsa override etme zorunlulugu kalkar. Override etme opsiyonel olur.
 *
 *      4. Eger child bir abstract classta veya child bir interface'de override edilmis bir fonksiyon kullanilacagi
 *      classta override edilmesi yine opsiyonel olur.
 *
 *      5. Hem abstract classlar hem de interfaceler super olarak kullanilabilirler.
 *
 *
 *      Abstractlar ile Interfacelerin Farkli Yonleri;
 *
 *      1. Abstract classlarda state tutulabilir ama interfacelerde tutulamaz.
 *
 *      2. Abstract classlar tek bir class tarafindan miras alinabilirken birden cok interface
 *      implement olarak bir class tarafindan alinabilir.
 *
 *      3. Abstract classlar bir blueprint, sözlesme, sablon gorevi gorurken interfaceler ise yeni bir yetenek katmak
 *      olarak tanimlanabilir.
 *
 *      4. Interfacelerin bir de arayuz olma ozelligi vardir. Array<Unit> unit arayuzdur super<A>
 *
 */



/**
 *      Interface'lerin Abstract class'lardan en buyuk farki state tutamiyor oluslari. Yani bir degisken
 *      tanimladiktan sonra icerisinde deger tutamazlar.!!!
 *
 *      Interface icerisindeki intial degeri olmayan bir property (field) ya da body'si
 *      olmayan bir fonksiyon abstract olarak da tanimlanabilir.
 *
 *      Interfaceleri anlami geregi final yapamazsiniz. open yazilmasi da gereksizdir (redundant)
 *
 *
 *      Not: Bir yerden tetikleyim ve baska bir yerde calistiginin bilgisini aliyim denirse interface
 *           Ben bi classin icine yaziyim ve tum child classlarda zorunlu bi sekilde override edilsin diyosan abstract
 *           class icinde abstract function
 *           Eger ki yazdigin function kendi icerisinde abstract classsin bir degiskenini kullanacaksa ve heryerde de
 *           override edilsin istemiyosak open function kullanilir.
 *
 */

interface MyInterFace {
    val prop: Int  //abstract

    val propertyWithOmplementation: String
        get() = "Foo"
    // interfaceler icerisinde deger atamasi yapilamaz yani bunun setini yazamayiz.

//    val propertyWithOmplementation: String = "Random"
//        get() = "Foo"

//    abstract  val propertyWithImplementation: String
//        get() = "Foo"

//    abstract fun foo() {
//        print(prop)
//    }

    fun foo() {  // kullanilacagi yerde override edilme zorunlulugu yoktur.
        print(prop )
    }

    fun foo2()  // kullanilacagi yerde override edilme zorunlulugu vardir.

    // abstract olabilir ama mantiksizdir.
    abstract fun bar()
}

/**
 *      Interfacelere tanimlanan propertylerde (field) initial deger alma zorunlulugu yoktur.
 */

interface Named {
    val fullName: String?
}

interface Person: Named {
    val firstName: String
    val lastName: String

    override val fullName: String?
        get() = "$firstName $lastName"
}

interface A {
    fun foo() {
        print("A")
    }
    fun bar()
}

interface B {
    fun foo() {
        print("B")
    }

    fun bar() {
        print("Bar")
    }
}

/**
 *      Eger implement edilen interface, baska bir interface'i implement ediyorsa
 *      ve bu interface'in uyeleri child interface'de override edilmis ise,
 *      Child interface'i implement eden class'da, bu property'nin override edilme zorunlulugu kalkar.
 *
 *      Eger bir abstract class bir interfacei implement ediyorsa, o interfacesin override edilmesi zorunlu
 *      functionlari override etmeyebilir. Abstract classlar icin bu opsiyoneldir.
 */
//abstract class Employee : Person{
//
//}
class Employeee : Person {
    override val firstName: String
        get() = TODO("Not yet implemented")
    override val lastName: String
        get() = TODO("Not yet implemented")

    override val fullName: String? // zorunlu degildir yukaridaki interface icerisinde override edilmesinden dolayi
        get() = super.fullName

}

/**
 *      Bir class Abstract ise bir interface'i implement ettikten sonra bu interface'in fonksiyonlarini
 *      override etmek zorunda kalmiyor.
 *
 *          abstract class Employee : Person{
 *
 *      }
 *
 *      Bir interface icerisindeki fonksiyonlardan body'si olanlar override edilmek zorunda degildir.
 *      Body'si olmayan tum fonksiyonlar ise class'a implement edildiginde override edilmek zorunda.
 *
 *      Property'ler (field) de interfacelere tanimlanabilirler.
 *      Property'lerden de deger atamasi yapilmamis olanlar zorunlu olarak override edilirler, eger property
 *      get fonksiyonu ile bir statik deger geri donduruyorsa, override etme zorunlulugu kalkar.
 *
 *      Interface icerisine tanimli ve override edilme zorunlulugu olan property'ler (field) primary
 *      constructor icerisinde de overide edilebilirler.
 *
 *      Bodysi olan (override edilme zorunlulugu olmayan) bir interface fonksiyonu override edilirse,
 *      override edildigi terde bodysi icerisinden superi cagirilabilir. (cagirmak zorunda degilsiniz.)
 *
 *      Not: Bodysi olmayan bir fonksiyonu super ile cagiramazsin.
 */

class Child(override val prop: Int = 29) : MyInterFace {

    //override edilmesi zorunlu degildi
    override val propertyWithOmplementation: String
        get() = "Implemented Property"

    override fun bar() {
//        super.bar
    }

    // body'si oldugu icin overrride edilme zorunlulugu yok.
    override fun foo() {
        super.foo()
    }

    override fun foo2() {
        TODO("Not yet impelemented")
    }
}

class C : A {
    override fun bar() {
        print("Bar")
    }
}

/**
 *      Birden fazla interface bir class'a tanimlanabilir.
 *
 *      Birden fazla interface bir class'a tanimlanirken aralarina virgul koyulur.
 *
 *      : isaretinden sonra eklenen yapilarin hangilerinin class (inheritance)
 *      hangilerinin interface (implementation) oldugunu karistirmamak icin
 *      bu yapilarin sonuna bakmaniz lazim. Sonunda () parentezlerini goruyorsaniz : 'dan sonra
 *      gelen yapi class'tir (inheritance) miras alma islemi yapiliyordur. () yoksa interface'dir (implementation)
 *      islemi yapiliyordur.
 */

open class E() {

}

/**
 *      2 farkli interface'in ayni fonksiyonlari olmasi durumunda, bu fonksiyonlarin override edilmesi
 *      sirasinda ayni fonksiyonu 2 kere yazarak override edemeyiz.
 *
 *      Eger implement ettigimiz interface'lerin ayni isimde fonksiyonlari bulunuyorsa, tek bir fonksiyon
 *      override islemi yapilir. Bunun icerisinden hangisinin body'sine erismek istiyorsak
 *      o interface'in ismini <> isaretleri arasina yazmamiz gerekiyor.
 *
 *      Eger implement edilen 2 interface de ayni fonksiyonlar varsa bu durumda bodyleri olsa da override
 *      edilmesi zorunludur.
 */

class D : E(), A, B {
    override fun foo() {
        super<A>.foo()
        super<B>.foo()
    }

    override fun bar() {
//        super<A>.bar()    A interfaceinin bar functionunun body'si yok. Dolayisiyla super ile erisilemez.
        super<B>.bar()  // <B> arayuzunu yazmak zorunda kalmiyorsunuz. Buna reduntant uyarisi verilir.
        super.bar()
    }
}