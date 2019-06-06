package com.example.aplicaciongera

import retrofit2.Call
import retrofit2.http.*

interface ClienteService {


    @POST("api/cliente")
    fun guardarCliente(@Body cliente: Cliente): Call<Estatus>


    @PUT("api/cliente")
    fun actualizarCliente(@Body cliente: Cliente): Call<Estatus>

    @DELETE("api/cliente/{ident}")
    fun borrarCliente(@Path("ident") ident: Int): Call<Estatus>

    //Servicio REST para buscar un cliente por su ident
    @GET("api/cliente/{ident}")
    fun buscarCliente(@Path("ident") ident:Int?): Call<Cliente>

}
