package com.softnopal.myfinalpet.presenter;

import com.softnopal.myfinalpet.pojo.Pet;

import java.util.ArrayList;

/**
 * Created by jarodrig00 on 11/05/17.
 */

public interface IRecyclerViewPresenter {
    public void getPet();
    public void showPetRecyclerView();
    public ArrayList<Pet> getPets();
}
