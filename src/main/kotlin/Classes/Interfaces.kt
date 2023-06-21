package Classes

/**
 *      Interface'lerin Abstract class'lardan en buyuk farki state tutamiyor oluslari. Yani bir degisken
 *      tanimladiktan sonra icerisinde deger tutamazlar.
 *
 *      Interface icerisindeki intial degeri olmayan bir property (field) ya da body'si
 *      olmayan bir fonksiyon abstract olarak da tanimlanabilir.
 *
 *      Interfaceleri anlami geregi final yapamazsiniz. open yazilmasi da gereksizdir (redundant)
 *
 *
 *      Not:
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

    fun foo() {
        print(prop )
    }

    // abstract olabilir.
    abstract fun bar()
}