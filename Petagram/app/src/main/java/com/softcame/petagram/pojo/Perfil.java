package com.softcame.petagram.pojo;

/**
 * Created by Edgar on 12/08/2016.
 */
public class Perfil {
    private int foto;
    private String raiting;

    public Perfil(int foto, String raiting) {
        this.foto = foto;
        this.raiting = raiting;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getRaiting() {
        return raiting;
    }

    public void setRaiting(String raiting) {
        this.raiting = raiting;
    }
}
