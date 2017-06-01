package com.softnopal.myfinalpet.pojo;


import android.content.Context;
import android.content.SharedPreferences;
import com.softnopal.myfinalpet.R;

/**
 * Created by jarodrig00 on 29/05/17.
 */

public class UserInstagram {
    private String id;
    private String user;
    private String full_name;
    //Context context;

    public UserInstagram(){
        this.id = "ID";
        this.user = "USER";
        this.full_name = "FULL_NAME";
    }
    public UserInstagram(String id, String user, String full_name) {
        this.id = id;
        this.user = user;
        this.full_name = full_name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    /*
    public void readFromFile(){
        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getString(R.string.file_name), Context.MODE_PRIVATE);
        id = sharedPreferences.getString(context.getString(R.string.key_preferences_id), context.getString(R.string.id_default));
        user = sharedPreferences.getString(context.getString(R.string.key_preferences_user), context.getString(R.string.user_default));
        full_name = sharedPreferences.getString(context.getString(R.string.key_preferences_fullname), context.getString(R.string.fullname_default));
    }

    public void saveToFile(){
        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getString(R.string.file_name), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(context.getString(R.string.key_preferences_id), id);
        editor.putString(context.getString(R.string.key_preferences_user), user);
        editor.putString(context.getString(R.string.key_preferences_fullname), full_name);
        editor.commit();
    }
*/
}

