package com.ulp.tpo_3.modelo;

public enum Categoria {
    FANTASIA("Fantasía"),
    AVENTURA("Aventura"),
    ROMANCE("Romance"),
    TERROR("Terror"),
    CIENCIAFICCION("Ciencia ficción");

    private String nombre;

    Categoria(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
