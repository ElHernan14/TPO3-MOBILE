package com.ulp.tpo_3;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.ulp.tpo_3.databinding.ActivitySegundaBinding;

public class SegundaActivity extends AppCompatActivity {
    private ActivitySegundaBinding binding;
    private SegundaActivityViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySegundaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        vm = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(SegundaActivityViewModel.class);

        vm.getLibros().observe(this, libros -> {
            binding.rvLista.setAdapter(new AdapterItemLibro(libros, getLayoutInflater()));
            binding.rvLista.setLayoutManager(new GridLayoutManager(SegundaActivity.this, 1, LinearLayoutManager.VERTICAL, false));
        });

        Intent intent = getIntent();
        vm.setLibros(intent);
    }
}