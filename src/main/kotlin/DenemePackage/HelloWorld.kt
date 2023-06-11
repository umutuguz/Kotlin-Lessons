package DenemePackage


fun main() {
    val name = "Umut"

    println(name)

    val numberName = name + (5 + 2)

    println(numberName)
    println("Son char ${numberName[numberName.indices.last]}")
// trimIndent ile tüm satırlardaki ilk karakterden önceki tüm boşluklar silinir.

    print("""
                    *
                   ***
                  *****
    $
    """.trimIndent())

/*
    trimMargin ile prefix belirlenen karakterden önceki boşluklar traşlanır
 */
    println("""
    /                *
           /        ***   
    /              *****    
    """.trimMargin(marginPrefix = "/"))
}