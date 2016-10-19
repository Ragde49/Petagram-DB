package com.softcame.petagram;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;

import com.softcame.petagram.Adapter.AnimalesAdaptador;
import com.softcame.petagram.db.BaseDatos;
import com.softcame.petagram.pojo.Animales;

import java.util.ArrayList;

public class ascotas_favoritas extends AppCompatActivity {
    private RecyclerView ListaAnimales;
    ImageButton imbFav;
    ArrayList<Animales> animales;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ascotas_favoritas);

        ListaAnimales = (RecyclerView) findViewById(R.id.rvAnimales);
        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        imbFav = (ImageButton) findViewById(R.id.ibtFavs);
        imbFav.setVisibility(View.INVISIBLE);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        ListaAnimales.setLayoutManager(llm);

        inicializaListaAnimales();
        inicializaAdaptador();
    }

    public AnimalesAdaptador adaptador;

    public void inicializaAdaptador() {
        adaptador = new AnimalesAdaptador(animales, getParent());
        ListaAnimales.setAdapter(adaptador);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent(ascotas_favoritas.this, MainActivity.class);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }


    public void inicializaListaAnimales() {
        /*animales = new ArrayList<Animales>();
        animales.add(new Animales(R.drawable.india, "India", 10));
        animales.add(new Animales(R.drawable.perro2, "Perro 1", 6));
        animales.add(new Animales(R.drawable.perro, "Perro 2", 5));
        animales.add(new Animales(R.drawable.ferret, "Ferret", 4));
        animales.add(new Animales(R.drawable.ferrets, "Ferrets", 3));*/
        BaseDatos db = new BaseDatos(getBaseContext());
        animales = db.topcinco();

    }
}

