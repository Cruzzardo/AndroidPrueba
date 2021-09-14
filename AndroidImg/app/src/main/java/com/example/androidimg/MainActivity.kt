package com.example.androidimg

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.squareup.moshi.Moshi

private val Peferen = "Preferencias"
private lateinit var preferences: SharedPreferences
private val moshi = Moshi.Builder().build()

class MainActivity : AppCompatActivity() {

    val Peferen = "Preferencias"
    lateinit var preferences: SharedPreferences
    val moshi = Moshi.Builder().build()
    val impeferen = "im_Preferent"

    fun replaceFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            setCustomAnimations(
                R.anim.slide_in_right,
                R.anim.slide_out_left,
                R.anim.slide_in_left,
                R.anim.slide_out_right)
            replace(R.id.container, fragment)
            addToBackStack(fragment.tag)
            commit()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        preferences = getSharedPreferences(Peferen, Context.MODE_PRIVATE)
        supportFragmentManager.beginTransaction().add(R.id.container, CarouselActivity()).commit()
    }
}