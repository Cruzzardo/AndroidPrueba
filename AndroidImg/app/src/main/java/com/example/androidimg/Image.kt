package com.example.androidimg

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize

class Image(

    var id: Int? = null,
    var title: String = "",
    var information: String = "",
    var source: Int = 0,
    var star: Boolean? = null

) : Parcelable {
    companion object {
        val images = arrayOf(
            Image(1, "Castillo", "Castillo que lo puse porque no sabia que poner, pero estaba chido", R.drawable.ic_castillo_de_bran, false),
            Image(2, "Instagram", "Es una aplicación y red social de origen estadounidense, propiedad de Facebook, cuya función principal es poder compartir fotografías y vídeos con otros usuarios.", R.drawable.instagram, false),
            Image(3, "TikTok", "Tik Tok es una red social de origen chino que consiste en crear videos cortos para compartirlos", R.drawable.tik_tok, false),
            Image(4, "Sol", "El Sol es una estrella, es decir, un cuerpo celeste que brilla con luz propia, compuesto de hidrógeno y helio a enormes temperaturas en estado de plasma.", R.drawable.sol, false),
            Image(5, "Rayo", "Es egocéntrico, arrogante, presumido y confiado, creyendo que puede ganar la Copa Piston por su cuenta", R.drawable.rayo, false),
            Image(6, "Caballero", "Un jinete o persona que monta a caballo o, más estrictamente, una persona de origen noble", R.drawable.caballero, false)
        )
    }
}