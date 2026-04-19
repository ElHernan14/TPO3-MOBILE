package com.ulp.tpo_3.modelo;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LibroData {

    private static final LibroData instace = new LibroData();

    private List<Libro> libros;

    private LibroData() {
        cargarLibros();
    }

    public static LibroData getInstance() {
        return instace;
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    public Libro buscarLibroPorNombre(String nombre) {
        for (Libro libro : libros) {
            if (limpiar(libro.getNombre()).contains(limpiar(nombre))){
                return libro;
            }
        }
        return null;
    }

    public String limpiar(String texto) {
        //Limpio tildes, espacios y mayusculas
        texto = texto.toLowerCase().replace(" ", "");
        return Normalizer.normalize(texto, Normalizer.Form.NFD)
                .replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
    }

    private void cargarLibros() {
        libros = new ArrayList<>();
        libros.add(new Libro(
                "El hobbit",
                "J.R.R. Tolkien",
                300,
                1937,
                Arrays.asList(Categoria.FANTASIA, Categoria.AVENTURA),
                "https://covers.openlibrary.org/b/title/The Hobbit-M.jpg",
                "El Hobbit, o ida y vuelta es una novela de fantasía para niños del autor inglés J. R. R. Tolkien. Fue publicado en 1937 con gran éxito de crítica, siendo nominado a la Medalla Carnegie y galardonado con un premio del New York Herald Tribune a la mejor ficción juvenil."
        ));
        libros.add(new Libro(
                "Harry Potter y la piedra filosofal",
                "J.K. Rowling",
                309,
                1997,
                Arrays.asList(Categoria.FANTASIA, Categoria.AVENTURA),
                "https://covers.openlibrary.org/b/title/Harry Potter and the Sorcerer's Stone-M.jpg",
                "Harry Potter descubre en su undécimo cumpleaños que es un mago y que ha sido aceptado en el Colegio Hogwarts de Magia y Hechicería. Allí comienza una nueva vida llena de amistades, misterios y peligros, mientras intenta descubrir la verdad sobre su pasado y el destino que lo une a un oscuro enemigo."
        ));
        libros.add(new Libro(
                "Los juegos del hambre",
                "Suzanne Collins",
                374,
                2008,
                Arrays.asList(Categoria.CIENCIAFICCION, Categoria.AVENTURA),
                "https://covers.openlibrary.org/b/title/The Hunger Games-M.jpg",
                "En una sociedad distópica, Katniss Everdeen se ofrece como voluntaria para participar en los Juegos del Hambre, un evento televisado donde jóvenes deben luchar por sobrevivir. A medida que avanza la competencia, deberá usar su ingenio y habilidades para enfrentar desafíos mortales y desafiar el sistema que los oprime."
        ));
        libros.add(new Libro(
                "El señor de los anillos",
                "J.R.R. Tolkien",
                1178,
                1954,
                Arrays.asList(Categoria.FANTASIA, Categoria.AVENTURA),
                "https://covers.openlibrary.org/b/title/The Lord of the Rings-M.jpg",
                "Una épica historia en la Tierra Media donde Frodo Bolsón debe destruir un anillo poderoso para evitar que caiga en manos del mal."
        ));
        libros.add(new Libro(
                "1984",
                "George Orwell",
                328,
                1949,
                Arrays.asList(Categoria.CIENCIAFICCION, Categoria.FANTASIA),
                "https://covers.openlibrary.org/b/title/1984-M.jpg",
                "En un futuro totalitario, el Gran Hermano vigila cada aspecto de la vida. Winston Smith intenta rebelarse contra el sistema."
        ));
        libros.add(new Libro(
                "Fahrenheit 451",
                "Ray Bradbury",
                256,
                1953,
                Arrays.asList(Categoria.CIENCIAFICCION, Categoria.FANTASIA),
                "https://covers.openlibrary.org/b/title/Fahrenheit 451-M.jpg",
                "En una sociedad donde los libros están prohibidos, los bomberos se encargan de quemarlos. Guy Montag comienza a cuestionar su realidad."
        ));
        libros.add(new Libro(
                "El código Da Vinci",
                "Dan Brown",
                689,
                2003,
                Arrays.asList(Categoria.MISTERIO, Categoria.THRILLER),
                "https://covers.openlibrary.org/b/title/The Da Vinci Code-M.jpg",
                "Un profesor de simbología investiga un asesinato en el Louvre, descubriendo una conspiración que involucra secretos históricos."
        ));
        libros.add(new Libro(
                "Crónica de una muerte anunciada",
                "Gabriel García Márquez",
                120,
                1981,
                Arrays.asList(Categoria.DRAMA, Categoria.MISTERIO),
                "https://covers.openlibrary.org/b/title/Chronicle of a Death Foretold-M.jpg",
                "La historia de un asesinato anunciado que todo el pueblo conoce pero nadie logra evitar."
        ));
        libros.add(new Libro(
                "Cien años de soledad",
                "Gabriel García Márquez",
                417,
                1967,
                Arrays.asList(Categoria.FANTASIA, Categoria.DRAMA),
                "https://covers.openlibrary.org/b/title/One Hundred Years of Solitude-M.jpg",
                "La historia de la familia Buendía a lo largo de generaciones en el pueblo ficticio de Macondo."
        ));
        libros.add(new Libro(
                "Don Quijote de la Mancha",
                "Miguel de Cervantes",
                863,
                1605,
                Arrays.asList(Categoria.CLASICO, Categoria.AVENTURA),
                "https://covers.openlibrary.org/b/title/Don Quixote-M.jpg",
                "Un hidalgo enloquece leyendo libros de caballería y decide convertirse en caballero andante."
        ));
        libros.add(new Libro(
                "Orgullo y prejuicio",
                "Jane Austen",
                279,
                1813,
                Arrays.asList(Categoria.ROMANCE, Categoria.DRAMA),
                "https://covers.openlibrary.org/b/title/Pride and Prejudice-M.jpg",
                "La relación entre Elizabeth Bennet y el señor Darcy se desarrolla entre prejuicios, orgullo y diferencias sociales."
        ));
    }
}
