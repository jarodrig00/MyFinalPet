package com.softnopal.myfinalpet.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.softnopal.myfinalpet.pojo.Pet;

import java.util.ArrayList;

/**
 * Created by jarodrig00 on 11/05/17.
 */

public class DataBase extends SQLiteOpenHelper {

    private Context context;

    public DataBase(Context context) {
        super(context, ConstantDB.DATABASE_NAME, null, ConstantDB.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String strQuery = "CREATE TABLE " + ConstantDB.TABLEPET_NAME + "(" +
                ConstantDB.TABLEPET_CID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                ConstantDB.TABLEPET_CNAME + " TEXT," +
                ConstantDB.TABLEPET_CPHOTO + " INTEGER," +
                ConstantDB.TABLEPET_CCOUNT + " INTEGER" +
                ")";
        try {
            db.execSQL(strQuery);
        }catch (Exception e){

        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ConstantDB.TABLEPET_NAME);
        onCreate(db);
    }

    public ArrayList<Pet> getAllPets(){
        ArrayList<Pet> pets = new ArrayList<>();
        String strQuery = "SELECT * FROM " + ConstantDB.TABLEPET_NAME;
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor registro = db.rawQuery(strQuery, null);
        while (registro.moveToNext()){
            Pet pet = new Pet(registro.getInt(0), registro.getString(1),
                                registro.getInt(2), registro.getInt(3));
            pets.add(pet);
        }
        db.close();
        return  pets;
    }

    public void insertPet(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantDB.TABLEPET_NAME, null, contentValues);
        db.close();
    }

    public  void updatePet(ContentValues contentValues, String where, String [] value){
        SQLiteDatabase db = this.getWritableDatabase();
        db.update(ConstantDB.TABLEPET_NAME, contentValues, where, value);
        db.close();
    }
}
