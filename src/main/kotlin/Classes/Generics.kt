package Classes


/**
 *      in kendisi ve ust classlarini kabul etmek icin, out ise kendisi ve alt classlari icin kullanilan keywordtur.
 *
 *      inline functionlar function bodysinin cagrildigi yere yapistirilmasini saglar.
 *      Jvm yapisinda gercek anlamda bir functionumuzun olmamasini saglar.
 *      Ayni zamanda higher order functionlar ile kullanildiginda interfacelere gore bir performans katkisi sunar.
 */
interface TransportationFunctions {
    fun run()
}

open class Auto : TransportationFunctions {
    open val name: String = ""
    open val color: String = ""

    override fun run() {
        println("Run Forest run!")
    }
}

open class Bicycle {
    open val name: String = ""
    open val color: String = ""
}

//= == == == == == == == == == == == == == == == == == == == == == == == == == == == == == ==

open class MiniCooper(
    override val name: String = "MiniCooper", override val color: String = "Red"
) : Auto() {
    override fun toString(): String {
        return "Name: $name, Color: $color"
    }

    init {
        super.run()
    }
}

open class John : MiniCooper() {
    init {
        super.run()
    }
}

class JohnCabriolet: John() {
    init {
        super.run()
    }
}

class Beetle(
    override val name: String = "Beetle",
    override val color: String = "Yellow"
) : Auto() {
    override fun toString(): String {
        return "Name: $name, Color: $color"
    }
}

open class Bisan(
    override val name: String = "Bisan",
    override val color: String = "Red"


) : Bicycle(), TransportationFunctions {


    override fun toString(): String {
        return "Name: $name, Color: $color"
    }

    override fun run() {
        println("Run Forest run!")
    }
}

class BlackBisan() : Bisan()

class Corelli(
    override val name: String = "Corelli",
    override val color: String = "Orange"
) : Bicycle() {
    override fun toString(): String {
        return "Name: $name, Color: $color"
    }
}

class TransportFactory<in T: Auto>(transportationVehicle: T) {
    init {
        println(transportationVehicle.toString())
    }
}

fun main() {
    val miniCooper: MiniCooper = MiniCooper()
    val john: John = John()
    val johnCabriolet: JohnCabriolet = JohnCabriolet()
    val beetle: Beetle = Beetle()

    val bicycle: Bicycle = Bicycle()
    val bisan: Bisan = Bisan()
    val blackBisan: BlackBisan = BlackBisan()
    val corelli: Corelli = Corelli()

    val miniCooperFactory: TransportFactory<MiniCooper> = TransportFactory<MiniCooper>(miniCooper)
    val johnFactory: TransportFactory<John> = TransportFactory<John>(john)
    val johnCabrioletFactory: TransportFactory<JohnCabriolet> = TransportFactory<JohnCabriolet>(johnCabriolet)
    val beetleFactory: TransportFactory<Beetle> = TransportFactory<Beetle>(beetle)

    val johnFactory2: TransportFactory<John> = TransportFactory<MiniCooper>(miniCooper)
//    val johnFactory3: TransportFactory<John> = TransportFactory<JohnCabriolet>(johnCabriolet)
    val johnFactory4: TransportFactory<John> = TransportFactory<John>(john)
//
//    val bisanFactory2: TransportFactory<Bisan> = TransportFactory<Bicycle>(bicycle)
//    val bisanFactory3: TransportFactory<Bisan> = TransportFactory<BlackBisan>(blackBisan)
//    val bisanFactory4: TransportFactory<Bisan> = TransportFactory<Bisan>(bisan)
//
//    val bisanFactory: TransportFactory<Bisan> = TransportFactory<Bisan>(Bisan)
//    val corelliFactory: TransportFactory<Corelli> = TransportFactory<Corelli>(Corelli)
//
//    val something: Car = Car(2,"Red")
//    val somethingFactory: TransportFactory<Car> = TransportFactory<Car>(something)
//
//    println(miniCooper.toString())
//    println(johnCabriolet.toString())
//    println(beetle.toString())
//
//    val miniCooperFactory: AutoFactory<Minicooper> = AutoFactory<MiniCooper>(miniCooper)
//    val johnCabrioletFactory: AutoFactory<JohnCabriolet> = AutoFactory<JohnCabriolet>(johnCabriolet)
//    val beetleFactory: AutoFactory<Beetle> = AutoFactory<Beetle>(beetle)

    calculate<Int>(2,5)
    calculate<String>(2,5)

}

//fun <T: Number> calculate(numberOne: T, numberTwo: T): Unit {
//    println("Sum calculation: ${numberOne.sum(numberTwo)}")
//}

inline fun <reified T> calculate(numberOne: Int, numberTwo: Int): T {
    return when(T::class.java) {
        String::class.java -> {
            (numberOne + numberTwo) as T
        }
        else -> {
            (numberOne + numberTwo) as T
        }
    }
}