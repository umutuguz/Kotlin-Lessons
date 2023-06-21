package Classes


/**
 *      Open bir function varken classin final olmasi sacma bir kullanim olacaktir. Open functionin bir espirisi kalmaz.
 *
 *      Not: Miras alinacak classin open keywordu ile baslamasi gerekir. Kotlinde tum classlar default olarak
 *      final yani miras alinamaz durumdadir.
 *
 *      Child class olustururken en azindan bir constructorin degerlerini almasi gerekir. Primary constructor olmak
 *      zorunda degildir.
 *
 *      Bir degisken veya functioni open yapmak child classlarin icerisinde bu degisken veya functioni override yani
 *      baska bir deger atamak veya functionin bussiness logicini degistirme islemi yapilabilir. override keywordu ile
 *      degisken ve functionlara bu islem uygulanabilir.
 *
 *      Polymorphism:
 *      Ust class yazilan bir functionin veya degiskenin override ederek anlamini veya isini degistirmek demektir.
 *
 *      super keywordu ile ust classtaki functionin da override edilen functionin da isini yapmasini saglar. Boyle bir ihityac yoksa
 *      kullanilmasina gerek yoktur.
 *
 *      Child classin child classsinda bir functiona ulasilinmamasi istenirse final keywordu ile bu durum engellenir.
 */
open class Shape(val name: String) {
    var mColor: String = " "
    var mEdgeCount: Int = 0

    constructor(name: String, color: String) : this(name) {
        mColor = color
    }

    constructor(name: String, color: String, edgeCount: Int) : this(name) {
        mColor = color
        mEdgeCount = edgeCount
    }

    open fun drawShape() {
        println("Name: $name")
        println("Color: $mColor")
        println("EdgeCount: $mEdgeCount")
    }

    fun calculateArea(): Int = if (mEdgeCount != 0) {
        mEdgeCount * mEdgeCount
    }else {
        0
    }
}


/**
 *      Child class olustururken en azindan bir constructorin degerlerini almasi gerekir. Primary constructor olmak
 *      zorunda degildir.
 */
class Rectangle(name: String) : Shape(name) {

    fun changeColor() {

    }

    override fun drawShape() {
//        drawShape()
//        this.drawShape()
        super.drawShape()

        calculateArea()

        val rectangle = """
            *************
            *           *
            *           *
            *************
        """.trimIndent()

        println(rectangle)
    }
}

class Circle(name: String, color: String) : Shape(name, color) {
    override fun drawShape() {
        super.drawShape()

        val circle = """
                *
              *   *
            *       *
            *       *
              *   *
                *
        """.trimIndent()

        println(circle)
    }
}

open class Square(name: String, color: String, edgeCount: Int) : Shape(name, color, edgeCount) {

    final override fun drawShape() {
        super.drawShape()

        val square = """
            *************
            *           *
            *           *
            *           *
            ************* 
        """.trimIndent()
    }
}

class OneMeterSquare: Square("OneMeterSquare", "Blue", 4) {

//    override fun drawShape() {
//        super.drawShape()
//        super.super.drawShape()
//    }
    //      ust classdaki drawShape final olursa, alt classda bu function override edilemez. 0dan yazilmasi gerekir.
}


fun main() {
    val shape = Shape("Shape")
    val rectangle = Rectangle("Rectangle")
    val circle = Circle("Circle", "Blue")
    val square = Square("Square", "Black", 4)

    shape.drawShape()

    shape.drawShape()
    circle.drawShape()
    square.drawShape()
}