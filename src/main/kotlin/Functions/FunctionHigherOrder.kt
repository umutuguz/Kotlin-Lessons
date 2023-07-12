package Functions

import java.util.Timer
import kotlin.concurrent.schedule


//fun main(args: Array<String>) {

//    printName("Umut")

//    printTotalName("${printName("Umut")}")
//    printTotalName("String")
//    printTotalName({
//        return "Ad: $name"
//  })
//}
//return "Ad: $name"
//
//
//fun printName(name: String): String{
//  return "Ad: $name"
//}
//
//fun printTotalName (totalName: String) {
//  println(totalName)
//}

fun main() {
    val name = "Umut"
    val surName = "UGUZLAR"
    val fullName = name + " " + surName

    // Iki adet normal fonksiyon ornegi

    fun deneme(fullName: String): String {
        return "Merhaba " + fullName
    }

    fun deneme2(fullName: String): String {
        return "Merhaba " + fullName
    }

    val welcomeMessage: String = deneme(fullName)

    deneme(deneme2(fullName))

    /**
     *      Fonksiyon'lar Kotlin'de "First Class Citizen "dır. Yani degiskenlere deger olarak atanabilir,
     *      baska parametre olarak verilebilir ya da bir fonksiyonunn geri donus degeri olabilir demektir.
     *
     *      Higher Order Function'lar daha da basitce fonksiyon body'sidir.
     *      Higher Order Function'lar basitce bir fonksiyona parametre olarak verilen fonksiyonlardır.
     *      Parametre verilmekten kasit, fonksiyonun cagriminin parametre kisminda yapilmasi degil, fonksiyonun govdesinin
     *      yani suslu parantezler arasinda kalan gorev alaninin baska bir fonksiyona parametre olarak verilmesidir.
     *
     *
     *      Not: -> işaretine lambda denir.
     *
     *      Yapisal olarak;
     *
     *      fun foo (higherOrderFunction: (message: String -> Unit)){
     *          higherOrderFunction("Codemy")
     *      }
     *
     *      fun boo (boo: String){
     *
     *      }
     *
     *      Cagrilirken;
     *
     *      fun main() {
     *
     *          boo("Merhaba")
     *
     *          foo({ message ->
     *              println("Message: $message")
     *          })
     *
     *      }

     */

    /**
     *      Higher Order Functionlari tanimlamanin 3 yolu vardir.
     */

    /*
            1. Bir degiskene atayarak Higher Order Function tanimlayabilinir.
            Bu durumda suslu parantezler yanina higher order functionin aldigi parametreler lambda okundan once aralık
            koyularak yazilir. Higher Order Function tek parametre aliyorsa, bu parametreleri yazmak zorunda degilsiniz.
            Bu durumda higher order function size "it" kelimesi ile higher order functionin parametresi tipinde bir
     */

    /*
            Not: Higher Order Functionin son satiri fonksiyonun geri donus tipinde olmalidir. Asagidaki ornekte stringtir.
     */
    val higherOrderFunction = { surName: String ->
        println("surName: $surName")
        "surName: $surName"
    }

    /*
            2. Ismi olmayan "anonymous function" tanimlamalari da Higher Order Function olarak, normal bir functiona parametre
            olarak verilebilir.
     */

    val anonymousFunction = fun(surName: String): String {
        return "surName: $surName"
    }

    // expression seklinde de higher order function tanimlanabilir.
    val anonymousFunction2 = fun(surName: String): String = "surName: $surName"

    /*
            3. Son yontem olarak normal bir function gibi tanimlanabilir. Tek bir sartı vardir. Parametre sayisi ve tipi
            tanimlanmis olan higher order function ile birebir ayni olmalidir.
     */

    fun logPrint(message: String): String {
        return "Log: $message"
    }

    fun foo(higherOrderFunction: (message: String) -> String) {
        higherOrderFunction("Codemy")
    }

    logPrint("All is well!")
    foo(::logPrint)     // Parametreler higher order function bodysinde verilir.

    /**
     *      Higher Order Function'la ayni parametre sayisina sahip ve bu parametrelerin hepsinin tipleri Higher Order Function parametre
     *      tipleri ile ayni ise, bu normal fonksiyon da Higher Order Function olarak normal bir fonksiyon olarak verilebilir.
     *      Bunu yapmak icin sadece basina :: isareti koymak yeterlidir.
     */

    val news = News()
    news.read(::println)

    news.read({ title ->  // Parantezleri kaldirabilirsin asagidaki gibi daha okunur durmasi adina
        print("Random")
    })

    news.read {
        print(it)
    }

    val titleFun = fun(title: String): Unit {
        print(title)
    }

    news.read(titleFun)

    printUserInfo(getName(), higherOrderFunction, getAge())
    printUserInfo(getName(), anonymousFunction, getAge())
    printUserInfo(getName(), fun(surName: String): String {
        return "surName: $surName"
    }, getAge())


    //      Suslu parantezler (body) direkt olarak higher order functionin parametre olarak beklendigi alana da yazilabilir.
    printUserInfo(getName(), {
        "surName: $it"
    }, getAge())

    getItemClickListener({buttonName ->
        println("$buttonName clicked..")
    })

    getItemClickListener {buttonName ->
        println("$buttonName clicked..")
    }


    /**
     *      Eger bir fonksiyon parametreleri icerisinde bir higher order function son parametre olarak tanimlanacaksa
     *      -isteniyorsa, bu higher order function, fonksiyon parametrelerinin disina yazilabilir. Daha temiz yapilmis olur.
     */

    val newsType = NewsType()
    news.getNewsFromServer("FoxTv", newsType, {
        println(this.toString())
    })  // Higher Order Function, fonksiyon parametrelerinin icerisinde tanimlanmistir.

    news.getNewsFromServer("FoxTv", newsType) {
        println(this.toString())
    }  // Higher Order Function fonksiyon parametrelerinin disinda tanimlanmistir.

    /**
     *      Higher Order Function birde fazla parametre iceriyorsa, aralarina virgul koyarak lambda isareti ile tanimlamak zorunlu.
     *      Tek parametreye sahipse bu durumda parametre ismi ve lambda isareti koyulmayabilir. Bu durumda ilgili parametre "it"
     *      kelimesi ile cagrilabilecektir.
     *      Eger bir fonksiyon, parametre olarak sadece Higher Order Function aliyorsa bu durumda fonksiyon parantezlerini hic yazmayabilirsin.
     */

    news.filterNews { filterType, getFilterName ->
        print("$filterType")
        getFilterName()
    }
}

