package Functions

import java.math.BigDecimal

fun main() {
    val bankAccount = BankAccount(
        23456.412.toBigDecimal(), "Umut"
    )

    if (bankAccount != null && bankAccount.accountName != null) {
        println(bankAccount.accountName)
    }

    // Yapisal olarak let run with benzerdir.
    bankAccount.let { }    // nullable nesnesi olusturulmus bir degiskenle islem yapmak icin let


    with(bankAccount) { // nullable olmayan nesnesi olusturulmus bir degiskenle islem icin with

    }

    bankAccount.run { }     // herhangi bir calistirilabilir logicleri icerin bir scope olarak kullanilir.
    run { }

    // Yapisal olarak also ve apply birbirine benzerdir.
    bankAccount.also { }    // let ya da with ya da apply in sonuna konulur genelde. Bir de bunlarin disinda bir de
    // baska bir business logic calistirmak icin kullanilir. Baslangic yapisi olarak kullanilmaz.

    bankAccount.apply { }   // temel amaci bir classin nesnelerinin en bastan sifirdan class degiskenlerinin doldurulmasidir.
    // constructorundan parametre alan classlar ile calistirilmaz. Mesela data classlar

    /**
     *      Not: let, apply, with en basta olmalidir. also kesinlikle basta olmamalidir. run 2 yerde de olabilir.
     */
}

data class BankAccount(
    val accountBalance: BigDecimal?,
    val accountName: String?,
)