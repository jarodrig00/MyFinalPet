package com.softnopal.myfinalpet;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.softnopal.myfinalpet.adpater.PageAdapter;
import com.softnopal.myfinalpet.adpater.PetAdapter;
import com.softnopal.myfinalpet.fragment.PetFragment;
import com.softnopal.myfinalpet.fragment.RecyclerViewFragment;
import com.softnopal.myfinalpet.pojo.Pet;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private Toolbar myToolBar;
    private TabLayout tabMain;
    private ViewPager vpPet;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent i;
        switch (item.getItemId()) {
            case R.id.mnuAcercaDe:
                //Toast.makeText(this, "Opcion acerca de", Toast.LENGTH_SHORT).show();
                i = new Intent(MainActivity.this, desarrollador.class);
                startActivity(i);
                return true;

            case R.id.mnuContactos:
                //Toast.makeText(this, "Opcion contactos", Toast.LENGTH_SHORT).show();
                i = new Intent(MainActivity.this, contactos.class);
                startActivity(i);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myToolBar = (Toolbar) findViewById(R.id.myActionBar);
        setSupportActionBar(myToolBar);
        //myToolBar.setTitle(getResources().getString(R.string.app_name));
        myToolBar.setTitleTextColor(Color.parseColor(getResources().getString(R.string.color_blanco)));
        myToolBar.inflateMenu(R.menu.menu_principal);

        tabMain = (TabLayout) findViewById(R.id.tabMain);
        vpPet = (ViewPager) findViewById(R.id.vpPet);

        setUpViewPager();



        /*

        actionBar.setNavigationIcon(R.drawable.huella_de_gato_48);
        actionBar.setTitleTextColor(Color.parseColor(getResources().getString(R.string.color_blanco)));
         */


        if(myToolBar != null)
            setSupportActionBar(myToolBar);

        agregarFragments();
    }

    public void setUpViewPager(){
        vpPet.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabMain.setupWithViewPager(vpPet);
        tabMain.getTabAt(0).setIcon(R.drawable.home_48);
        tabMain.getTabAt(1).setIcon(R.drawable.cat_48);
    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<Fragment>();
        fragments.add(new RecyclerViewFragment());
        fragments.add(new PetFragment());

        return  fragments;
    }


}
