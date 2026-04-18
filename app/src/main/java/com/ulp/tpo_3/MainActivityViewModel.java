package com.ulp.tpo_3;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.ulp.tpo_3.modelo.Libro;
import com.ulp.tpo_3.modelo.LibroData;

public class MainActivityViewModel extends AndroidViewModel {
    private final LibroData libroData = LibroData.getInstance();
    public MainActivityViewModel(@NonNull Application application) {
        super(application);
    }

    public void buscarLibro(String nombre) {
        Libro libro = libroData.buscarLibroPorNombre(nombre);
        if(libro != null) Log.d("RESULTADO", libro.getNombre());
        else Log.d("RESULTADO", "NO EXISTE EL LIBRO");

        //DESARROLLAR
    }
}
