package com.ulp.tpo_3;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

import android.app.Application;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.ulp.tpo_3.modelo.Libro;
import com.ulp.tpo_3.network.ApiService;
import com.ulp.tpo_3.network.RetrofitClient;
import com.ulp.tpo_3.network.response.OpenLibraryResponse;
import com.ulp.tpo_3.network.response.WorkResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SegundaActivityViewModel extends AndroidViewModel {
    private MutableLiveData<ArrayList<Libro>> libros = new MutableLiveData<>();
    private ApiService api = RetrofitClient.getApiService();
    public SegundaActivityViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<ArrayList<Libro>> getLibros() {
        return libros;
    }

    public void setLibros(Intent intent) {
        ArrayList<Libro> librosExtraidos = intent.getParcelableArrayListExtra("libros");
        libros.setValue(librosExtraidos);
    }

    public void detallesLibro(Libro libroSeleccionado) {
        api.obtenerDetallesLibro(libroSeleccionado.getKey()).enqueue(new Callback<WorkResponse>() {
            @Override
            public void onResponse(Call<WorkResponse> call, Response<WorkResponse> response) {
                if(response.isSuccessful()) {
                    libroSeleccionado.setSubjects(response.body().getSubjects());
                    libroSeleccionado.setSinopsis(response.body().getDescription());

                    Intent i = new Intent(getApplication(), TerceraActivity.class);
                    i.setFlags(FLAG_ACTIVITY_NEW_TASK);
                    i.putExtra("libro", libroSeleccionado);
                    getApplication().startActivity(i);
                }
            }

            @Override
            public void onFailure(Call<WorkResponse> call, Throwable t) {
                // que hagoooo?
            }
        });
    }
}
