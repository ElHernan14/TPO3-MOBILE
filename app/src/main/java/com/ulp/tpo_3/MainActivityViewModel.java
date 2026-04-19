package com.ulp.tpo_3;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

import android.app.Application;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.ulp.tpo_3.modelo.Libro;
import com.ulp.tpo_3.network.ApiService;
import com.ulp.tpo_3.network.RetrofitClient;
import com.ulp.tpo_3.network.mapper.LibroMapper;
import com.ulp.tpo_3.network.response.OpenLibraryResponse;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityViewModel extends AndroidViewModel {
    private ApiService api = RetrofitClient.getApiService();
    public MainActivityViewModel(@NonNull Application application) {
        super(application);
    }

     public void buscarLibro(String nombre) {

        api.buscarLibro(nombre).enqueue(new Callback<OpenLibraryResponse>() {
            @Override
            public void onResponse(Call<OpenLibraryResponse> call, Response<OpenLibraryResponse> response) {
                if(response.isSuccessful()) {
                    ArrayList<Libro> libros = new ArrayList<>();

                    if(response.body() == null) {
                        return;
                    }

                    for (OpenLibraryResponse.Doc libroDoc : response.body().docs) {
                        Libro libro = LibroMapper.fromDoc(libroDoc);
                        libros.add(libro);
                    }

                    Intent i = new Intent(getApplication(), SegundaActivity.class);
                    i.setFlags(FLAG_ACTIVITY_NEW_TASK);
                    i.putParcelableArrayListExtra("libros", libros);
                    getApplication().startActivity(i);

                }
            }

            @Override
            public void onFailure(Call<OpenLibraryResponse> call, Throwable t) {

            }
        });
    }
}
