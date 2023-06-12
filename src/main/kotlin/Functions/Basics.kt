package Functions

/**
 *          fun keywordu ile fonksiyonlar baslar.
 *          Fonksiyon ismi verilir.
 *          Parametre parantezleri acilir ve parantezler girilir.
 *          : operatoru ve geri donus degeri yazilir.
 *          fonksiyon bodysi acilir ve kapatilir.
 *          Geri  donus degeri verilmeyen fonksiyonlar Unit typeni geri dondurur.
 *          Unit c deki voide esittir.
 *          Ornek -> fun main(): Unit { ... }
 */

fun main() {


    /*
        Bir classin fonksiyonunu cagirirken ise nokta isaretili ile ilk once class sonra fonkisyon cagrilir.
        Ornek -> Math.pow()
     */


    /*
        Default degeri olan parametrelere sahip bir donskiyon cagrilirken, default degeri olan parametrelere deger atamak
        sart degildir. Default degeri olan bi parametrelere opsiyonel parametre denir.
        Default değeri olan parametrelere deger atamadan fonksiyon cagırlacaksa bu durumda parametre sirasi degisir.
        Ideye hangi parametreye deger atadiginizi soylemek icin Named Arguments'leri kullanmaniz gerekir.
     */
    reformatMessage("message", true, 5, "en")
    reformatMessage(message = "message", size = 5, lang = "en")
    reformatMessage("message", true, 5)

    // vararg kullanimina ornek. key = 3'den onceki butun parametreler vararg parametresine denk gelir.
    getUserInfo("Umut", "UGUZLAR", "Istanbul", "Turkiye", key = 3)

    /*
        vararg parametresi olarak ArrayOf kullanilmak istenirse * operatoru eklenmelidir. (spread operator)
        bu operator diger dillerdeki pointer kullanimi anlamina gelmez. Kotlinde pointerler yoktur.
     */
    getUserInfo(*arrayOf("Umut, UGUZLAR, Istanbul, Turkiye"), key = 4)

    getUserInfo2(3, "Umut", "UGUZLAR", "Istanbul", "Turkiye")


}

/**
 *      = ile fonksiyonlara default deger verilebilir. (Default Argument)
 *      Default deger atamasi yapmak function overload islemi yapmamizi saglar.
 *      Tekrar tekrar ayni fonskiyonu farkli varyasyonlarını yazmak durumunda kalmayiz.
 */
fun reformatMessage(message: String, isUpperCase: Boolean = false, size: Int, lang: String = "tr") {
    println("Message: " + message + "isUpperCase: " + isUpperCase + "Size: " + size + "lang: " + lang)
}

/**
 *      Cok uzun sayida parametreniz olacaksa "variable number of arguments" - vararg tanimlanabilir.
 *      Bu sayede fonksiyon tek bir parametre aliyor gibi gozukurken kendisine cok miktarda degisken atanabilir.
 *      Bu degiskenlere array'e erisir gibi erisebilirsiniz. [index] ya da .get(index) seklinde
 *
 *      vararg tek ya da son parametre olarak yazilirsa, Jvm'e hazirlanıriken, Javadaki "String..." gibi ayni kod derlenir.
 *      Ancak vararg param birden fazla tanimlanirken ortada ya da basta yer alirsa, Jvme hazirlanirken, Array'e donusturulur.
 *      Bu da performans farki olusturur. String... daha performansli calisir.
 */

fun getUserInfo(vararg userInfo: String, key: Int) {
    userInfo[3]
    userInfo.get(3)
}

fun getUserInfo2(key: Int, vararg userInfo: String) {

}

/**
 *      Ayni fonksiyon icerisinde birden fazla vararg tanimi yapilmasina izin veirlmez.
 */

/**
 *      Bir fonksiyona = koyularak da return edecegi deger yazilabilir. (Single-Expression kullanimi)
 */

val userList = arrayOfNulls<String>(5)

// Single Expression kullanimi
fun getListCount(): Int = userList.size

// Normal kullanim
fun getListCount2(): Int {
    return userList.size
}

/**
 *      Default degeri olan parametrelere sahip bir fonksiyon Java siniflarindan cagrilacaksa eger,
 *      bu fonksiyona @JvmOverLoads annotationi verilmelidir. Boylece yazilan kod Jvm'e hazir hale gelir.
 *      Ilgili fonksiyonun tum varyasyonlari yazilir. (overload edilir)
 */

@JvmOverloads
fun print(message: String = "Message") {
    println(message)
}
