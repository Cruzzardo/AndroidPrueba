package com.example.androidimg

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class InfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
        View()
    }

    private lateinit var InfoPicture: ImageView
    private lateinit var txvInfo: TextView
    private lateinit var PictureStar: ImageView
    private lateinit var image: Image
    private var star: Boolean = false

    private fun View(){
        image = intent.getParcelableExtra("selectedImage") ?: Image()
        InfoPicture = findViewById(R.id.InfoPicture)
        txvInfo = findViewById(R.id.txvInfo)
        PictureStar = findViewById(R.id.PictureStar)

        InfoPicture.setImageResource(image.source)
        txvInfo.text = image.title + ": " + image.information
        if(image.star == false){
            PictureStar.setImageResource(R.drawable.estrella)
        }else{
            PictureStar.setImageResource(R.drawable.estrella_rellena)
        }

        InfoPicture.setOnClickListener{ showImage() }
        PictureStar.setOnClickListener { addToFav() }
    }

    private fun showImage(){
        startActivity(Intent(this, ImageActivity::class.java).apply {
            putExtra("ImageSource", image)
        })
    }

    private fun addToFav(){
        if(image.star == false && !star){
            PictureStar.setImageResource(R.drawable.estrella_rellena)
            star = true

            Image.images.forEach {
                when(it.id) {
                    image.id -> it.star = true
                }
            }
        }else{
            PictureStar.setImageResource(R.drawable.estrella)
            star = false

            Image.images.forEach {
                when(it.id) {
                    image.id -> it.star = false
                }
            }
        }
    }
}