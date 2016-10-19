package com.softcame.petagram;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Edgar on 05/08/2016.
 */
public class AnimalesAdaptador extends  RecyclerView.Adapter<AnimalesAdaptador.AnimalViewHolder> {
    ArrayList<Animales> animales;

    public AnimalesAdaptador(ArrayList<Animales> animales) {
        this.animales = animales;
    }

    @Override
    public AnimalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_animales,parent,false);
        return new AnimalViewHolder(v);
    }

    @Override
    public void onBindViewHolder(AnimalViewHolder holder, int position) {
        final Animales animal = animales.get(position);
        holder.imgFotoAnimal.setImageResource(animal.getFoto());
        holder.txtCVRaiting.setText(animal.getRaiting());
        holder.txtCVNombre.setText(animal.getNombre());
    }

    @Override
    public int getItemCount() {
        return animales.size();
    }

    public static class AnimalViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgFotoAnimal;
        private TextView txtCVNombre;
        private TextView txtCVRaiting;

        public AnimalViewHolder(View itemView) {
            super(itemView);
            imgFotoAnimal = (ImageView) itemView.findViewById(R.id.imgFotoanimal);
            txtCVNombre = (TextView) itemView.findViewById(R.id.txtCvNombre);
            txtCVRaiting = (TextView) itemView.findViewById(R.id.txtCvraiting);
        }
    }

}
