package com.softcame.petagram.db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.softcame.petagram.pojo.Animales;

import java.util.ArrayList;

/**
 * Created by Edgar on 16/09/2016.
 */
public class BaseDatos extends SQLiteOpenHelper{

    private Context context;

    public BaseDatos(Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaAnimal = "CREATE TABLE "      + ConstantesBaseDatos.TABLE_NAME + "(" +
                ConstantesBaseDatos.TABLE_ANIMALES_ID       + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_ANIMALES_FOTO     + " INTEGER, " +
                ConstantesBaseDatos.TABLE_ANIMALES_NOMBRE   + " TEXT " +
                ")";

        String queryCreaTablaLikesAnimal = "CREATE TABLE "      + ConstantesBaseDatos.TABLE_LIKES_ANIMALES + "(" +
                ConstantesBaseDatos.TABLE_LIKES_ID              + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_LIKES_ANIMAL          + " INTEGER, " +
                ConstantesBaseDatos.TABLE_LIKES_NUMERO_LIKES    + " INTEGER, " +
                "FOREIGN KEY (" + ConstantesBaseDatos.TABLE_LIKES_ANIMAL + ") " +
                "REFERENCES " + ConstantesBaseDatos.TABLE_NAME + "(" + ConstantesBaseDatos.TABLE_ANIMALES_ID + ")" +
                ")";

        db.execSQL(queryCrearTablaAnimal);
        db.execSQL(queryCreaTablaLikesAnimal);
        Log.i ("Edgar",queryCreaTablaLikesAnimal);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXSIT " + ConstantesBaseDatos.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXSIT " + ConstantesBaseDatos.TABLE_LIKES_ANIMALES);
        onCreate(db);
    }

    public ArrayList<Animales> obtenerTodosLosAnimales(){
        ArrayList<Animales> animales = new ArrayList<>();
        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query,null);

        while (registros.moveToNext()){
            Animales animales1 = new Animales();
            animales1.setId(registros.getInt(0));
            animales1.setFoto(registros.getInt(1));
            animales1.setNombre(registros.getString(2));

            String queryLikes = "Select count(numero_likes) as likes from " + ConstantesBaseDatos.TABLE_LIKES_ANIMALES +
                    " where " + ConstantesBaseDatos.TABLE_LIKES_ANIMAL + " = " + animales1.getId();
            Cursor registrosLikes = db.rawQuery(queryLikes,null);
            if (registrosLikes.moveToNext()){
                animales1.setRaiting(registrosLikes.getInt(0));
            }else{
                animales1.setRaiting(0);
            }
            animales.add(animales1);

        }
        db.close();
        return animales;
    }

    public ArrayList<Animales> topcinco(){
        ArrayList<Animales> animales = new ArrayList<>();
        /*String querytop5 = "SELECT * FROM " + ConstantesBaseDatos.TABLE_NAME;*/
        String querytop5 = "Select a.*,sum(b.numero_likes) as likes " +
                " from Animales a, animales_likes b " +
                " where a.id = b.id_animales " +
                " group by a.id,a.foto,a.nombre" +
                " order by sum(b.numero_likes) desc Limit 5";
        Log.i("Edgar",querytop5);
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor top5 = db.rawQuery(querytop5,null);
        while (top5.moveToNext()) {
            Animales top5animales = new Animales();
            top5animales.setId(top5.getInt(0));
            top5animales.setFoto(top5.getInt(1));
            top5animales.setNombre(top5.getString(2));
            top5animales.setRaiting(top5.getInt(3));
            animales.add(top5animales);
        }
        db.close();
        return animales;
    }

    public void insertarAnimales(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_NAME,null,contentValues);
        db.close();

    }

    public void insertarLikes(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_LIKES_ANIMALES,null,contentValues);
        db.close();
    }

    public int obtenerLikesanimal(Animales animales){
        int likes = 0;
        String query = "Select count(numero_likes) as likes from " + ConstantesBaseDatos.TABLE_LIKES_ANIMALES +
                " where " + ConstantesBaseDatos.TABLE_LIKES_ANIMAL + " = " + animales.getId();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query,null);

        if (registros.moveToNext()){
          likes = registros.getInt(0);
        }
        db.close();
        return likes;
    }
}
