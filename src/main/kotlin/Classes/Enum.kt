package Classes

/**
 *      Enumlar okudugun kodu daha rahat yorumlamani saglar.
 *      Enum sabitlerinin butun harfleri buyuk yazilir.
 *      Enum classlari isimlendirirken sonuna type yazilmalidir. Best practice
 *      Enum classlarda olusturulan tum sabitler ayrica birer classtir. Yani enum sabitleri class olarak tutulur.
 *      Statik olarak olusturulan classlarin nesnesini olusturmadan o classin degiskenine erisilebilir. Statik tanimi
 *      kotlinde yapilmaz. Enum classlar halihazirda static olarak tanimlidir kotlinde.
 *      Enumlarin nesnesinin olusturulamasinin sebebi enum classlarin primary constructorlarinin private olmasindandir.
 *
 */

/**
 *      Tip gunveligini (type-safety) saglar.
 *      Kullanim amaci ayni veri kumelerinin gruplanabilir olmasini saglar.
 *      Opsiyonlarin tamaminin neler oldugunu rahatca gorebilmemizi saglar.
 *
 *      abstract, open, inner, sealed olamazlar.
 *      yapisi geregi zaten final'dirlar. final keyword'u kullanmak redundant uyarisi verir.
 *
 *      Ozunde class olduklari icin, constructor kullanabilirler ve bu constructor  icersinde veri tutabilirler.
 *      Java karsiliginda bu enum sabitleri static final class 'lar seklinde tutulurlar.
 *      Bu sayede, kullanirken bu sabitlerin nesnesini olusturmak zorunda kalmayiz.
 *
 *      Enum class'larinin nesnesi olusturulamaz.
 *
 *      Her enum sabiti final name: String ve final ordinal: Int degiskenlere default olarak sahiptir.
 *      name ifadesi, enum'in kendisinin string halini verir.
 *      ordinal ifadesi, enum'daki sabitin index'ini verir ve 0'dan baslar.
 *      bu degiskenler final olduklari icin, enum sabitleri icerisinde override edilemezler.
 *
 *      enum class 'lar herhangi bir baska class'i miras alamazlar.
 *      enum class'lar herhangi bir interface'i implement edebilirler.
 *
 *      enum classlar abstract propertyler ya da abstract functionlar alabilirler.
 *      Bunlari aldiklarinda tum sabitler bu abstract yapilari override etmek zorundadir.
 *
 *      Bir open function da yazilabilir. Open olmasindan dolayi override etme zorunlulugu yoktur.
 *      Ancak open olarak belirtilen function'nun body'si olmak zorundadir.
 */

interface TeamsFunctionality {
    fun practice()
}


//      En basit hali ile enum class asagidaki gibidir.
enum class ColorType {
    RED, BLUE, GREEN
}


enum class TeamsType(val starCount: Int) {
    FB(3),
    GS(4),
    BJK(3),
    TS(2)
}
enum class Teams(val starCount: Int) : TeamsFunctionality {
    FENERBAHÇE(3) {
        override fun practice() {
            TODO("Not yet implemented")
        }
    },
    GALATASARAY(4) {
        override fun practice() {
            TODO("Not yet implemented")
        }
    },
    BEŞİKTAŞ(3) {
        override fun practice() {
            TODO("Not yet implemented")
        }
    },
    TRABZONSPOR(2) {
        override fun practice() {
            TODO("Not yet implemented")
        }
    }

//    ordinal ve name degiskenleri finaldir. override edilemez.
//    override val name: String
//        get() = TODO()
//    override val ordinal: Int
//    get() = TODO()
}

enum class DaysOfWeek(val dayNumber: Int) {
    MONDAY(1) {
        override fun toString(): String {
            return "Monday"
        }
    },
    TUESDAY(DaysOfWeek.TUESDAY.ordinal + 1) {  // Bu kullanim ile de 0 dan baslayan sekilde sirayi elde etmis oluruz. Donecegi deger 1'dir
        override fun toString(): String {
//            return "Tuesday"
            return DaysOfWeek.TUESDAY.name // Yukaridaki kullanimdansa daha akillica bir kullanim olacaktir.
        }
    },
    WEDNESDAY(3) {
        override fun toString(): String {
            return "Wednesday"
        }
    },
    THURSDAY(4) {
        override fun toString(): String {
            return "Thursday"
        }
    },
    FRIDAY(5) {
        override fun toString(): String {
            return "Friday"
        }
    },
    SATURDAY(6) {
        override fun toString(): String {
            return "Saturday"
        }
    },
    SUNDAY(7) {
        override fun toString(): String {
            return "Sunday"
        }
    }

}

enum class Sex {
    Male {
        override val typeCount: Int
            get() = TODO("Not yet implemented")

        override fun isOptional() {
            TODO()
        }

        override fun log() {
            super.log()
            println("MALE")
        }
    },
    Female {
        override val typeCount: Int
            get() = TODO()

        override fun isOptional() {
            TODO()
        }
    },
    Other {
        override val typeCount: Int
            get() = TODO()

        override fun isOptional() {
            TODO()
        }
    };

    abstract val typeCount: Int
    abstract fun isOptional()
    open fun log() {}
}

fun main() {
    val fb = "FENERBAHÇE"
    val gs = "GALATASARAY"
    val bjk = "BEŞİKTAŞ"
    val ts = "TRABZONSPOR"

    val pzt = "Pazartesi"
    val sal = "Salı"
    val car = "Çarşamba"
    val per = "Perşembe"
    val cum = "Cuma"
    val cmt = "Cumartesi"
    val paz = "Pazar"

    val male = "MALE"
    val female = "FEMALE"

    println("Enter the name of the big four team:")
    val team: String = readln()!!

    val starCount = when {
        team == fb -> {
            3
        }
        team == gs -> {
            4
        }
        team == bjk -> {
            3
        }
        team == ts -> {
            2
        }
        else -> {
            -1
        }
    }

    val starCount2 = when(team) {
//        Teams.FENERBAHÇE.name.uppercase() -> {
//              Teams.FENERBAHÇE.ordinal + 1
//        }

        Teams.FENERBAHÇE.toString() -> {
            Teams.FENERBAHÇE.starCount
        }
        Teams.GALATASARAY.toString() -> {
            Teams.GALATASARAY.starCount
        }
        Teams.BEŞİKTAŞ.toString() -> {
            Teams.BEŞİKTAŞ.starCount
        }
        Teams.TRABZONSPOR.toString() -> {
            Teams.TRABZONSPOR.starCount
        }
        else -> {
            -1
        }
    }




//  Teams Fenerbahcenin ust classi olmasindan dolayi bu fonksiyon hata vermemektedir. Tum enum sabitleri enum classi miras alir.
    val bestTeam = getBestTeam(Teams.FENERBAHÇE)
}

fun getBestTeam(team: Teams): Teams {
    return team
}