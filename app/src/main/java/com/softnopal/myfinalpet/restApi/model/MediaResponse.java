package com.softnopal.myfinalpet.restApi.model;

import com.softnopal.myfinalpet.pojo.Pet;

import java.util.ArrayList;

/**
 * Created by jarodrig00 on 31/05/17.
 */

public class MediaResponse {
    private ArrayList<Pet> pets;

    public ArrayList<Pet> getPets(){
        return pets;
    }

    public void setPets(ArrayList<Pet> pets){
        this.pets = pets;
    }
}
