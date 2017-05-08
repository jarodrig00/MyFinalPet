package com.softnopal.myfinalpet.adpater;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.softnopal.myfinalpet.pojo.Pet;
import com.softnopal.myfinalpet.R;

import java.util.ArrayList;

/**
 * Created by jarodrig00 on 29/04/17.
 */

public class PetAdapter extends RecyclerView.Adapter<PetAdapter.PetViewHolder> {

    ArrayList <Pet> pets;
    Activity activity;

    public PetAdapter(ArrayList<Pet> pets){
        this.pets = pets;
    }

    @Override
    public PetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.pet_view, parent, false);
        return new PetViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final PetViewHolder holder, final int position) {
        final Pet myPet = pets.get(position);
        holder.ivPet.setImageResource(myPet.getFoto());
        holder.tvName.setText(myPet.getNombre());
        holder.tvCountPet.setText(Integer.toString(myPet.getCuenta()));

        holder.ivInc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pets.get(position).incCount();
                holder.tvCountPet.setText(Integer.toString(pets.get(position).getCuenta()));
                Log.i("Incremento", Integer.toString(pets.get(position).getCuenta()));
            }
        });

        holder.ivDec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pets.get(position).decCount();
                holder.tvCountPet.setText(Integer.toString(pets.get(position).getCuenta()));
                Log.i("Decremento", Integer.toString(pets.get(position).getCuenta()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return pets.size();
    }

    public class PetViewHolder extends RecyclerView.ViewHolder{
        TextView tvName, tvCountPet;
        ImageView ivPet, ivInc, ivDec;



        public PetViewHolder(View itemView) {
            super(itemView);

            tvName = (TextView) itemView.findViewById(R.id.tvName);
            ivPet = (ImageView) itemView.findViewById(R.id.imPet);
            ivDec = (ImageView) itemView.findViewById(R.id.ivDec);
            ivInc = (ImageView) itemView.findViewById(R.id.ivInc);
            tvCountPet = (TextView) itemView.findViewById(R.id.tvCountPet);
        }
    }
}
