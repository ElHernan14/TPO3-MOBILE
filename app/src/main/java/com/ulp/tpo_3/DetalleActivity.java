package com.ulp.tpo_3;

import android.os.Bundle;
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
        //Imagen URL pública externa carga con dependencia GLIDE.
        Glide.with(this)
                .load(libro.getUrlImg())
                .placeholder(R.drawable.loading)
                .error(R.drawable.ic_launcher_background)
                .override(360, 500)
                .centerCrop()
                .thumbnail(0.25f)
                .transition(DrawableTransitionOptions.withCrossFade(500))
                .into(binding.ivPortada);
        //Listado Categorías
        binding.llCategorias.removeAllViews();
        for (Categoria cat : libro.getCategorias()) {
            TextView tvCat = new TextView(this);
            tvCat.setText(cat.getNombre());
            tvCat.setPadding(8, 4, 8, 4);
            // Estilo simple para las categorías
            binding.llCategorias.addView(tvCat);
        }
    }
}