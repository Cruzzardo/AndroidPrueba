package com.example.androidimg

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class InfoActivity : Fragment(R.layout.activity_info) {
    override fun onResume() {
        super.onResume()
        View()
    }

    private lateinit var InfoPicture: ImageView
    private lateinit var txvInfo: TextView
    private lateinit var PictureStar: ImageView //id el activity_info
    private lateinit var Favorite: ImageView //id en el activity_info
    private var starB: Boolean = false
    private var favoriteB: Boolean = false
    private lateinit var images: Array<Image>
    var Select = 0


    private fun View(){
        images = requireArguments().getParcelableArray("ImagesArray") as Array<Image>
        Select = requireArguments().getInt("selectedImage")
        InfoPicture = requireView().findViewById(R.id.InfoPicture)
        txvInfo = requireView().findViewById(R.id.txvInfo)
        PictureStar = requireView().findViewById(R.id.PictureStar)
        Favorite = requireView().findViewById(R.id.Favorite)

        InfoPicture.setImageResource(images[Select].source)
        txvInfo.text = images[Select].title + ": " + images[Select].information

        if(images[Select].star == false){
            PictureStar.setImageResource(R.drawable.estrella)
        }else{
            PictureStar.setImageResource(R.drawable.estrella_rellena)
        }

        if(images[Select].favorite == false){
            Favorite.setImageResource(R.drawable.corazon)
        }else{
            Favorite.setImageResource(R.drawable.corazon_relleno)
        }

        playSound(images[Select].sound)

        InfoPicture.setOnClickListener{ showImage() }
        PictureStar.setOnClickListener { addToFav() }
        Favorite.setOnClickListener { addToFavSd() }
    }

    private fun addToFav(){
        if(images[Select].star == false && !starB){
            PictureStar.setImageResource(R.drawable.estrella_rellena)
            starB = true

            Image.images[Select].star = true
            Image.images.forEach {
                if(it.id == images[Select].id){
                    it.star = true
                    images[Select].star = true
                }else{
                    it.star = false
                }
            }
        }else{
            PictureStar.setImageResource(R.drawable.estrella)
            starB = false

            Image.images[Select].star = false
            Image.images.forEach {
                if(it.id == images[Select].id){
                    it.star = false
                    images[Select].star = false
                }
            }
        }
        (requireActivity() as MainActivity).preferences.edit().putString((requireActivity() as MainActivity).impeferen, (requireActivity() as MainActivity).moshi.adapter(Image::class.java).toJson(Image.images[Select])).commit()
    }

    private fun addToFavSd() {
        if (images[Select].favorite == false && !favoriteB) {
            Favorite.setImageResource(R.drawable.corazon_relleno)
            favoriteB = true

            Image.images[Select].favorite = true
            Image.images.forEach {
                if (it.id == images[Select].id) {
                    it.favorite = true
                    images[Select].favorite = true
                } else {
                    it.favorite = false
                }
            }
        } else {
            Favorite.setImageResource(R.drawable.corazon)
            favoriteB = false

            Image.images[Select].favorite = false
            Image.images.forEach {
                if (it.id == images[Select].id) {
                    it.favorite = false
                    images[Select].favorite = false
                }
            }
        }
    }
    private fun playSound(sound: Int) = MediaPlayer.create(context, sound).start()


    private fun showImage(){
        (requireActivity() as MainActivity).replaceFragment(ImageActivity().apply {
            arguments = Bundle().apply {
                putParcelable("imageSource", images[Select])
            }
        })
    }
}