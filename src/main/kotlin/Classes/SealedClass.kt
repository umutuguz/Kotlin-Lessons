package Classes


/**
 *      enum ile sealed class arasindaki farklar;
 *      1. sealed classlarin icerisindekiler classtir ama enumlarin icindekiler class (sadece arkaplanda classtir) degildir.
 *      2. enum icerisindeki sabitlere birbirinden farkli gorevler veremeyiz fakat sealed classlarda
 *      her bir subclassin kendi body'si farkli gorevleri olabilir.
 *      3. enumlar temelde veri tutar sealed classlar class tutar.
 *      4. sealed classlarin subclasslari birbirinden farklilasabilirler. Tek zorunlu ortak yonleri ayni
 *      sealed classi miras almalaridir.
 */


/**
 *      Sinirli kumede, gruplanabilir, class 'lar yazmayi saglar.
 *      Kisitlanmis bir class hiyerarsisi kurabilmenizi saglar.
 *      Bu class'lar arka planda static olarak tutulmazlar. Enumaration'lardan en buyuk farki budur.
 *      Enum'lar verileri gruplarken, sealed class'lar class'lari gruplar.
 *
 *      Sealed class 'lar abstract class'lardir ayni zamanda. Abstract olduklari icin open olmazlar.
 *      Sealed class'lar Abstract class olduklari icin final olamazlar. Anlamsal olarak zaten sacmadir.
 *
 *      Sealed class'larin nesnesi olusturulamaz. Constructor'ları protected ve private olarak bulunur.
 *
 *      Sealed classlari miras alan subClasslar final olduklari icin miras alinamazlar. SDKler icin onemlidir.
 *
 *      Sealed class'in subclass'larinin neler oldugu compiletime'da bilinmektedir. Bundan dolayi when ve if
 *      yapilarinda else caselerinin yazimina ihtiyac duyulmaz.
 *
 *      Sealed classlari extends alan subclasslar eskiden ayni dosya uzerinde bulunma zorunlulugu vardi.
 *      Bu zorunluluk esnetilerek ayni package icerinde olmaya kadar genisletildi.
 *      Ancak ayni package disina cikip, bir subclass'a sealed class'i miras olarak vermek isterseniz buna izin verilmez.
 *      Ozellikle SDK yazilirken bu kisitlama onemlidir.
 *
 *      sealed classlar icerisine object tanimlamalari da yapilabilir.
 *      sealed classlar icerisine sadece object tanimi yapiyorsaniz, bu kullanimin enumaration'dan teknik olarak
 *      hicbir farki kalmiyor.
 */

// Asagidaki 2 yontem birbirine estir.
sealed class Response
class  Success : Response() {

}
class Error : Response() {

}

sealed class Response2 {
    class Success2 : Response2() {

    }
    class Error2 : Response2() {

    }
}

fun handle(response: Response) {
    when(response) {
        is Success -> {
            // response'dan gelen bilgilerle ui'ini doldur.
        }
        is Error -> {
            // pop-up ile kullaniciya bilgi ver.
        }
        else -> {
            // burada else yazmaya gerek yoktur. sealed class icerisindeki tum senaryolar verilmistir.
        }
    }
}

// bu kullanim yanlistir. enum kullanilmasi gerekmektedir.
sealed class PaymentOption {
    object Cash
    object Card
    object Transfer
}

enum class PaymentOption2 {
    Cash, Card, Transfer
}

fun main() {
//    val response = Response()

    val success = Success()
    val error = Error()

    handle(success)
    handle(error)
}