package com.ulp.tpo_3;

import android.app.Application;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.ulp.tpo_3.modelo.OpenLibraryResponse;
import com.ulp.tpo_3.network.ApiService;
import com.ulp.tpo_3.network.RetrofitClient;
import com.ulp.tpo_3.modelo.WorkResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TerceraActivityViewModel extends AndroidViewModel {
    private ApiService api = RetrofitClient.getApiService();
    private MutableLiveData<OpenLibraryResponse.Doc> libro = new MutableLiveData<>();
    private MutableLiveData<WorkResponse> detallesLibro = new MutableLiveData<>();
    public TerceraActivityViewModel(@NonNull Application application) {
        super(application);
    }
    public LiveData<OpenLibraryResponse.Doc> getLibro() {
        return libro;
    }
    public MutableLiveData<WorkResponse> getDetallesLibro() {
        return detallesLibro;
    }
    public void recuperarLibro(Intent intent){
        OpenLibraryResponse.Doc libroRecuperado = (OpenLibraryResponse.Doc) intent.getSerializableExtra("libro");
        libro.setValue(libroRecuperado);

        api.obtenerDetallesLibro(libroRecuperado.getKey()).enqueue(new Callback<WorkResponse>() {
            @Override
            public void onResponse(Call<WorkResponse> call, Response<WorkResponse> response) {
                if(response.isSuccessful()) {
                    detallesLibro.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<WorkResponse> call, Throwable t) {
                Log.d("ERROR API OBTENERDETALLESLIBRO", t.toString());
            }
        });
    }
}
