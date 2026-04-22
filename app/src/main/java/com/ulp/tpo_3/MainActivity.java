package com.ulp.tpo_3;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.ulp.tpo_3.databinding.ActivityMainBinding;
import com.ulp.tpo_3.modelo.OpenLibraryResponse;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private MainActivityViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding =ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(binding.main, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(
                    systemBars.left,
                    systemBars.top,
                    systemBars.right,
                    systemBars.bottom
            );
            return insets;
        });
        vm = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);

        binding.btnBuscar.setOnClickListener(v -> {
            vm.buscarLibro(binding.etBuscador.getText().toString(), 1);
            binding.btnBuscar.setEnabled(false);
            binding.btnBuscar.setText("Espere...");
            binding.btnAtras.setVisibility(View.INVISIBLE);
            binding.btnSiguiente.setVisibility(View.INVISIBLE);
            binding.tvPageActual.setVisibility(View.INVISIBLE);
            binding.tvCantResultado.setText("");
        });

        binding.btnSiguiente.setOnClickListener(v -> {
            vm.cambiarPage(1);
            binding.btnBuscar.setEnabled(false);
            binding.btnBuscar.setText("Espere...");
            binding.btnAtras.setEnabled(false);
            binding.btnSiguiente.setEnabled(false);
        });

        binding.btnAtras.setOnClickListener(v -> {
            vm.cambiarPage(-1);
            binding.btnBuscar.setEnabled(false);
            binding.btnBuscar.setText("Espere...");
            binding.btnAtras.setEnabled(false);
            binding.btnSiguiente.setEnabled(false);
        });

        vm.getOpl().observe(this,opl -> {
            binding.rvListaItem.setAdapter(new AdapterItemLibro(opl.docs, getLayoutInflater()));
            binding.rvListaItem.setLayoutManager(new GridLayoutManager(MainActivity.this, 1, LinearLayoutManager.VERTICAL, false));

            //btn buscar
            binding.btnBuscar.setEnabled(true);
            binding.btnBuscar.setText("Buscar");

            //cant de resultados y num de pages
            binding.tvCantResultado.setText("Resultados: " + opl.num_found);
            binding.tvPageActual.setVisibility(View.VISIBLE);
            binding.tvPageActual.setText(opl.getPageActual() + " / " + opl.getTotalPages());

            //pag btns
            controlPagination(opl);
        });
    }

    private void controlPagination(OpenLibraryResponse oplObj) {
        if(oplObj.getTotalPages() >= 1) {
            binding.btnAtras.setVisibility(View.VISIBLE);
            binding.btnSiguiente.setVisibility(View.VISIBLE);

            binding.btnAtras.setEnabled(oplObj.getPageActual() > 1);
            binding.btnSiguiente.setEnabled(oplObj.getPageActual() < oplObj.getTotalPages());
        } else {
            binding.btnAtras.setVisibility(View.INVISIBLE);
            binding.btnSiguiente.setVisibility(View.INVISIBLE);
        }
    }
}