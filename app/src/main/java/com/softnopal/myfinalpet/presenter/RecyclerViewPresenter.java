package com.softnopal.myfinalpet.presenter;

import android.content.Context;

import com.softnopal.myfinalpet.db.ConstructorPet;
import com.softnopal.myfinalpet.fragment.IRecyclerViewFragmentView;
import com.softnopal.myfinalpet.pojo.Pet;

import java.util.ArrayList;

/**
 * Created by jarodrig00 on 11/05/17.
 */

public class RecyclerViewPresenter implements IRecyclerViewPresenter {
    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private  Context context;
    private ConstructorPet constructorPet;
    private ArrayList<Pet> pets;

    public RecyclerViewPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context) {
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        getPet();
    }

    @Override
    public void getPet() {
        constructorPet = new ConstructorPet(context);
        pets = constructorPet.getData();
        showPetRecyclerView();
    }

    @Override
    public void showPetRecyclerView() {
        iRecyclerViewFragmentView.inicializaAdaptador(iRecyclerViewFragmentView.generaAdaptador(pets));
        iRecyclerViewFragmentView.generaLayoutVertical();
    }

    public ArrayList<Pet> getPets(){
        return pets;
    }


}
