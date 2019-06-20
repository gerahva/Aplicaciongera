package com.example.aplicaciongera

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso

class PicassoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_picasso)
        Picasso.with(this).load("https://static.pexels.com/photos/288264/pexels-photo-288264.jpeg").fetch()
        
    }
}
