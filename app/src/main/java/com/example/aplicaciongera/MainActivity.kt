package com.example.aplicaciongera

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getSupportActionBar()?.hide()
        //Vamos a manejar el evento de botón por su ID.
        ingresar.setOnClickListener {
            var i=Intent(this,MenuActivity::class.java)
            startActivity(i)

        }
    }
}
