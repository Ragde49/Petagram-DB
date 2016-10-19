package com.softcame.petagram.db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;

import com.softcame.petagram.R;
import com.softcame.petagram.pojo.Animales;

import java.util.ArrayList;

/**
 * Created by Edgar on 16/09/2016.
 */
public class ConstructorAnimales {

    private static final int LIKE = 1;
    private Context context;
    public ConstructorAnimales(Context context) {
        this.context = context;
    }

    public ArrayList<Animales> obtenerDatos(){
        /*ArrayList<Animales> animales = new ArrayList<>();
        animales.add(new Animales(R.drawable.conejo,"Conejo",3));
        animales.add(new Animales(R.drawable.perro2,"Perro 1",4));
        animales.add(new Animales(R.drawable.perro,"Perro 2",5));
        animales.add(new Animales(R.drawable.ferret,"Ferret",6));
        animales.add(new Animales(R.drawable.ferrets,"Ferrets",7));
        animales.add(new Animales(R.drawable.gato,"Gato",8));
        animales.add(new Animales(R.drawable.india,"India",3));
        return animales;*/
        BaseDatos db = new BaseDatos(context);
        insertarAnimales(db);
        return db.obtenerTodosLosAnimales();
    }

    public void insertarAnimales(BaseDatos db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_ANIMALES_NOMBRE,"Conejo");
        contentValues.put(ConstantesBaseDatos.TABLE_ANIMALES_FOTO,R.drawable.conejo);

        db.insertarAnimales(contentValues);
        contentValues.put(ConstantesBaseDatos.TABLE_ANIMALES_NOMBRE,"India");
        contentValues.put(ConstantesBaseDatos.TABLE_ANIMALES_FOTO,R.drawable.india);

        db.insertarAnimales(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_ANIMALES_NOMBRE,"Ferrets");
        contentValues.put(ConstantesBaseDatos.TABLE_ANIMALES_FOTO,R.drawable.ferrets);

        db.insertarAnimales(contentValues);
    }

    public void insertarLikeanimal(Animales animales){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_ANIMAL, animales.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_NUMERO_LIKES, LIKE);
        db.insertarLikes(contentValues);
    }

    public int optenerlikesanimal(Animales animales){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesanimal(animales);
    }
}
