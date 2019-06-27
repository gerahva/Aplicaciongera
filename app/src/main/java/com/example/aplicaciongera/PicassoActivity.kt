package com.example.aplicaciongera

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_picasso.*


class PicassoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_picasso)

        buttonLoader.setOnClickListener { loadImages()

        }
        Picasso.with(this).load("https://static.pexels.com/photos/288264/pexels-photo-288264.jpeg").fetch()
        
    }

    private fun loadImages(){

        Picasso.with(this)
            .load("https://static.pexels.com/photos/288264/pexels-photo-288264.jpeg")
            .fit()
            .into(imageViewTop)

        Picasso.with(this)
            .load("https://static.pexels.com/photos/288929/pexels-photo-288929.jpeg")
            .fit()
            .into(imageViewBottom)

    }
}
