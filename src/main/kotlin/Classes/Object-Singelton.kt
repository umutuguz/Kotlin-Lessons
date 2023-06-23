package Classes


/**
 *      Duz object kullanimi thread safe patterni degil basic olani verir.
 *      Thread safe icin kucuk bir kod eklenmesi gerekir. Compain objectlerde bunu gorucez.
 */
object ProfileKotlin {
    var nickName: String? = null
    var counter: Int = 0
}

fun main() {

    ProfileKotlin.nickName = "Slither"

    ProfileKotlin.counter++
    ProfileKotlin.counter++
    ProfileKotlin.counter++
    ProfileKotlin.counter++
    ProfileKotlin.counter++

    println(ProfileKotlin.counter)
}

/**
 *      Olllley be Kotlin beeee :)
 */