package com.example.aplicaciongera

import android.content.Context
import android.os.AsyncTask
import android.view.View
import android.widget.Toast
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import kotlinx.android.synthetic.main.layout_buscar.*



class TareaActualizarCliente(private var ctx: Context?,
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

    cliente?.ident=activity?.txtidentbuscar?.text.toString()?.toInt()
     cliente?.nombre=   activity?.txtNombreBuscar?.text.toString()



        cliente?.mail=   activity?.txtmailbuscar?.text.toString()


        direccion.calle   =activity?.txtcallebuscar?.text.toString()


      direccion.cp=  activity?.txtcpbuscar?.text.toString()?.toInt()


      direccion.municipio=  activity?.txtmunibuscar?.text.toString()

        cliente.direccion=direccion



    }

    override fun doInBackground(vararg p0: Void?): Void? {
        try {

            var retrofit = Retrofit.Builder()
                .baseUrl("https://actuario.herokuapp.com/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build()
        var servicioCliente=retrofit.create(ClienteService::class.java)

    var  envio= servicioCliente.actualizarCliente(cliente)

      estatus= envio.execute().body()!!
            direccion= cliente.direccion!!

        } catch (t: Throwable) {
print("ERROR"+t.message)
        }
        return null

    }


}