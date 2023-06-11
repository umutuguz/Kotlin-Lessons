package `2 Basics`

fun main() {
    val number: Int? = null
    val char: Char? = null

    val number3 = null //nothing


    /*
        nullable olan bir degisken ile islem yapmak istersek !! veya ? ile kullnaılmak zorundadir.
        !! kullanimi demek eger o degisken nullable olursa o noktada kodun patlamasını kabul etmektir.
        ? kullaniminda ise degisken bizim icin cok onemli degil ve o degisken null olursa kod patlamasin null bi deger varsa ? olan kismi yapmadan koda devam et anlamindadir.
     */
    var result: Int? = null

    //result!!.plus(129)    // uygulama patlar eger null ise
    result?.plus(129) // uygulama patlamaz

    println(result)


 }