package Classes

import java.lang.reflect.Field
import java.lang.reflect.Method

/**
 *      proGuards olayina dikkat edilmeli. Ya class icerisinde degiskenlerin yerleri degistirilmemeli
 *      ya da proGuards'a kural yazilip o degiskenin adini basitlestirmesi engellenmelidir. Aksi halde
 *      reflection calismasinda sikinti cikma ihtimali yuksektir.
 *
 *      Reflection third party sdklerde kullanilmak icin vardir.Kendi classlarinda yapmak mantikli degildir.
 *      Basit olarak publice cekilebilir.
 */
class Wallpaper {
    private var imageUrl: String = "www.instagram.com"
    private var id: Int = 1357
    private var type: Int = 3
    private var width: Int = 1920
    private var height: Int = 1080
    private var isGif: Boolean = false
    private var previewUrl: String = "www.instagrampreview.com"

    private fun deneme() {

    }
}

fun main() {
    val wallpaper = Wallpaper()
//    wallpaper.imageUrl = "www.instagram"
//    wallpaper.id = 1357
//    wallpaper.type = 3
//    wallpaper.width = 1920
//    wallpaper.height = 1080
//    wallpaper.isGif = false
//    wallpaper.previewUrl = "www.instagrampreview.com"

//    println(wallpaper.imageUrl)

    val imageUrlField: Field = wallpaper.javaClass.getDeclaredField("imageUrl")
    val imageUrlFieldName = wallpaper.javaClass.declaredFields[0].name
    val imageUrlField2: Field = wallpaper.javaClass.getDeclaredField(imageUrlFieldName)
    imageUrlField.isAccessible = true
    imageUrlField2.isAccessible = true

    val imageUrlString = imageUrlField.get(wallpaper)
    val imageUrlString2 = imageUrlField2.get(wallpaper)
    println(imageUrlString)
    println(imageUrlString2)

//    val denemeMethod: Method = wallpaper.javaClass.getMethod("deneme")
//    denemeMethod.isAccessible = true
//
//    val denemeMethodd = denemeMethod

}