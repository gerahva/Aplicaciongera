package com.example.aplicaciongera

import android.net.Uri
import android.os.Bundle
import android.util.Log
import com.google.android.material.navigation.NavigationView
import androidx.core.view.GravityCompat
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.activity_menu.*
import kotlinx.android.synthetic.main.app_bar_menu.*
import kotlinx.android.synthetic.main.layout_guardar.*
import kotlinx.android.synthetic.main.layout_principal.*
import kotlinx.android.synthetic.main.layout_actualizar.*
import kotlinx.android.synthetic.main.layout_borrar.*
import kotlinx.android.synthetic.main.layout_buscar.*
import kotlinx.android.synthetic.main.layout_listahoteles.*


class MenuActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    var cliente: Cliente? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        setSupportActionBar(toolbar)




        //Video
        //Video

        val uri= Uri.parse("https://sierra-guadalupe.org/max.mp4")
        videoView.setVideoURI(uri)
        videoView.requestFocus()
        videoView.start()

        videoView.setOnCompletionListener {
            videoView.start()
        }

        ocultarTodo()

        layout_principal.visibility = View.VISIBLE

        //En este sitio van todos los OnClick de tu menu


     botonActualizar.visibility=View.INVISIBLE
     botonBorrar.visibility=View.INVISIBLE
        // ESTE PARTE VAMOS A GUARDAR EL CLIENTE QUE CAPTUREMOS DE LA INTERFAZ
        guardar.setOnClickListener {
            TareaGuardarCliente(this, this).execute()
        }

        //EN ESTA PARTE VAMOS A BUSCAR AL CLIENTE Y LO MOSTRAREMOS EN LA INTERFAZ

        buscar.setOnClickListener {
           TareaBuscarCliente(this, this).execute(null,null,null)
            botonActualizar.visibility=View.VISIBLE
            botonBorrar.visibility=View.VISIBLE

        }


//Actualizar

        botonActualizar.setOnClickListener {
            TareaActualizarCliente(this,this).execute().get()
        }

        botonBorrar.setOnClickListener {
            TareaBorrarCliente(this,this).execute().get()
            botonActualizar.visibility=View.INVISIBLE
            botonBorrar.visibility=View.INVISIBLE
        }


        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }

    fun obtenerCamposParaActualizar(){
        //CAMPOS QUE APARECERAN EN LA PANTALLA DE LA APP UNA VEZ QUE SEAN BUSCADOS, PARA PROCEDER A BORRARLOS:



    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_principal -> {
                // Handle the camera action
                ocultarTodo()
                layout_principal.visibility = View.VISIBLE


            }
            R.id.nav_guardar -> {
                ocultarTodo()
                layout_guardar.visibility = View.VISIBLE
                txtident.text = null
                txtnombre.text = null
                txtmail.text = null
                txtcalle.text = null
                txtcp.text = null
                txtmuni.text = null


            }

            R.id.nav_listahoteles->{
                ocultarTodo()

                layout_lista_hoteles.visibility=View.VISIBLE
            }
            /*
            R.id.nav_actualizar -> {
                ocultarTodo()
                layout_actualizar.visibility = View.VISIBLE
            }
            R.id.nav_borrar -> {
                ocultarTodo()
                layout_borrar.visibility = View.VISIBLE
                txtidentborrar.text = null
                txtnombreborrar.text = null
                txtmailborrar.text = null
                txtcalleborrar.text = null
                txtcpborrar.text = null
                txtmuniborrar.text = null
            }
            */
            R.id.nav_buscar -> {
                ocultarTodo()
                layout_buscar.visibility = View.VISIBLE
                txtNombreBuscar.text = null
                txtmailbuscar.text = null
                txtcallebuscar.text = null
                txtcpbuscar.text = null
                txtmunibuscar.text = null


            }

        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    fun ocultarTodo() {


        botonActualizar.visibility=View.INVISIBLE
        botonBorrar.visibility=View.INVISIBLE


        val principal = layout_principal as ConstraintLayout
        principal.visibility = View.INVISIBLE

        val guardar_cliente = layout_guardar as ConstraintLayout
        guardar_cliente.visibility = View.INVISIBLE

        val actualizar_cliente = layout_actualizar as ConstraintLayout
        actualizar_cliente.visibility = View.INVISIBLE

        val borrar_cliente = layout_borrar as ConstraintLayout
        borrar_cliente.visibility = View.INVISIBLE

        val buscar_cliente = layout_buscar as ConstraintLayout
        buscar_cliente.visibility = View.INVISIBLE


        val lista_hoteles=layout_lista_hoteles as ConstraintLayout
        lista_hoteles.visibility=View.INVISIBLE
    }

    override fun onPostResume() {
        super.onPostResume()
        val uri= Uri.parse("https://sierra-guadalupe.org/max.mp4")
        videoView.setVideoURI(uri)
        videoView.requestFocus()
        videoView.start()

        videoView.setOnCompletionListener {
            videoView.start()
        }

    }
}
