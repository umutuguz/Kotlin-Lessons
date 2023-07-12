package Classes

data class User5(
    val name: String = "Umut", val surName: String = "UGUZLAR"
)

class CardDetailFragment {

    val userNonLazy: User5 = User5()
    var userNonLazy2: User5 = User5()


    val user: User5 by lazy(LazyThreadSafetyMode.PUBLICATION) {  // by lazy val ile kullanilir.
        println("User5 Init")
        User5()
    }

    lateinit var user2: User5  // lateinit var ile kullanilir.
    lateinit var userType: String

    fun printUserInfo() {

        val localVariable = "aslfhas"

        println("name: ${user.name}, surName: ${user.surName}")

        if (this::user2.isInitialized.not()) {
            user2 = User5()
        }

        println("\"name: ${user2.name}, surName: ${user2.surName}\"")
    }

    init {
        userType = "Premium"
    }

}

class BankAccount5(
    inline val balanceChanged: (Long) -> Unit
) {
    var balance: Long = 1_000_000
        set(value) {
            field = value

//            if (value <= 100) {
//                balanceChanged.onBalanceChanged(value)
//            }
            if (value <= 100) {
                balanceChanged.invoke(value)
            }
        }
}

fun main() {
    val cardDetailFragment = CardDetailFragment()
    cardDetailFragment.printUserInfo()
//    cardDetailFragment.printUserInfo()

//    val balanceChanged = object : BalanceChanged {
//        override fun onBalanceChanged(changedBalance: Long) {
//            sendPushNotification(changedBalance)
//        }
//    }
//
//    val bankAccount5 = BankAccount5(balanceChanged)
//
//    val bankAccount5 = BankAccount5 {
//        sendPushNotification(it)
//    }
}