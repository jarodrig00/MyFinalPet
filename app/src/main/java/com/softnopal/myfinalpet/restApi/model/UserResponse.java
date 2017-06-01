package com.softnopal.myfinalpet.restApi.model;

import com.softnopal.myfinalpet.pojo.UserInstagram;

import java.util.ArrayList;

/**
 * Created by jarodrig00 on 29/05/17.
 */

public class UserResponse {
    private ArrayList<UserInstagram> users;

    public ArrayList<UserInstagram> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<UserInstagram> users) {
        this.users = users;
    }



}
