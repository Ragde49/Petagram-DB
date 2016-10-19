package com.softcame.petagram.Fragment;

import com.softcame.petagram.Adapter.AnimalesAdaptador;
import com.softcame.petagram.pojo.Animales;

import java.util.ArrayList;

/**
 * Created by Edgar on 16/09/2016.
 */
public interface IHomeFgramentView {

    public void generarLinearLayoutVertical();

    public AnimalesAdaptador crearAdaptador(ArrayList<Animales> animales);

    public void inicializarAdaptadorRV(AnimalesAdaptador adaptador);


}
