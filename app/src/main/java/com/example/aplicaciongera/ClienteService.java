package com.example.aplicaciongera;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ClienteService {
    @POST("api/cliente")
    Call<Estatus> guardarCliente(@Body Cliente cliente);
}
