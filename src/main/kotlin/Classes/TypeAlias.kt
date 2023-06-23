package Classes

/**
 *      Nested ya da local typeAlias kullanimi desteklenmiyor. Top levelda yapilmalidir.
 *
 *      Basitce isim map etmektir. Uzun isimli classlarin isimlerini kisaltmak icin kullanilir.
 *
 *      typeAlias'lar arka planda yeni bir class olusturmazlar. Sadece etiketleme yaparlar.
 */

typealias AccountReferenceVM = ProjectContractChargingPeriodProjectAccountReferenceVM

fun main() {
    val accountReferenceVM = AccountReferenceVM()
}

class ProjectContractChargingPeriodProjectAccountReferenceVM {

}