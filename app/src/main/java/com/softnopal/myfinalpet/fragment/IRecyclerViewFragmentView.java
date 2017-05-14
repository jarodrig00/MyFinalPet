package com.softnopal.myfinalpet.fragment;

import com.softnopal.myfinalpet.adpater.PetAdapter;
import com.softnopal.myfinalpet.pojo.Pet;

import java.util.ArrayList;

/**
 * Created by jarodrig00 on 11/05/17.
 */

public interface IRecyclerViewFragmentView {
    public void generaLayoutVertical();

    public PetAdapter generaAdaptador(ArrayList<Pet> pets);

    public void inicializaAdaptador(PetAdapter petAdapter);

}
