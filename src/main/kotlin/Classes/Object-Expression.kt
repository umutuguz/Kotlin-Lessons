package Classes

import java.util.concurrent.CountDownLatch

interface Print2 {
    fun onPrint()
}

open class User(val age: Int) {
    open fun getUserFullName() {}
}

val fullName: User = object : Print2, User(24) {
    val firstName = "Umut"
    val surName = "UGUZLAR"

    override fun onPrint() {
        println("Full name:  $firstName $surName")
    }

    override fun getUserFullName() {
        super.getUserFullName()

    }

    override fun toString(): String {
        return "$firstName $surName"
    }
}

fun main() {

//    fullName.onPrint()
    fullName.getUserFullName()
    println("Full name: $fullName")

//    textView.addTextWatcher(object : TextWatcher(){
//        before
//        after
//        on7
//    })

//    object : CountDownTimer(10000, 1000) {
//        override fun onTick() {
//
//        }
//        override fun onFinish() {
//
//        }
//    }
    
}