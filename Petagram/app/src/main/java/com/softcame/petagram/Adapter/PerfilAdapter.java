package com.softcame.petagram.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.softcame.petagram.R;
import com.softcame.petagram.pojo.Perfil;

import java.util.ArrayList;

/**
 * Created by Edgar on 12/08/2016.
 */
public class PerfilAdapter extends RecyclerView.Adapter<PerfilAdapter.PerfilViewHolder>{
    ArrayList<Perfil> perfiles;

    public PerfilAdapter(ArrayList<Perfil> perfiles) {
        this.perfiles = perfiles;
    }

    @Override
    public PerfilViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_perfil,parent,false);
        return new PerfilViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PerfilViewHolder holder, int position) {
        final Perfil perfil = perfiles.get(position);
        holder.imgFotoAnimal.setImageResource(perfil.getFoto());
        holder.txtCVRaiting.setText(perfil.getRaiting());

    }

    @Override
    public int getItemCount() {
        return perfiles.size();
    }

    public static class PerfilViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgFotoAnimal;
        private TextView txtCVRaiting;

        public PerfilViewHolder(View itemView) {
            super(itemView);
            imgFotoAnimal = (ImageView) itemView.findViewById(R.id.imgpFotoanimal);
            txtCVRaiting = (TextView) itemView.findViewById(R.id.txtCvpraiting);
        }
    }
}
