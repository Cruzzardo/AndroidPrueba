package com.example.androidimg

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class ImageActivity : Fragment(R.layout.activity_image) {
    override fun onResume() {
        super.onResume()
        initView()
    }

    private lateinit var FinalPicture: ImageView
    private lateinit var image: Image

    private fun initView(){
        image = requireArguments().getParcelable("ImageSource") ?: Image()
        FinalPicture = requireView().findViewById(R.id.FinalPicture)
        FinalPicture.setImageResource(image.source)
    }
}