package com.example.androidimg

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class ImageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)

        initView()
    }

    private lateinit var FinalPicture: ImageView
    private lateinit var image: Image

    private fun initView(){
        image = intent.getParcelableExtra("ImageSource") ?: Image()
        FinalPicture = findViewById(R.id.FinalPicture)
        FinalPicture.setImageResource(image.source)
    }
}