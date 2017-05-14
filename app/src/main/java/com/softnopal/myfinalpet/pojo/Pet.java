package com.softnopal.myfinalpet.pojo;

import android.content.Context;
import android.support.annotation.NonNull;

import com.softnopal.myfinalpet.db.ConstructorPet;

/**
 * Created by jarodrig00 on 29/04/17.
 */

public class Pet implements Comparable  {

    int id;
    String nombre;
    int foto;
    int cuenta;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }




    public int getCuenta() {
        return cuenta;
    }


    public Pet(String nombre, int foto) {

        this.nombre = nombre;
        this.foto = foto;
        this.cuenta = 0;
    }

    public Pet(int id, String nombre, int foto, int cuenta){
        this.id = id;
        this.nombre = nombre;
        this.foto = foto;
        this.cuenta = cuenta;
    }

    public Pet(String nombre, int foto, int cuenta){
        this.nombre = nombre;
        this.foto = foto;
        this.cuenta = cuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public void incCount (){
        cuenta = cuenta + 1;
    }

    public void decCount(){
        if (cuenta > 0)
            cuenta = cuenta - 1;
    }


    @Override
    public int compareTo(@NonNull Object o) {
        int compareCuenta = ((Pet) o).getCuenta();

        return compareCuenta - this.getCuenta();
    }

    public void updateDB(Context context){
        ConstructorPet constructorPet = new ConstructorPet(context);
        constructorPet.updatePetDB(getId(), getCuenta());
    }
}
