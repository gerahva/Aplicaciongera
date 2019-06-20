package com.example.aplicaciongera

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_principal.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getSupportActionBar()?.hide()





        //Vamos a manejar el evento de botón por su ID.
       navegar.setOnClickListener {
           var i=Intent(this, MenuActivity::class.java)
           startActivity(i)
       }


    }



}
