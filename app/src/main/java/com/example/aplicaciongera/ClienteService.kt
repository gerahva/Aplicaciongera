package com.example.aplicaciongera

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ClienteService {
    @POST("api/cliente")
    fun guardarCliente(@Body cliente: Cliente): Call<Estatus>
}
