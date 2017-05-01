package com.softnopal.myfinalpet;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Pet> pets;
    private RecyclerView rvPets;
    private Toolbar myToolBar;
    private FloatingActionButton fabMyActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myToolBar = (Toolbar) findViewById(R.id.myActionBar);
        setSupportActionBar(myToolBar);
        myToolBar.setTitle(getResources().getString(R.string.app_name));
        myToolBar.setTitleTextColor(Color.parseColor(getResources().getString(R.string.color_blanco)));

        fabMyActionBar = (FloatingActionButton) findViewById(R.id.fabMyActionBar);
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
                Toast.makeText(MainActivity.this, "Clic en Fav " + listaPet.get(0).getNombre(), Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MainActivity.this, myFavoritePet.class);
                //Prueba para mandar un list de objetos
                i.putExtra(getResources().getString(R.string.lstName), name);
                i.putExtra(getResources().getString(R.string.lstCount), count);
                i.putExtra(getResources().getString(R.string.lstPhoto), foto);

                //Se pueden enviar arreglos de datos primitivos
                startActivity(i);
                //finish();


                listaPet.clear();
                listaPet = null;
            }
        });

        /*

        actionBar.setNavigationIcon(R.drawable.huella_de_gato_48);
        actionBar.setTitleTextColor(Color.parseColor(getResources().getString(R.string.color_blanco)));
         */

        rvPets = (RecyclerView) findViewById(R.id.rvPets);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvPets.setLayoutManager(llm);

        startUpPet();
        startUpAdapter();
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
