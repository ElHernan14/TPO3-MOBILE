package com.ulp.tpo_3.network.mapper;

import com.ulp.tpo_3.modelo.Libro;
import com.ulp.tpo_3.network.response.OpenLibraryResponse;

import java.util.List;

public class LibroMapper {

    public static Libro fromDoc(OpenLibraryResponse.Doc doc) {

        String key = doc.key;

        String titulo = doc.title;

        List<String> autores = doc.author_name;

        int anio = doc.first_publish_year;


        return new Libro(key, titulo, autores, anio);
    }
}
