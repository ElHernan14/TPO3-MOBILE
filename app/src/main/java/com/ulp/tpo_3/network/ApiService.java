package com.ulp.tpo_3.network;
import com.ulp.tpo_3.network.response.OpenLibraryResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface ApiService {

    //endpoint para buscar libros
    @GET("search.json")
    Call<OpenLibraryResponse> buscarLibro(@Query("q") String query);
}
