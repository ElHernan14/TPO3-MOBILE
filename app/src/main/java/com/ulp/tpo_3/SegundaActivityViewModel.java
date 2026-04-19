package com.ulp.tpo_3;

import android.app.Application;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.ulp.tpo_3.modelo.Libro;
import com.ulp.tpo_3.network.response.OpenLibraryResponse;

import java.util.ArrayList;
import java.util.List;

public class SegundaActivityViewModel extends AndroidViewModel {
    private MutableLiveData<ArrayList<Libro>> libros = new MutableLiveData<>();
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
}
