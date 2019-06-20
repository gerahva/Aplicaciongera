package com.example.aplicaciongera

import android.content.Context
import android.os.AsyncTask
import android.util.Log
import android.view.View
import android.widget.Toast
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import kotlinx.android.synthetic.main.layout_buscar.*


class TareaBuscarCliente(
    var ctx: Context?,
    var activity: MenuActivity?
) : AsyncTask<Void, Void, Void>() {

    var estatus = Estatus()
    var cliente:Cliente?=null
var identificador:Int?=null


    var direccion = Direccion()

    override fun onPostExecute(result: Void?) {


        if(cliente!=null){
            activity?.txtNombreBuscar?.visibility = View.VISIBLE
            activity?.txtNombreBuscar?.setText(cliente?.nombre)

            activity?.txtmailbuscar?.visibility = View.VISIBLE
            activity?.txtmailbuscar?.setText(cliente?.mail)

            activity?.txtcallebuscar?.visibility = View.VISIBLE
            activity?.txtcallebuscar?.setText(cliente?.direccion?.calle)

            activity?.txtcpbuscar?.visibility = View.VISIBLE
            activity?.txtcpbuscar?.setText(cliente?.direccion?.cp.toString())

            activity?.txtmunibuscar?.visibility = View.VISIBLE
            activity?.txtmunibuscar?.setText(cliente?.direccion?.municipio)
        }else{
            Toast.makeText(ctx, "NO existe ese cliente con ese ident", Toast.LENGTH_LONG).show()
        }



       // Toast.makeText(ctx, "Encontrado ${cliente?.nombre}", Toast.LENGTH_LONG).show()

    }

    override fun onPreExecute() {
        super.onPreExecute()
        //GENERAMOS UN USUARIO

        Log.i("INFOR", " antes asignar al cliente"+ activity?.txtidentbuscar?.text.toString().toInt())

identificador=activity?.txtidentbuscar?.text.toString().toInt()





    }

    override fun doInBackground(vararg p0: Void?): Void? {
        try {

            Log.i("INFOR", "el identificador es "+identificador)

            var retrofit = Retrofit.Builder()
                .baseUrl("https://actuario.herokuapp.com/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build()
            var servicioCliente = retrofit.create(ClienteService::class.java)

            var envio = servicioCliente.buscarCliente(identificador)

            cliente = envio.execute().body()!!
            if(cliente!=null){
                direccion = cliente?.direccion!!
                Log.i("INFOR" ,"la calle en el background es ${cliente?.direccion?.calle}")
            }




        } catch (t: Throwable) {
          //  Log.i("INFOR" , t.message)
        }
        return null

    }


    fun hola() {
        print("hola")
    }

}