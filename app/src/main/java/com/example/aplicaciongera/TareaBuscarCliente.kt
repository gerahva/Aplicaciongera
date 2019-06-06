package com.example.aplicaciongera

import android.content.Context
import android.os.AsyncTask
import android.view.View
import android.widget.Toast
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import kotlinx.android.synthetic.main.layout_buscar.*



class TareaBuscarCliente(private var ctx: Context?,
                         private var activity: MenuActivity?)
    : AsyncTask<Void, Void, Void>() {

    var estatus=Estatus()
    var cliente=Cliente()
    var direccion=Direccion()

    override fun onPostExecute(result: Void?) {

        //Invocamos nuestra visita del MainActivity
        //  activity?.findViewById<TextView>(R.id.txtActual)?.text=estacion?.temp_c
        Toast.makeText(ctx,"Encontrado ${cliente.nombre}", Toast.LENGTH_LONG).show()
    //direccion=cliente.direccion!!

        if(cliente!=null){
            activity?.txtNombreBuscar?.visibility= View.VISIBLE
            activity?.txtNombreBuscar?.setText(cliente.nombre)

            activity?.txtmailbuscar?.visibility= View.VISIBLE
            activity?.txtmailbuscar?.setText(cliente.mail)

            activity?.txtcallebuscar?.visibility= View.VISIBLE
            activity?.txtcallebuscar?.setText(direccion.calle)

            activity?.txtcpbuscar?.visibility= View.VISIBLE
            activity?.txtcpbuscar?.setText(direccion.cp.toString())

            activity?.txtmunibuscar?.visibility= View.VISIBLE
            activity?.txtmunibuscar?.setText(direccion.municipio)
        }



    }

    override fun onPreExecute() {
        super.onPreExecute()
        //GENERAMOS UN USUARIO
      cliente.ident=   activity?.txtidentbuscar?.text.toString().toInt()

        //cliente.nombre= activity?.txtnombre?.text.toString()

        //cliente.mail= activity?.txtmail?.text.toString()

        //direccion.calle= activity?.txtcalle?.text.toString()

        //direccion.cp= activity?.txtcp?.text.toString().toInt()

        //direccion.municipio= activity?.txtmuni?.text.toString()

        //cliente.direccion=direccion
    }

    override fun doInBackground(vararg p0: Void?): Void? {
        try {

            var retrofit = Retrofit.Builder()
                .baseUrl("https://actuario.herokuapp.com/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build()
        var servicioCliente=retrofit.create(ClienteService::class.java)

    var  envio= servicioCliente.buscarCliente(cliente.ident)

      cliente= envio.execute().body()!!
           direccion= cliente.direccion!!
            println("la calle en el background es ${cliente?.direccion?.calle}")



        } catch (t: Throwable) {
print("ERROR"+t.message)
        }
        return null

    }


}