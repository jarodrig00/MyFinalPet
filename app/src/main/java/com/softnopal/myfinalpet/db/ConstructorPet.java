package com.softnopal.myfinalpet.db;

import android.content.ContentValues;
import android.content.Context;

import com.softnopal.myfinalpet.pojo.Pet;
import com.softnopal.myfinalpet.R;

import java.util.ArrayList;

/**
 * Created by jarodrig00 on 11/05/17.
 */

public class ConstructorPet {
    private Context context;
    public ConstructorPet(Context context) {
        this.context = context;
    }

    public ArrayList<Pet> getData(){
        DataBase db = new DataBase(context);
        insertPetDB(db);
        return  db.getAllPets();
    }

    public void insertPetDB(DataBase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantDB.TABLEPET_CNAME, "Buho");
        contentValues.put(ConstantDB.TABLEPET_CPHOTO, R.drawable.buho);
        contentValues.put(ConstantDB.TABLEPET_CCOUNT, 0);
        db.insertPet(contentValues);

        contentValues.put(ConstantDB.TABLEPET_CNAME, "Cerdo");
        contentValues.put(ConstantDB.TABLEPET_CPHOTO, R.drawable.cerdo);
        contentValues.put(ConstantDB.TABLEPET_CCOUNT, 0);
        db.insertPet(contentValues);

        contentValues.put(ConstantDB.TABLEPET_CNAME, "Gato");
        contentValues.put(ConstantDB.TABLEPET_CPHOTO, R.drawable.gato);
        contentValues.put(ConstantDB.TABLEPET_CCOUNT, 0);
        db.insertPet(contentValues);

        contentValues.put(ConstantDB.TABLEPET_CNAME, "Gatito");
        contentValues.put(ConstantDB.TABLEPET_CPHOTO, R.drawable.gato2);
        contentValues.put(ConstantDB.TABLEPET_CCOUNT, 0);
        db.insertPet(contentValues);

        contentValues.put(ConstantDB.TABLEPET_CNAME, "Gusano");
        contentValues.put(ConstantDB.TABLEPET_CPHOTO, R.drawable.gusano);
        contentValues.put(ConstantDB.TABLEPET_CCOUNT, 0);
        db.insertPet(contentValues);

        contentValues.put(ConstantDB.TABLEPET_CNAME, "Pato");
        contentValues.put(ConstantDB.TABLEPET_CPHOTO, R.drawable.pato);
        contentValues.put(ConstantDB.TABLEPET_CCOUNT, 0);
        db.insertPet(contentValues);

        contentValues.put(ConstantDB.TABLEPET_CNAME, "Perro");
        contentValues.put(ConstantDB.TABLEPET_CPHOTO, R.drawable.perro);
        contentValues.put(ConstantDB.TABLEPET_CCOUNT, 0);
        db.insertPet(contentValues);

        contentValues.put(ConstantDB.TABLEPET_CNAME, "Piolin");
        contentValues.put(ConstantDB.TABLEPET_CPHOTO, R.drawable.piolin);
        contentValues.put(ConstantDB.TABLEPET_CCOUNT, 0);
        db.insertPet(contentValues);

        contentValues.put(ConstantDB.TABLEPET_CNAME, "Pulpo");
        contentValues.put(ConstantDB.TABLEPET_CPHOTO, R.drawable.pulpo);
        contentValues.put(ConstantDB.TABLEPET_CCOUNT, 0);
        db.insertPet(contentValues);
    }

    public void updatePetDB(int id, int value){
        DataBase db = new DataBase(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantDB.TABLEPET_CCOUNT, value);
        db.updatePet(contentValues, "id = ?", new String []{Integer.toString(id)});
    }
}
