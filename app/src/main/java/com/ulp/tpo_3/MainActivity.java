package com.ulp.tpo_3;

import static com.ulp.tpo_3.utils.Constantes.EXTRA_LIBRO;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.ulp.tpo_3.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private MainActivityViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        vm = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);
        vm.getMensajeToastMutable().observe(this, mensaje -> {
            Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
        });
        vm.getLibroMutable().observe(this, libro -> {
            Intent intent = new Intent(MainActivity.this, DetalleActivity.class);
            intent.putExtra(EXTRA_LIBRO, libro);
            startActivity(intent);
        });
        binding.btnBuscar.setOnClickListener(v -> {
            vm.buscarLibro(binding.etBuscador.getText().toString());
        });
    }
}