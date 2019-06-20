package com.example.aplicaciongera

import android.content.Context
import android.os.AsyncTask
import android.widget.Toast
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import kotlinx.android.synthetic.main.layout_guardar.*



class TareaGuardarCliente(private var ctx: Context?,
                          private var activity: MenuActivity?)
    : AsyncTask<Void, Void, Void>() {

    var estatus=Estatus()
    var cliente=Cliente()
    var direccion=Direccion()

    override fun onPostExecute(result: Void?) {

        //Invocamos nuestra visita del MainActivity
        //  activity?.findViewById<TextView>(R.id.txtActual)?.text=estacion?.temp_c
        Toast.makeText(ctx,estatus.mensaje, Toast.LENGTH_LONG).show()



    }

    override fun onPreExecute() {
        super.onPreExecute()
        //GENERAMOS UN USUARIO quitarlos de aqui y ponerlo en menuactivity previo a invocar el excute
        cliente.ident=   activity?.txtident?.text.toString().toInt()

        cliente.nombre= activity?.txtnombre?.text.toString()

        cliente.mail= activity?.txtmail?.text.toString()

        direccion.calle= activity?.txtcalle?.text.toString()

        direccion.cp= activity?.txtcp?.text.toString().toInt()

        direccion.municipio= activity?.txtmuni?.text.toString()

        cliente.direccion=direccion
    }

    override fun doInBackground(vararg p0: Void?): Void? {
        try {

            var retrofit = Retrofit.Builder()
                .baseUrl("https://actuario.herokuapp.com/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build()
        var servicioCliente=retrofit.create(ClienteService::class.java)

    var  envio= servicioCliente.guardarCliente(cliente)

      estatus= envio.execute().body()!!

        } catch (t: Throwable) {
println("ERROR"+t.message)
        }
        return null

    }


}