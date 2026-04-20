package com.ulp.tpo_3;

import android.app.Application;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.ulp.tpo_3.modelo.Libro;
import com.ulp.tpo_3.network.ApiService;
import com.ulp.tpo_3.network.RetrofitClient;
import com.ulp.tpo_3.network.response.WorkResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TerceraActivityViewModel extends AndroidViewModel {
    private ApiService api = RetrofitClient.getApiService();
    private MutableLiveData<Libro> libro = new MutableLiveData<>();
    public TerceraActivityViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Libro> getLibro() {
        return libro;
    }

    public void recuperarLibro(Intent intent){
        Libro libroRecuperado = intent.getParcelableExtra("libro");
        api.obtenerDetallesLibro(libroRecuperado.getKey()).enqueue(new Callback<WorkResponse>() {
            @Override
            public void onResponse(Call<WorkResponse> call, Response<WorkResponse> response) {
                if(response.isSuccessful()) {
                    libroRecuperado.setSubjects(response.body().getSubjects());
                    libroRecuperado.setSinopsis(response.body().getDescription());

                    libro.setValue(libroRecuperado);
                }
            }

            @Override
            public void onFailure(Call<WorkResponse> call, Throwable t) {
                //desa
            }
        });
    }
}
