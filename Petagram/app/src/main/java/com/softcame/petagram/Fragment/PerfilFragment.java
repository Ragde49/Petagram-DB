package com.softcame.petagram.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softcame.petagram.Adapter.PerfilAdapter;
import com.softcame.petagram.R;
import com.softcame.petagram.pojo.Perfil;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment {
    private RecyclerView listaperfiles;
    ArrayList<Perfil> perfiles;

    @Override
    public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);

        listaperfiles = (RecyclerView) v.findViewById(R.id.rvPerfil);

        GridLayoutManager glmp = new GridLayoutManager(getContext(),2);


        listaperfiles.setHasFixedSize(true);
        listaperfiles.setLayoutManager(glmp);
        inicializaListaperfil();
        inicializaAdaptador();
        return v;
    }

    public PerfilAdapter perfilAdapter;
    public void inicializaAdaptador(){
        perfilAdapter = new PerfilAdapter(perfiles);
        listaperfiles.setAdapter(perfilAdapter);
    }

    public void inicializaListaperfil(){
        perfiles = new ArrayList<Perfil>();

        perfiles.add(new Perfil(R.drawable.india,"3"));
        perfiles.add(new Perfil(R.drawable.india,"4"));
        perfiles.add(new Perfil(R.drawable.india,"5"));
        perfiles.add(new Perfil(R.drawable.india,"6"));
        perfiles.add(new Perfil(R.drawable.india,"7"));
        perfiles.add(new Perfil(R.drawable.india,"8"));
        perfiles.add(new Perfil(R.drawable.india,"3"));
        perfiles.add(new Perfil(R.drawable.india,"2"));
    }
}
