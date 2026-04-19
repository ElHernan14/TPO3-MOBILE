package com.ulp.tpo_3.modelo;

public enum Categoria {
    FANTASIA("Fantasía"),
    AVENTURA("Aventura"),
    ROMANCE("Romance"),
    TERROR("Terror"),
    CIENCIAFICCION("Ciencia ficción"),
    MISTERIO("Misterio"),
    DRAMA("Drama"),
    CLASICO("Clásico"),
    THRILLER("Thriller");

    private String nombre;

    Categoria(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
