package Classes;

class Profile { // en temiz singleton patterni budur.

    private volatile static Profile profile;  // classin 1 adet nesnesi ve private olarak disaridan bu nesneye hernaagi bi deger atanmasi engellenmistir mesela null
                                              // boylece bir kere olusturulan nesne bir daha null ile resetlenemeyecektir.
                                              // volatile keywordu de ayni anda sadece tek bir threadin bu degiskene erismesine izin verir.

    public String name;

    private Profile() {  // constructor bunun private yapilmasi ile bu classin nesnesi disaridan olusturulamaz.

    }

    // hicbir public constructor olmamali
    public static synchronized Profile newInstance() {  // public bir getInstance fonksiyonudur. private nesneyi geri donduren bir fonksiyondur.
        if (profile == null) {                          // ayni zamanda static keywordu ile de disaridan Profile classsinin bir nesnesi olmadan bu fonksiyona ulasilabilme ozelligi saglatir.
            profile = new Profile();
        }
                                                        // synchronized keywordu mutl thread ile calisan bir islemcide 3 ayri threadin asagidaki profile1,2,3 icin yeni birer
                                                        // nesne olusturma riskini ortadan kaldirmak icin vardir. Cozum bir thread bu fonksiyonun icerisine girdiginde o functionu kitleyerek diger threadlerin o sirada islem yapmasini engelller.
        return profile;                                 // buradaki if yapisi ile 2. 3. nesnelerin yaratilmasinin onune gecilmistir. eger bir nesne varsa o nesne kalmaya devam eder. Nullsa ilk nesne olusturulur.
    }

    public static void main(String[] args) {
        Profile profile1 = new Profile(); // hata verecektir burasi (contract kullanimindan dolayi hata vermiyor gibi durmakta)

//        Profile.newInstance();

        Profile profile = Profile.newInstance();
//        Profile profile = new Profile().newInstance(); constructor private oldugu icin ve ayni zamanda newInstance functionu static oldugu icin boyle profile nesnesi olusturulur.
        Profile profile2 = Profile.newInstance();
        Profile profile3  = Profile.newInstance();

//        Profile profile1 = new Profile("Umut");   // Ana sayfa
//        Profile profile2 = new Profile("Ark Hu"); // profil ekrani
//        Profile profile3 = new Profile("Umut"); // tekrar ana sayfa

//        profile1.getNickName();

        Profile profile6 = Profile.newInstance();
        profile6.name = "Umut";
    }
}
