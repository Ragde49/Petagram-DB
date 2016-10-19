package com.softcame.petagram.pojo;

/**
 * Created by Edgar on 05/08/2016.
 */
public class Animales {


    private int id;
    private int foto;
    private String nombre;
    private int raiting;


    public Animales(int foto, String nombre, int raiting) {
        this.foto = foto;
        this.nombre = nombre;
        this.raiting = raiting;
    }

    public Animales() {

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

    public int getRaiting() {
        return raiting;
    }

    public void setRaiting(int raiting) {
        this.raiting = raiting;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
