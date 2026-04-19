package com.ulp.tpo_3;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.ulp.tpo_3.modelo.Libro;
import com.ulp.tpo_3.modelo.LibroData;

public class MainActivityViewModel extends AndroidViewModel {
    private final LibroData libroData = LibroData.getInstance();
    private final MutableLiveData<Libro> libroMutable = new MutableLiveData<>();
    private final MutableLiveData<String> mensajeToastMutable = new MutableLiveData<>("");
    public MainActivityViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Libro> getLibroMutable() {
        return libroMutable;
    }

    public LiveData<String> getMensajeToastMutable() {
        return mensajeToastMutable;
    }

    public void buscarLibro(String nombre) {
        Libro libro = libroData.buscarLibroPorNombre(nombre);
        if(libro != null){
            Log.d("Libro Encontrado: ", libro.getNombre());
            libroMutable.setValue(libro);
        }
        else{
            Log.d("Libro no encontrado", "NO EXISTE EL LIBRO");
            mensajeToastMutable.setValue("Libro no encontrado");
        }
    }
}
