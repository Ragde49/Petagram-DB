package com.softcame.petagram.presentador;

import android.content.ContentValues;
import android.content.Context;

import com.softcame.petagram.Adapter.AnimalesAdaptador;
import com.softcame.petagram.Fragment.IHomeFgramentView;
import com.softcame.petagram.db.ConstructorAnimales;
import com.softcame.petagram.pojo.Animales;

import java.util.ArrayList;

/**
 * Created by Edgar on 16/09/2016.
 */
public class HomefragmentPresentador  implements IHomefragmentPresenter{
    private IHomeFgramentView iHomeFgramentView;
    private Context context;
    private  ConstructorAnimales constructorAnimales;
    private ArrayList<Animales> animales;

    public HomefragmentPresentador(IHomeFgramentView iHomeFgramentView, Context context) {
        this.iHomeFgramentView = iHomeFgramentView;
        this.context = context;
        obtenerAnimalesBaseDatos();
    }


    @Override
    public void obtenerAnimalesBaseDatos() {
        constructorAnimales = new ConstructorAnimales(context);
        animales = constructorAnimales.obtenerDatos();
        mostrarAnimalesRV();
    }

    @Override
    public void mostrarAnimalesRV() {
        iHomeFgramentView.inicializarAdaptadorRV(iHomeFgramentView.crearAdaptador(animales));
        iHomeFgramentView.generarLinearLayoutVertical();
    }
}
