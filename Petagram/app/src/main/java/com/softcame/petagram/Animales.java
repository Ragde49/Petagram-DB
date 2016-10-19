package com.softcame.petagram;

/**
 * Created by Edgar on 05/08/2016.
 */
public class Animales {
    private int foto;
    private String nombre;
    private String raiting;

    public Animales(int foto, String nombre, String raiting) {
        this.foto = foto;
        this.nombre = nombre;
        this.raiting = raiting;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaiting() {
        return raiting;
    }

    public void setRaiting(String raiting) {
        this.raiting = raiting;
    }


}
