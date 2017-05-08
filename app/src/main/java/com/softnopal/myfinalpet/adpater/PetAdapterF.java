package com.softnopal.myfinalpet.adpater;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.softnopal.myfinalpet.pojo.Pet;
import com.softnopal.myfinalpet.R;

import java.util.ArrayList;

/**
 * Created by jarodrig00 on 30/04/17.
 */

public class PetAdapterF extends RecyclerView.Adapter<PetAdapterF.PetViewHolderF> {
    ArrayList<Pet> favoritePet;

    public PetAdapterF(ArrayList<Pet> favoritePet){
        this.favoritePet = favoritePet;
    }

    @Override
    public PetViewHolderF onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.favorite_pet,parent,false);
        return new PetViewHolderF(v);
    }

    @Override
    public void onBindViewHolder(PetViewHolderF holder, int position) {
        final Pet myPetF = favoritePet.get(position);
        holder.imPetF.setImageResource(myPetF.getFoto());
        holder.tvCountPetF.setText(Integer.toString(myPetF.getCuenta()));
        holder.tvNameF.setText(myPetF.getNombre());
    }

    @Override
    public int getItemCount() {
        return favoritePet.size();
    }

    public class PetViewHolderF extends RecyclerView.ViewHolder{
        ImageView imPetF;
        TextView tvNameF;
        TextView tvCountPetF;

        public PetViewHolderF(View itemView) {
            super(itemView);
            imPetF = (ImageView) itemView.findViewById(R.id.imPetF);
            tvNameF = (TextView) itemView.findViewById(R.id.tvNameF);
            tvCountPetF = (TextView) itemView.findViewById(R.id.tvCountPetF);
        }
    }
}
