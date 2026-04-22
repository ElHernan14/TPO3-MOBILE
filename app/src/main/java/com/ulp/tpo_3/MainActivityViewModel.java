package com.ulp.tpo_3;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

import android.app.Application;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.ulp.tpo_3.network.ApiService;
import com.ulp.tpo_3.network.RetrofitClient;
import com.ulp.tpo_3.modelo.OpenLibraryResponse;


import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityViewModel extends AndroidViewModel {
    private ApiService api = RetrofitClient.getApiService();
    private MutableLiveData<OpenLibraryResponse> opl = new MutableLiveData<>();
    public MainActivityViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<OpenLibraryResponse> getOpl() {
        return opl;
    }

    public void buscarLibro(String nombre, int page) {
        if(nombre != null && !nombre.isEmpty()) {
            api.buscarLibro(nombre, page).enqueue(new Callback<OpenLibraryResponse>() {
                @Override
                public void onResponse(Call<OpenLibraryResponse> call, Response<OpenLibraryResponse> response) {
                    if(response.isSuccessful()) {
                        if(response.body() != null) {
                            response.body().titleSearch = nombre;
                            opl.setValue(response.body());
                        }
                    }
                }

                @Override
                public void onFailure(Call<OpenLibraryResponse> call, Throwable t) {
                    Log.d("ERROR API BUSCARLIBRO", t.toString());
                }
            });
        }
    }

    public void cambiarPage(int accion) {
        if(opl.getValue() != null) {
            buscarLibro(opl.getValue().titleSearch, opl.getValue().getPageActual() + accion);
        }
    }
}
