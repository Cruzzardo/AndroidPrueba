package com.example.androidimg

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment

class CarouselActivity : Fragment(R.layout.activity_carousel) {
    override fun onResume() {
        super.onResume()
        initView()
    }

    private var cont = 0
    private var contL = Image.images.size
    private lateinit var IniPicture: ImageView
    private lateinit var btnIzq: Button
    private lateinit var btnDer: Button
    private lateinit var btnInf: Button
    private lateinit var IniFavorite: ImageView

    private fun initView() {
        IniPicture = requireView().findViewById(R.id.IniPicture)
        btnIzq = requireView().findViewById(R.id.btnIzq)
        btnDer = requireView().findViewById(R.id.btnDer)
        btnInf = requireView().findViewById(R.id.btnInf)
        IniFavorite = requireView().findViewById(R.id.IniFavorite)

        btnIzq.setOnClickListener{ backImage() }
        btnDer.setOnClickListener{ nextImage() }
        btnInf.setOnClickListener{ infImage() }

        Image.images.forEach {
            if (it.id == getChanges().id) {
                it.star = getChanges().star
            }
        }
        IniPicture.setImageResource(Image.images[cont].source)
    }


    private fun nextImage() {
        cont++
        if(cont < contL){
            IniPicture.setImageResource(Image.images[cont].source)
        }else{
            cont = 0
            IniPicture.setImageResource(Image.images[cont].source)
        }
    }

    private fun backImage() {
        cont--
        if(cont >= 0){
            IniPicture.setImageResource(Image.images[cont].source)
        }else{
            cont = contL - 1
            IniPicture.setImageResource(Image.images[cont].source)
        }
    }

    private fun infImage() {
        (requireActivity() as MainActivity).replaceFragment(InfoActivity().apply {
            arguments = Bundle().apply {
                putParcelableArray("ImagesArray", Image.images)
                putInt("selectedImage", cont)
            }
        })
    }

    private fun getChanges(): Image {
        return (requireActivity() as MainActivity).preferences.getString(
            (requireActivity() as MainActivity).impeferen,
            null
        )?.let {
            return@let try {
                (requireActivity() as MainActivity).moshi.adapter(Image::class.java)
                    .fromJson(it)
            } catch (e: Exception) {
                Image()
            }
        } ?: Image()
    }
}