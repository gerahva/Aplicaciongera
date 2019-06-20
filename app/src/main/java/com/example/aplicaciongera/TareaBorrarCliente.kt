package com.example.aplicaciongera

import android.content.Context
import android.os.AsyncTask
import android.util.Log
import android.view.View
import android.widget.Toast
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import kotlinx.android.synthetic.main.layout_buscar.*



class TareaBorrarCliente(private var ctx: Context?,
                         private var activity: MenuActivity?)
    : AsyncTask<Void, Void, Void>() {

    var estatus=Estatus()
    var cliente=Cliente()
    var direccion=Direccion()
    var identificador:Int?=null

    override fun onPostExecute(result: Void?) {

   Toast.makeText(ctx,estatus.mensaje,Toast.LENGTH_LONG).show()

        activity?.txtNombreBuscar?.setText(null)
        activity?.txtidentbuscar?.setText(null)


        activity?.txtmailbuscar?.setText(null)


        activity?.txtcallebuscar?.setText(null)


        activity?.txtcpbuscar?.setText(null)


        activity?.txtmunibuscar?.setText(null)


    }

    override fun onPreExecute() {
        super.onPreExecute()
        identificador=activity?.txtidentbuscar?.text.toString().toInt()

    }

    override fun doInBackground(vararg p0: Void?): Void? {
        try {

            var retrofit = Retrofit.Builder()
                .baseUrl("https://actuario.herokuapp.com/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build()
        var servicioCliente=retrofit.create(ClienteService::class.java)

    var  envio= servicioCliente.borrarCliente(identificador)

      estatus= envio.execute().body()!!


        } catch (t: Throwable) {
print("ERROR"+t.message)
        }
        return null

    }


}