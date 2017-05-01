package com.softnopal.myfinalpet;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

public class myFavoritePet extends AppCompatActivity {

    private ArrayList<Pet> favoritePets;
    private RecyclerView rvPetsF;
    private Toolbar myToolBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_favorite_pet);

        Bundle parametros = getIntent().getExtras();
        if (parametros != null) {
            favoritePets = new ArrayList<Pet>();
            ArrayList<String> name = (ArrayList<String>) getIntent().getSerializableExtra(getResources().getString(R.string.lstName));
            ArrayList<Integer> count = (ArrayList<Integer>) getIntent().getSerializableExtra(getResources().getString(R.string.lstCount));
            ArrayList<Integer> photo = (ArrayList<Integer>) getIntent().getSerializableExtra(getResources().getString(R.string.lstPhoto));

            for (int i = 0; i < name.size(); i++){
                favoritePets.add(new Pet(name.get(i), photo.get(i), count.get(i)));
            }

        }
        myToolBar = (Toolbar) findViewById(R.id.myActionBar);
        setSupportActionBar(myToolBar);
        myToolBar.setTitle(getResources().getString(R.string.app_name));
        myToolBar.setTitleTextColor(Color.parseColor(getResources().getString(R.string.color_blanco)));
        myToolBar.setTitleTextColor(Color.parseColor(getResources().getString(R.string.color_blanco)));
        //myToolBar.setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        rvPetsF = (RecyclerView) findViewById(R.id.rvPetsF);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvPetsF.setLayoutManager(llm);

        startUpAdapter();
    }

    public void startUpAdapter(){
        PetAdapter petAdapter = new PetAdapter(favoritePets);
        rvPetsF.setAdapter(petAdapter);
    }
}
