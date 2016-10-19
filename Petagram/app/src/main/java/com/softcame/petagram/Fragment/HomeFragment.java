package com.softcame.petagram.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softcame.petagram.Adapter.AnimalesAdaptador;
import  com.softcame.petagram.R;
import com.softcame.petagram.pojo.Animales;
import com.softcame.petagram.presentador.HomefragmentPresentador;
import com.softcame.petagram.presentador.IHomefragmentPresenter;

import java.util.ArrayList;


public class HomeFragment extends Fragment implements IHomeFgramentView {
    private RecyclerView ListaAnimales;
    ArrayList<Animales> animales;
    private IHomefragmentPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        ListaAnimales = (RecyclerView) v.findViewById(R.id.rvAnimales);
        presenter = new HomefragmentPresentador(this, getContext());
        return v;
    }



    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        ListaAnimales.setLayoutManager(llm);
    }

    @Override
    public AnimalesAdaptador crearAdaptador(ArrayList<Animales> animales) {
        AnimalesAdaptador adaptador = new AnimalesAdaptador(animales,getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(AnimalesAdaptador adaptador) {
        ListaAnimales.setAdapter(adaptador);
    }
}
