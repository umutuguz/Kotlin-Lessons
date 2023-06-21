package Classes

interface McDonaldsService {
    fun motoCarrier()

//    fun sellCoffee(): McCoffee
}

/**
 *      Not: Abstract classlar sablon classlardir.
 *           Abstract classlar default olarak opendir.
 *           Base classlari open degil abstract olarak tanimla best practicedir.
 *           Open veya direkt degisken tanimlanmasi cok tercih edilmez. Olabildigince kullanmamaya calis. Private
 *           degiskenler kullanilabilir.
 *           Abstract class kullanilmasinin amaci bi sablon olusturmaktir. Yazilimciya child classta kullanmasi gereken
 *           zorunlu degisken ve fonksiyonlari gosterir, bu yüzden olabilidigince az open ve normal degisken ve fonksiyon
 *           tanimlama.
 */

/**
 *      Final ve open modifier'ları kullanmak anlamsiz ve yanlistir.
 *      Abstract olarak yazilmis class'a yeni eklenen tum abstract yapilar, tum child class'larda override edilmek
 *      zorundadir.
 *      Eger abstract class'iniza eklemek istediginiz opsiyonel yapilar varsa, bunlari child class'larin
 *      tamaminda override etmek zorunda olmayalim diye, open keywordu ile tanimlayabiliriz.
 *      Abstract bir class, abstract bir class'i miras alirsa, abstract yapilari override etmek zorunda degildir.
 *      Abstract funtionc bodysi olmaz. Propertylerin de default degeri olmaz.
 *
 *      Abstract classlar ayni zamanda instance'i olusturulmayan classlar. Bu sebeple singleton gibi patternler icin de
 *      kullanilabiliyorlar.
 */

abstract class MCDonalds {
    abstract val fridge: Fridge
    abstract val superVisor: SuperVisor
    abstract val employeeOne: Employee
    abstract val employeeTwo: Employee
    abstract val employeeThree: Employee
    abstract val menuList: List<McHamburger>

    val specialBranchName: String = "Taksim"

//    abstract fun clean(clock: Int)
    abstract infix fun clean(clock: Int)

    // opsiyonel
    open val policeOfficer: Police = TODO()

}

abstract class McDonaldsExpress : MCDonalds() {
    abstract fun sellCoffee(): McCoffee

    override fun clean(clock: Int) {
        println("Clean time: $clock")
    }

    fun main() {
        fridge
        superVisor
    }

    override val fridge: Fridge
        get() = TODO("Not yet implemented")
}

class McDonaldsMaltepe : MCDonalds(), McDonaldsService {
    override val fridge: Fridge
        get() = TODO("Not yet implemented")
    override val employeeOne: Employee
        get() = TODO("Not yet implemented")
    override val employeeTwo: Employee
        get() = TODO("Not yet implemented")
    override val employeeThree: Employee
        get() = TODO("Not yet implemented")
    override val menuList: List<McHamburger>
        get() = TODO("Not yet implemented")
    override val superVisor: SuperVisor
        get() = TODO("Not yet implemented")

    override fun clean(clock: Int) {
        TODO("Not yet implemented")
    }

    override fun motoCarrier() {
        TODO("Not yet implemented")
    }

    fun main() {
        fridge
        superVisor
    }
}

class McDonaldsMaltepeExpress : McDonaldsExpress() {
    override fun sellCoffee(): McCoffee {
        TODO("Not yet implemented")
    }

    override val superVisor: SuperVisor
        get() = TODO("Not yet implemented")
    override val employeeOne: Employee
        get() = TODO("Not yet implemented")
    override val employeeTwo: Employee
        get() = TODO("Not yet implemented")
    override val employeeThree: Employee
        get() = TODO("Not yet implemented")
    override val menuList: List<McHamburger>
        get() = TODO("Not yet implemented")

    /*
    Bu function child class olan McDonaldsExpress classta zaten override edilmistir.
    override fun clean(clock: Int) {
        super.clean(clock)
        println("Clean flor: 1")
    }
     */

}
fun main() {
//     abstract classlardan nesne olusturamazsin
//    val mcdonalds = MCDonalds()

}

class Fridge

class SuperVisor

class McHamburger

class Police

class McCoffee

class Employee