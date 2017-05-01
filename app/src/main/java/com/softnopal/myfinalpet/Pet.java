package com.softnopal.myfinalpet;

import android.support.annotation.NonNull;

import java.util.Comparator;

/**
 * Created by jarodrig00 on 29/04/17.
 */

public class Pet implements Comparable{

    String nombre;
    int foto;

    public int getCuenta() {
        return cuenta;
    }

    int cuenta;

    public Pet(String nombre, int foto) {

        this.nombre = nombre;
        this.foto = foto;
        this.cuenta = 0;
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
}
