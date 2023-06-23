package Classes

import Functions.getAge

/**
 *      Nested classlarda outer classin degisken ve funcitonlarina erisim saglanamaz. Bu kisit memory leak problemi
 *      yasanmamasi icin vardir. Eger static olan nested class tum life cycle boyunca hayatta kalirken
 *      outer classta nested class sebebiyle static olsaydi memory leak problemiyle karsilasabilirdik.
 *
 *      Not: Nested class kullanma
 */


/**
 *      Nested class'lar outer class'in uye property'lerine ya da fonksiyonlarina erisemezler.
 *      Nested class'lar static olarak saklanirlar. Bundan dolayi da outer class uzerinden
 *      nested class'a erismek istemeniz durumunda Outer.NestedClass() seklinde erisebilirsiniz.
 *
 *      Inner class'lar static olarak tutulmazlar. Bundan dolayi erisim yapmak istedigimizde
 *      Outer().InnerClass() seklinde outer class'in da instance'ini olusturmaniz gerekmektedir. Bundan dolayi
 *      inner class outer class'in tum elemanlarina erisebilir. private olsa dahi.
 *
 *      Inner class'in icerisine yeni bir nested class eklenememektedir. Ancak yine inner class ekleyebilirsiniz.
 *
 *      Nested class'in icerisine ise bir nested ta da inner fark etmeksizin class ekleyebilirsiniz.
 */

class Outer {
    private val name = "Umut"
    val surName = "Uguzlar"
    fun getAge(): Int = 24

    class NestedClass {
        fun printName() {
//            name
//            surName
//            getAge()
        }
    }
}

interface OuterInterface {
    class DenemeA
    interface NestedInterface
}

class Outer2 {
    private val name = "Umut"
    val surName = "UGUZLAR"

    fun getAge(): Int = 24
    inner class InnerClass {
        fun printName() {
            name
            surName
            getAge()
        }
    }
}

fun main() {

    val outer = Outer()
    outer.getAge()
    outer.surName
//    outer.name

    Outer.NestedClass().printName()
//    Outer().NestedClass().printName()

    val outer2 = Outer2()
    outer2.getAge()
    outer2.surName
//    outer2.name
    Outer2().InnerClass().printName()
    outer2.InnerClass().printName()
}