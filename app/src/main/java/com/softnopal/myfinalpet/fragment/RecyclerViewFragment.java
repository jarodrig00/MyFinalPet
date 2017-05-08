package com.softnopal.myfinalpet.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softnopal.myfinalpet.MainActivity;
import com.softnopal.myfinalpet.R;
import com.softnopal.myfinalpet.adpater.PageAdapter;
import com.softnopal.myfinalpet.adpater.PetAdapter;
import com.softnopal.myfinalpet.myFavoritePet;
import com.softnopal.myfinalpet.pojo.Pet;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by jarodrig00 on 07/05/17.
 */

public class RecyclerViewFragment extends Fragment {

    private ArrayList<Pet> pets;
    private RecyclerView rvPets;
    private FloatingActionButton fabMyActionBar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);



        rvPets = (RecyclerView) v.findViewById(R.id.rvPets);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvPets.setLayoutManager(llm);

        startUpPet();
        startUpAdapter();


        fabMyActionBar = (FloatingActionButton) v.findViewById(R.id.fabMyActionBar);
        /*
        fabMyActionBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList <Pet> listaPet = new ArrayList<Pet>();
                for(Pet p : pets){
                    listaPet.add(p);
                }

                Collections.sort(listaPet);
                int max = 4;
                if (listaPet.size() < max)
                    max = listaPet.size();

                ArrayList<String> name = new ArrayList<String>();
                ArrayList<Integer> count = new ArrayList<Integer>();
                ArrayList<Integer> foto = new ArrayList<Integer>();
                int j = 0;
                for (Pet p : listaPet){
                    name.add(p.getNombre());
                    count.add(p.getCuenta());
                    foto.add(p.getFoto());
                    j = j + 1;
                    if (j > max)
                        break;
                }
                //Toast.makeText(MainActivity.this, "Clic en Fav " + listaPet.get(0).getNombre(), Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getActivity(), myFavoritePet.class);
                //Prueba para mandar un list de objetos
                i.putExtra(getResources().getString(R.string.lstName), name);
                i.putExtra(getResources().getString(R.string.lstCount), count);
                i.putExtra(getResources().getString(R.string.lstPhoto), foto);

                //Se pueden enviar arreglos de datos primitivos
                getActivity().startActivity(i);
                //finish();


                listaPet.clear();

            }
        });
        */

        return v;
    }



    public void startUpPet (){
        pets = new ArrayList<Pet>();
        pets.add(new Pet("Buho", R.drawable.buho));
        pets.add(new Pet("Cerdo", R.drawable.cerdo));
        pets.add(new Pet("Gato", R.drawable.gato));
        pets.add(new Pet("Gatito", R.drawable.gato2));
        pets.add(new Pet("Gusano", R.drawable.gusano));
        pets.add(new Pet("Pato", R.drawable.pato));
        pets.add(new Pet("Perro", R.drawable.perro));
        pets.add(new Pet("Piolin", R.drawable.piolin));
        pets.add(new Pet("Pulpo", R.drawable.pulpo));

    }

    public void startUpAdapter(){
        PetAdapter petAdapter = new PetAdapter(pets);
        rvPets.setAdapter(petAdapter);
    }
}
