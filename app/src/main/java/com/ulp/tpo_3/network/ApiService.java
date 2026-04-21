package com.ulp.tpo_3.network;
import com.ulp.tpo_3.modelo.OpenLibraryResponse;
import com.ulp.tpo_3.modelo.WorkResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface ApiService {

    //endpoint para buscar libros
    @GET("search.json")
    Call<OpenLibraryResponse> buscarLibro(
            @Query("title") String query,
            @Query("page") int page
    );

    //endpoint para obtener detalles del libro
    @GET("works/{keyBook}.json")
    Call<WorkResponse> obtenerDetallesLibro(@Path("keyBook") String query);
}
