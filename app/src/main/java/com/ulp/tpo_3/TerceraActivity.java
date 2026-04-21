package com.ulp.tpo_3;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.ulp.tpo_3.databinding.ActivityTerceraBinding;

public class TerceraActivity extends AppCompatActivity {

    private ActivityTerceraBinding binding;
    private TerceraActivityViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTerceraBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        vm = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(TerceraActivityViewModel.class);

        vm.getLibro().observe(this,libro -> {
            binding.tvTitle.setText(libro.title);
            binding.tvAnioPug.setText(libro.getStringFirstPublishYear());

            Glide.with(this)
                    .load("https://covers.openlibrary.org/b/title/" + libro.title + "-M.jpg")
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background)
                    .into(binding.ivImgLibro);
        });

        vm.getDetallesLibro().observe(this, detallesLibro -> {
            binding.tvSinopsis.setText(detallesLibro.getDescription());
        });

        Intent intent = getIntent();
        vm.recuperarLibro(intent);
    }
}