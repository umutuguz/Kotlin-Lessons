package Classes

/**
 *      Data class'lar en azindan mutlaka 1 parametre almak zorundadır. Parametreler mutlaka val ya da var
 *      ile tanimlanmak zorundadır. Val ve varin zorunlu olmasinin sebebi toSting gibi olan 5 fonksiyonda da
 *      o degerlere ulasilabilir olmasini saglamaktir.
 *      Open, abstract, sealed, inner class yapılamaz.
 *      Tüm data class'lari final oldugu icin final modifier'i redundant uyarisi verir.
 *
 *      equals, hashCode, toString, copy, component fonksiyonlari arka planda default olarak olusturulurlar.
 *
 *      Yukaridaki fonksiyonlardan biri override edilirse, oto generate edilen hali yazilmaz.
 *
 *      Yukaridaki fonksiyonlar sadece primary const. icerisindeki degiskenlerle calisir.
 *
 *      componentN fonksiyonlari sebebiyle destructturing declaration olarak data class 'lar set edilebiliyor.
 *
 *      toString gibi fonksiyonlarda primary const. degiskenleri kullanildigi icin val ya da var yazilmak zorunludur.
 *
 *      Pair, Triple ozellestirilmis generic data classlar mevcuttur.
 *
 *
 *      Tek bir dezavantaji vardir. Guvenlik sikinitisi olusabilir. toStringten oturu class icerisindeki
 *      verilere ulasilabilir. Cok nadir denk gelinecek bir olay. Kurtulmak icin toString anlamsiz bir
 *      seyle override edilir. Ya da onemli olan o veriyi constructor icerisine yazmayiz.
 */

data class News (
    val title: String = "Title",
    val description: String,
    val hasMediaContent: Boolean,
    val mediaList: List<Media>
) {
    val relatedNewsList: List<News> = arrayListOf()

    override fun toString(): String {
        return "return super.toString()"
    }

    fun log() {
        println("Title: $title, descirption: $description")
    }
}

class NewsData(
    val title: String = "Title",
    val description: String,
    val hasMediaContent: Boolean,
    val mediaList: List<Media>
) {
    val relatedNewsList: List<News> = arrayListOf()
    override fun toString(): String {
        return "News(title=" + this.title + ", description=" + this.description
    }

    fun copy(): NewsData {
        return NewsData(title, description, hasMediaContent, mediaList)
    }
}

class Media

fun main() {
    val newsOne = News(
        title = "A New Education Term Has Begun!",
        description = "Last week it began.",
        hasMediaContent = true,
        mediaList = arrayListOf()
    )

    val newsTwo = NewsData(
        title = "A New Education Term Has Begun!",
        description = "Last week it began.",
        hasMediaContent = true,
        mediaList = arrayListOf()
    )

    val (title, description, hasMediaContent, mediaList) = newsOne
    val (title3, description3) = newsOne
//    val (title2, description2, hasMediaContent2, mediaList2) = newsTwo
    /**
     *      Yukaridaki kullanim ile newsOne.title demeye gerek kalmadan componentN functionlari sayesinde
     *      newsOne.title = title olarak kullanimi saglar. title3 boylece kullanilabilir. Konseptin adi
     *      destructturing declarationdir .
     */

    newsOne.toString()
    newsOne.hashCode()
    val newsThree = newsOne.copy(description = "Different Description")
    newsOne.component1()

    newsOne.relatedNewsList
    newsOne.title

    newsTwo.toString()
    newsTwo.hashCode()
//    val newsFour = newsTwo.copy(description = "Cannot do that")
//    newsTwo.component1()

    newsTwo.relatedNewsList
    newsTwo.title

    println("Data Class toString: $newsOne")
    println("Class toString: $newsTwo") // newsData classinin icerisinde toString override etmeseydik anlamli bi string gormeyecektik.
}