fun getAge(): Int {
    return 24
}

//Normal Fonksiyon
fun getName(): String {
    return "Umut"
}


/**
 *       2. parametre Higher Order Fonksiyon olarak tanimlanmistir.
 *       Higher Order Fonksiyonlar default deger alabilirler. Bunun icin basitce suslu parantezler acmak yeterlidir
 *       Dikkat edilmesi gereken konu bu suslu parantezler icine, Higher Order Function parametre bekliyorsa, bunlar verilmelidir.
 */
 fun printUserInfo (name: String, getSurName: (surName: String) -> String = {surName -> ""}, age: Int): Unit {
     println("name: $name, age: $age")
     println(getSurName("Uguzlar"))
 }

/**
 *      Higher Order Function'a parametre tanimlarken sadece degisken tipini tanimlayarak da (degisken adi olmadan) kullanilabilir.
 */
fun getItemClickListener(onClick: (String) -> Unit) {

    println("Clicking process has been started.")

    Timer().schedule(3000) {
        /*
                Bir higher order function, parametre olarak yazildiktan sonra, bu parametrenin normal fonksiyon icerisinde
                 cagirilmasi gerekmektedir. Aksi halde bu higher order fonksiyonu tanimlamak mantiksiz olur.
                 Normal fonskiyonun  cagrildigi alandaki higher order function'in body kismi hicbir zaman cagrilmaz demek olur.

         */
        onClick("Login")

        println("Clicking process has been finished.")
    }
}

class News {
    fun getNewsType(newsType: NewsType): String {
        return when (newsType.toString()) {
            NewsType.breakingNews -> "Breaking"
            NewsType.urgent -> "Urgent"
            NewsType.local -> "Local"
            NewsType.global -> "Global"
            else -> "Normal"
        }
    }
}

class NewsType {
    companion object {
        val breakingNews = "BreakingNews"
        val urgent = "Urgent"
        val local = "Local"
        val global = "Global"
        val normal = "Normal"
    }
}

/**
 *      Bir higher order functionina parametre verirken class ismi.() seklinde  tanimlama yapilabilir.
 *      Bu sayede ilgili class da parametre parantezi icerisine yazilabilir.
 */

fun News.getNewsFromServer(channelType: String, newsType: NewsType, getNews: NewsType.(Int) -> Unit) {
    when(channelType) {
        "KanalD" -> {
            getNews(newsType, 1)
        }
        "ShowTv" -> {
            getNews(newsType, 2)
        }
        "FoxTv" -> {
            getNews(newsType, 3)
        }
        "Tv8" -> {
            getNews(newsType, 4)
        }
    }
}
/**
 *      Bir higher order functionin parametresi de yine higher order function olabilir.
 */

infix fun News.filterNews(getFilter: (filterType: String, getFilterName: () -> String) -> Unit) {

    val getFilterNameHO = {
        "string return label"
    }

    val getFilterNameHO2 = fun(): String {
        return "String return label"
    }

    val getFilterNameHO3 = fun(): String = "String return label"

    fun getFilterNameHO4(): String {
        return "string return label"
    }

    fun getFilterNameHO5(): String = "String return label"

    getFilter("filterName") {
        "String return label"
    }

    getFilter("filterName", getFilterNameHO)
    getFilter("filterName", getFilterNameHO2)
    getFilter("filterName", getFilterNameHO3)
    getFilter("filterName", ::getFilterNameHO4)
    getFilter("filterName", ::getFilterNameHO5)
}

infix fun News.read(readTitle: (title: String) -> Unit) {
    readTitle("Umut is awesome")
}