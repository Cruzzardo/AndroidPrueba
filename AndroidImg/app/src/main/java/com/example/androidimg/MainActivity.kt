package com.example.androidimg

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import com.squareup.moshi.Moshi

private val Peferen = "Preferencias"
private lateinit var preferences: SharedPreferences
private val moshi = Moshi.Builder().build()

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        preferences = getSharedPreferences(Peferen, Context.MODE_PRIVATE)
        initView()
    }


    private var cont = 0
    private var contL = Image.images.size
    private lateinit var IniPicture: ImageView
    private lateinit var btnIzq: Button
    private lateinit var btnDer: Button
    private lateinit var btnInf: Button

    private fun initView(){
        IniPicture = findViewById(R.id.IniPicture)
        btnIzq = findViewById(R.id.btnIzq)
        btnDer = findViewById(R.id.btnDer)
        btnInf = findViewById(R.id.btnInf)

        btnIzq.setOnClickListener{ backImage() }
        btnDer.setOnClickListener{ nextImage() }
        btnInf.setOnClickListener{ infImage() }

        IniPicture.setImageResource(Image.images[cont].source)
    }

    private fun nextImage(){
        cont++
        if(cont < contL){
            IniPicture.setImageResource(Image.images[cont].source)
        }else{
            cont = 0
            IniPicture.setImageResource(Image.images[cont].source)
        }
    }

    private fun backImage(){
        cont--
        if(cont >= 0){
            IniPicture.setImageResource(Image.images[cont].source)
        }else{
            cont = contL - 1
            IniPicture.setImageResource(Image.images[cont].source)
        }
    }

    private fun infImage(){
        startActivity(Intent(this, InfoActivity::class.java).apply { putExtra("selectedImage", Image.images[cont]) })
    }
}