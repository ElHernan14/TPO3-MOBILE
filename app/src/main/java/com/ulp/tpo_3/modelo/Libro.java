package com.ulp.tpo_3.modelo;

import java.io.Serializable;
import java.util.List;

public class Libro implements Serializable {

    private String nombre;
    private String autor;
    private int cantPag; // Cantidad de páginas
    private int anioPub; // Año de publicación
    private List<Categoria> categorias;
    private String urlImg;
    private String Sinopsis;

    public Libro(String nombre, String autor, int cantPag, int anioPub, List<Categoria> categorias, String urlImg, String sinopsis) {
        this.nombre = nombre;
        this.autor = autor;
        this.cantPag = cantPag;
        this.anioPub = anioPub;
        this.categorias = categorias;
        this.urlImg = urlImg;
        Sinopsis = sinopsis;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getCantPag() {
        return cantPag;
    }

    public void setCantPag(int cantPag) {
        this.cantPag = cantPag;
    }

    public int getAnioPub() {
        return anioPub;
    }

    public void setAnioPub(int anioPub) {
        this.anioPub = anioPub;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    public String getSinopsis() {
        return Sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        Sinopsis = sinopsis;
    }
}
