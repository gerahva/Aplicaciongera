package com.example.aplicaciongera

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.core.view.GravityCompat
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.activity_menu.*
import kotlinx.android.synthetic.main.app_bar_menu.*
import kotlinx.android.synthetic.main.content_menu.*
import kotlinx.android.synthetic.main.layout_guardar.*
import kotlinx.android.synthetic.main.layout_principal.*
import kotlinx.android.synthetic.main.layout_actualizar.*
import kotlinx.android.synthetic.main.layout_borrar.*
import kotlinx.android.synthetic.main.layout_buscar.*


class MenuActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        setSupportActionBar(toolbar)

     ocultarTodo()

        layout_principal.visibility=View.VISIBLE

//En este sitio van todos los OnClick de tu menu
        guardar.setOnClickListener {
            TareaGuardarCliente(this,this).execute()
        }
        buscar.setOnClickListener {
            TareaBuscarCliente(this,this).execute()
            txtidentbuscar.text=null
        }





        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
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
             layout_principal.visibility=View.VISIBLE



            }
            R.id.nav_guardar -> {
    ocultarTodo()
                layout_guardar.visibility= View.VISIBLE
            }
            R.id.nav_actualizar -> {
                ocultarTodo()
                layout_actualizar.visibility= View.VISIBLE
            }
            R.id.nav_borrar -> {
                ocultarTodo()
                layout_borrar.visibility= View.VISIBLE
            }
            R.id.nav_buscar -> {
                ocultarTodo()
                layout_buscar.visibility= View.VISIBLE
                txtNombreBuscar.text=null


            }
            R.id.nav_slideshow -> {

            }
            R.id.nav_manage -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    fun ocultarTodo(){


        val principal= layout_principal as ConstraintLayout
        principal.visibility= View.INVISIBLE

        val guardar_cliente= layout_guardar as ConstraintLayout
        guardar_cliente.visibility= View.INVISIBLE

        val actualizar_cliente= layout_actualizar as ConstraintLayout
        actualizar_cliente.visibility= View.INVISIBLE

        val borrar_cliente= layout_borrar as ConstraintLayout
        borrar_cliente.visibility= View.INVISIBLE

        val buscar_cliente= layout_buscar as ConstraintLayout
        buscar_cliente.visibility= View.INVISIBLE
    }
}
