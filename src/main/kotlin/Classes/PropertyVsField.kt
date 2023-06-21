package Classes

import java.util.prefs.BackingStoreException

/**
 *      Javada field ve property mantigi;
 *
 *      private String name;  bu field, variable, degisken veya backing field olarak adlandirilir.
 *
 *      public String getName(){    // getName ve setName functionlari ise bu degiskenin propertyleridir.
 *          return name;
 *      }
 *
 *      public void setName(String name) {
 *          this.name = name
 *      }
 *
 *      Kotlinde field tanimlanmasi yoktur. Her zaman degisken gibi tanimladigimiz seyler aslinda propertydir.
 *
 *      Not: Encapsulation mantigi propertyi iyi anlamak icin onemlidir. Bir field (degisken) private olarak tanimlanir
 *      ve bu degiskene ulasmak icin get ve set (propertyleri) olusturulurdu javada.
 *      Kotlinde ise bir degisken (field) olusturdugumuzu sansak da aslinda arka planda o degisken private olarak
 *      tanimlanmistir ve beraberinde get ve set fonksiyonlari yani propertyleri de olusturulmustur.
 *      Eger bir class icerisinde private degisken tanimlarsak bunun get ve set propertyleri olusuturulmaz.
 *      Boylece asla bu degiskenin degerine ulasamaz ve degerini degistiremeyiz class disinda.
 *
 *      Kotlinde encapsulation mantigi yukaridaki mantikla calisir.
 *
 *      Bu ozellikler sebbeiyle kotlinde ayni zamanda fonskiyonlar gibi degiskenleri de extend edebiliriz.
 *      Degisken tanimaladigimizda aslinda onun propertysi olusmus oldugundandir. Extension function gibi extension
 *      variable tanimlaninca o degiskenin backing fieldi olmaz. O degiskenin get ve set fonksiyonunu extend etmis oluruz.
 *
 *      Not: Kotlinde hicbir zaman gercek anlamda degisken tanimlayamayiz. Get ve set fonksiyonlari tanimlariz.
 *
 *      Not: get ve seti olusturulan fieldin visibilitysine gore visibility eklenebilir. Yani bir field public ise o tum
 *      visibility modifierlari alabilir fakat bir field private ise get ve set o gizlilige es deger veya daha gizli bir modifier
 *      almasi gerekir. Yani sadece private alabilir.
 *
 */
class BankAccount {

    var balance = 1_000_000
        public get() { // public gereksiz bir kullanim
            return field // field = backing field
        }
        set(value) {  // private yapilirsa main icerisinde balance degeri degistirelemez
            field = value
        }   /*  Bu kullanimi yazmanin bir amaci olmali seti private tanimlamak veya bir bussiness logic gommek
                istersek bu kullanim yapilmalidir.
            */

    fun memberFunction() {
        balance
    }
}

fun main() {
    val bankAccount = BankAccount()
    println(bankAccount.balance)
    bankAccount.balance = 500_000 // bu kod asagidaki ile aynidir.
//    bankAccount.setBalance(500_000)
    println(bankAccount.balance)
}