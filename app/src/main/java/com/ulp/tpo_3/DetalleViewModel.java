package com.ulp.tpo_3;

import android.app.Application;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.ulp.tpo_3.modelo.Libro;

public class DetalleViewModel extends AndroidViewModel {
    private MutableLiveData<Libro> libroMutable;

    public DetalleViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Libro> getLibroMutable() {
        if (libroMutable == null) {
            libroMutable = new MutableLiveData<>();
        }
        return libroMutable;
    }

    public void recuperarLibro(Intent intent) {
        Libro libro = (Libro) intent.getSerializableExtra("libro");
        if (libro != null) {
            libroMutable.setValue(libro);
        }
    }
}