package com.softcame.petagram.Adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.softcame.petagram.MainActivity;
import com.softcame.petagram.db.ConstructorAnimales;
import com.softcame.petagram.pojo.Animales;
import com.softcame.petagram.R;

import java.util.ArrayList;

/**
 * Created by Edgar on 05/08/2016.
 */
public class AnimalesAdaptador extends  RecyclerView.Adapter<AnimalesAdaptador.AnimalViewHolder> {
    ArrayList<Animales> animales;
    Activity activity;

    public AnimalesAdaptador(ArrayList<Animales> animales,Activity activity) {
        this.animales = animales;
        this.activity = activity;
    }

    @Override
    public AnimalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_animales,parent,false);
        return new AnimalViewHolder(v);
    }



    public void onBindViewHolder(final AnimalViewHolder holder, int position) {
        final Animales animal = animales.get(position);
        holder.imgFotoAnimal.setImageResource(animal.getFoto());
        holder.txtCVRaiting.setText(String.valueOf(animal.getRaiting()));
        holder.txtCVNombre.setText(animal.getNombre());

        holder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, "Diste Like a " + animal.getNombre(),
                        Toast.LENGTH_SHORT).show();

                ConstructorAnimales constructorAnimales = new ConstructorAnimales(activity);
                constructorAnimales.insertarLikeanimal(animal);

                holder.txtCVRaiting.setText(String.valueOf(constructorAnimales.optenerlikesanimal(animal)));

            }
        });
    }



    @Override
    public int getItemCount() {

        return animales.size();
    }

    public static class AnimalViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgFotoAnimal;
        private TextView txtCVNombre;
        private TextView txtCVRaiting;
        private ImageButton btnLike;

        public AnimalViewHolder(View itemView) {
            super(itemView);
            imgFotoAnimal = (ImageView) itemView.findViewById(R.id.imgFotoanimal);
            txtCVNombre = (TextView) itemView.findViewById(R.id.txtCvNombre);
            txtCVRaiting = (TextView) itemView.findViewById(R.id.txtCvraiting);
            btnLike = (ImageButton) itemView.findViewById(R.id.btnLike);
        }
    }

}
