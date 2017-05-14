package com.softnopal.myfinalpet.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softnopal.myfinalpet.adpater.PetAdapter;
import com.softnopal.myfinalpet.myFavoritePet;
import com.softnopal.myfinalpet.pojo.Pet;
import com.softnopal.myfinalpet.presenter.IRecyclerViewPresenter;
import com.softnopal.myfinalpet.presenter.RecyclerViewPresenter;
import com.softnopal.myfinalpet.R;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by jarodrig00 on 07/05/17.
 */

public class RecyclerViewFragment extends Fragment implements IRecyclerViewFragmentView {

    //private ArrayList<Pet> pets;
    private RecyclerView rvPets;
    private IRecyclerViewPresenter presenter;

    private FloatingActionButton fabMyActionBar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);




        rvPets = (RecyclerView) v.findViewById(R.id.rvPets);
        presenter = new RecyclerViewPresenter(this, getContext());




        fabMyActionBar = (FloatingActionButton) getActivity().findViewById(R.id.fabMyActionBar);

        fabMyActionBar.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                ArrayList <Pet> listaPet = new ArrayList<>();
                ArrayList<Pet> pets = presenter.getPets();
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


        return v;
    }




    @Override
    public void generaLayoutVertical() {

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvPets.setLayoutManager(llm);
    }


    @Override
    public PetAdapter generaAdaptador(ArrayList<Pet> pets) {
        PetAdapter petAdapter = new PetAdapter(pets);
        return petAdapter;
    }


    @Override
    public void inicializaAdaptador(PetAdapter petAdapter) {
        rvPets.setAdapter(petAdapter);
    }
}
