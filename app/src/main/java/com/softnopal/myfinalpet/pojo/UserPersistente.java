package com.softnopal.myfinalpet.pojo;

import android.content.Context;
import android.content.SharedPreferences;

import com.softnopal.myfinalpet.R;

/**
 * Created by jarodrig00 on 31/05/17.
 */

public class UserPersistente  {
    Context context;

    public UserPersistente(Context context) {
        this.context = context;
    }

    public void saveToFile(UserInstagram userInstagram){
        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getString(R.string.file_name), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(context.getString(R.string.key_preferences_id), userInstagram.getId());
        editor.putString(context.getString(R.string.key_preferences_user), userInstagram.getUser());
        editor.putString(context.getString(R.string.key_preferences_fullname), userInstagram.getFull_name());
        editor.commit();
    }

    public UserInstagram readToFile(){
        UserInstagram userInstagram = new UserInstagram();
        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getString(R.string.file_name), Context.MODE_PRIVATE);
        userInstagram.setId(sharedPreferences.getString(context.getString(R.string.key_preferences_id), context.getString(R.string.id_default)));
        userInstagram.setUser(sharedPreferences.getString(context.getString(R.string.key_preferences_user), context.getString(R.string.user_default)));
        userInstagram.setFull_name(sharedPreferences.getString(context.getString(R.string.key_preferences_fullname), context.getString(R.string.fullname_default)));
        return  userInstagram;
    }
}
