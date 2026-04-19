package com.ulp.tpo_3;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.ulp.tpo_3.databinding.ActivityDetalleBinding;
import com.ulp.tpo_3.modelo.Categoria;
import com.ulp.tpo_3.modelo.Libro;

public class DetalleActivity extends AppCompatActivity {
    private ActivityDetalleBinding binding;
    private DetalleViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetalleBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        vm = new ViewModelProvider(this).get(DetalleViewModel.class);

        vm.getLibroMutable().observe(this, this::cargarLibro);

        vm.recuperarLibro(getIntent());

        binding.btnVolver.setOnClickListener(v -> finish());
    }

    private void cargarLibro(Libro libro){
        binding.tvTitulo.setText(libro.getNombre());
        binding.tvAutor.setText(libro.getAutor());
        binding.tvPaginas.setText(libro.getCantPag() + " pág");
        binding.tvAnio.setText(String.valueOf(libro.getAnioPub()));
        binding.tvSinopsis.setText(libro.getSinopsis());
        
        Glide.with(this)
                .load(libro.getUrlImg())
                .placeholder(R.drawable.loading)
                .error(R.drawable.ic_launcher_background)
                .override(360, 500)
                .centerCrop()
                .thumbnail(0.25f)
                .transition(DrawableTransitionOptions.withCrossFade(500))
                .into(binding.ivPortada);

        binding.llCategorias.removeAllViews();
        for (Categoria cat : libro.getCategorias()) {
            TextView tvCat = new TextView(this);
            tvCat.setText(cat.getNombre());
            tvCat.setBackgroundResource(R.drawable.bg_categoria);
            tvCat.setTextColor(Color.parseColor("#1565C0")); // Azul oscuro para el texto
            tvCat.setTextSize(14);
            
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
            );
            params.setMargins(0, 0, 16, 0);
            tvCat.setLayoutParams(params);

            binding.llCategorias.addView(tvCat);
        }
    }
}