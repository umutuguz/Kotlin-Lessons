package Classes

/**
 *      Hazirda olan bir classin tamamini static yapmak istenmediginde, belli basli class kisimlarinin
 *      static olmasi istendiginde companion objectler kullanilmaktadir.
 *
 *      Companion objectin interface icerisindeki kullanimi OOB kurallarina aykiridir.
 *      Hicbir zaman kullanilmayacaktir.
 *
 *      Compaion objectin instance'i class icerisinde halihazirda olusuturulmustur. Bu yuzden companion objectin
 *      adini vermeye gerek kalmadan o companion objectin degisken ve fonksiyonlarina ulasilabilir.
 *      Fakat object yani singelton kullanimda class icerisine instance olusturulmaz. Bundan dolayi class sonrasinda
 *      direkt ulasim yoktur. objectin adinin da yazilmasi gerekmektedir. 83 satir ornegidir.
 *
 *      Normal object ve companion object kullaniminda arka planda olusturulan class static degildir. Burada kullanilan objectlerin
 *      static class olmasinin sebebi nested classlar olmasidir. Nested olan tum classlar static olarak tanimlanir arkaplanda.
 *
 *      Best practice olarak class icerisine object yazilmaz. companion object yazilir.
 */

interface HomeFragmentPresenter {
    fun navigate()

//    val surName = "UGUZLAR"

    val surName
        get() = "UGUZLAR"

    fun getSurName2(): String {
        return "UGUZLAR"
    }

    companion object {  // interfacelerin icerisinde state tutulmamalidir. Acilmamasi gereken bi kapidir.
        // bu kullanima basvurma
        val name = "Umut"
    }
}

abstract class BaseFragment

class HomeFragment : E(), HomeFragmentPresenter {

    var color = "Red"

    companion object Named : BaseFragment(), HomeFragmentPresenter {
        const val TAG: String = "HomeFragment"

        private var homeFragment: HomeFragment? = null

        fun newInstance(): HomeFragment {
            homeFragment = HomeFragment()
            return homeFragment as HomeFragment
        }

        override fun navigate() {

        }

    }

    fun ss() {
        println(HomeFragmentPresenter.name)  // interface icerisindeki state'e ulasilmistir.
    }

    object Deneme {
        const val carName = "BMW"
    }

    override fun navigate() {

    }
}

fun main() {

    HomeFragment().color
    val homeFragment = HomeFragment.newInstance()
    homeFragment.color = "Blue"
    val homeFragment2 = HomeFragment.newInstance()
    homeFragment.color = "Green"
    val homeFragment3 = HomeFragment.newInstance()
    homeFragment.color = "Yellow"

    println("homeFragment color: ${homeFragment.color}")
    println("homeFragment2 color: ${homeFragment2.color}")
    println("homeFragment3 color: ${homeFragment3.color}")

    HomeFragment.TAG
    HomeFragment.Deneme.carName
}