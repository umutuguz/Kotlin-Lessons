package Classes

import java.lang.IllegalArgumentException
import kotlin.properties.Delegates

/**
 *      Bir degiskenin degeri set edilirken bir higher order veya bir interface yardimi ile
 *      bunu disari bildirme islemidir. Observablelarin kullanim mantigi budur. Observable pattern
 *
 *      vetoable ile observable arasindaki tek fark higher order fonkisyonunun return degeri observableda
 *      unit iken vetoable da booleandir.
 *
 *      Vetoable bir degiskene deger atamasi yapilacakken bir bussiness logic gommek istiyorsak kullanilir.
 *      lambda expression bussiness logic sonucu false deger donuyorsa yeni deger atamasi gerceklesmez.
 *      true donuyorsa yeni deger atamasi gerceklesir.
 *
 *      LiveData pbservalbe patterni ile calisir.
 *
 *      Not: inline ile higher order kullanimi yapmak interfaceli kullanimdan daha performanslidir.
 *      Arka planda functionin nesnesi olusmamis olur.
 *
 */

class User85 {
    var name: String by Delegates.observable("Initialized Value") { property, oldValue, newValue ->
        println("$oldValue -> $newValue")
    }
}

var max: Int by Delegates.vetoable(0) {property, oldValue, newValue ->

//    if (newValue > oldValue) true else throw IllegalArgumentException("New value must be larger than old value")
    newValue > oldValue
}

var max2: Int by Delegates.observable(0) { property, oldValue, newValue ->
    true
}

fun main() {
    val user = User85()
    user.name = "first"
    user.name = "second"

    println(max) // 0

    max = 10
    println(max)

    max = 5
    println(max)

//    val deneme = DenemeObversable(object: Notify {
//        override fun onNotify(oldValue: Int, newValue: Int) {
//            println("Old balance: $oldValue, New balance: $newValue")
//        }
//    })
    val deneme = DenemeObversable {oldValue, newValue -> Unit

        println("Old balance: $oldValue, New balance: $newValue")
    }


    deneme.balance = 7500
}


/**
        Observable calisma mantigi asagidaki gibidir.
 */
//interface Notify {
//    fun onNotify(oldValue: Int, newValue: Int)
//}
//
//class DenemeObversable(private val notify: Notify) {
//    var balance = 0
//        set(value) {
//            notify.onNotify(field, value)
//            field = value
//        }
//}
/**
 *      Higher order ile calisma mantigi
 */
class DenemeObversable(val notify: (Int, Int) -> Unit) {
    var balance = 0
        set(value) {
            notify(field, value)
            field = value
        }
}