package com.ulp.tpo_3.modelo;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.List;

public class Libro implements Parcelable {
    private String key;
    private String titulo;
    private List<String> autores;
    private int cantPag; // Cantidad de páginas
    private int anioPub; // Año de publicación
    private List<String> subjects;
    private String sinopsis;

    public Libro(String key, String titulo, List<String> autores, int cantPag, int anioPub, List<String> subjects, String sinopsis) {
        this.key = key;
        this.titulo = titulo;
        this.autores = autores;
        this.cantPag = cantPag;
        this.anioPub = anioPub;
        this.subjects = subjects;
        this.sinopsis = sinopsis;
    }

    public Libro(String key, String titulo, List<String> autores, int anioPub) {
        this.key = key;
        this.titulo = titulo;
        this.autores = autores;
        this.anioPub = anioPub;
    }

    public Libro() {}

    protected Libro(@NonNull Parcel in) {
        key = in.readString();
        titulo = in.readString();
        autores = in.createStringArrayList();
        cantPag = in.readInt();
        anioPub = in.readInt();
        subjects = in.createStringArrayList();
        sinopsis = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(key);
        dest.writeString(titulo);
        dest.writeStringList(autores);
        dest.writeInt(cantPag);
        dest.writeInt(anioPub);
        dest.writeStringList(subjects);
        dest.writeString(sinopsis);
    }

    public static final Creator<Libro> CREATOR = new Creator<Libro>() {
        @Override
        public Libro createFromParcel(Parcel in) {
            return new Libro(in);
        }

        @Override
        public Libro[] newArray(int size) {
            return new Libro[size];
        }
    };

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<String> getAutores() {
        return autores;
    }

    public void setAutores(List<String> autores) {
        this.autores = autores;
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

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }
}
