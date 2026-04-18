package com.ulp.tpo_3.modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LibroData {

    private static final LibroData instace = new LibroData();

    private List<Libro> libros;

    private LibroData() {
        libros = new ArrayList<>();
        libros.add(new Libro("El hobbit", "J.R.R. Tolkien",300, 1937, Arrays.asList(Categoria.FANTASIA, Categoria.AVENTURA),"","El Hobbit, o ida y vuelta es una novela de fantasía para niños del autor inglés J. R. R. Tolkien. Fue publicado en 1937 con gran éxito de crítica, siendo nominado a la Medalla Carnegie y galardonado con un premio del New York Herald Tribune a la mejor ficción juvenil."));
        libros.add(new Libro("Harry Potter y la piedra filosofal", "J.K. Rowling",309, 1997, Arrays.asList(Categoria.FANTASIA, Categoria.AVENTURA),"","Harry Potter descubre en su undécimo cumpleaños que es un mago y que ha sido aceptado en el Colegio Hogwarts de Magia y Hechicería. Allí comienza una nueva vida llena de amistades, misterios y peligros, mientras intenta descubrir la verdad sobre su pasado y el destino que lo une a un oscuro enemigo."));
        libros.add(new Libro("Los juegos del hambre", "Suzanne Collins",374, 2008, Arrays.asList(Categoria.CIENCIAFICCION, Categoria.AVENTURA),"","En una sociedad distópica, Katniss Everdeen se ofrece como voluntaria para participar en los Juegos del Hambre, un evento televisado donde jóvenes deben luchar por sobrevivir. A medida que avanza la competencia, deberá usar su ingenio y habilidades para enfrentar desafíos mortales y desafiar el sistema que los oprime."));
    }

    public static LibroData getInstance() {
        return instace;
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    public Libro buscarLibroPorNombre(String nombre) {
        for (Libro libro : libros) {
            if(libro.getNombre().equalsIgnoreCase(nombre)){
                return libro;
            }
        }
        return null;
    }
}
