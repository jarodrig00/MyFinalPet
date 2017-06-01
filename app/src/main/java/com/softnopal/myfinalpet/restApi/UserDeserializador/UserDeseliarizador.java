package com.softnopal.myfinalpet.restApi.UserDeserializador;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.softnopal.myfinalpet.pojo.UserInstagram;
import com.softnopal.myfinalpet.restApi.JsonKeys;
import com.softnopal.myfinalpet.restApi.RestApiConstant;
import com.softnopal.myfinalpet.restApi.model.UserResponse;

import org.json.JSONArray;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by jarodrig00 on 31/05/17.
 */

public class UserDeseliarizador implements JsonDeserializer<UserResponse> {

    @Override
    public UserResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        UserResponse userResponse = gson.fromJson(json, UserResponse.class);
        JsonArray userResponseData = json.getAsJsonObject().getAsJsonArray(JsonKeys.MEDIA_RESPONSE_DATA);

        userResponse.setUsers(deserializarUserJSon(userResponseData));

        return userResponse;
    }

    private ArrayList<UserInstagram> deserializarUserJSon(JsonArray userResponseData){
        ArrayList<UserInstagram> userInstagrams = new ArrayList<>();

        for(int i = 0; i < userResponseData.size(); i++){
            JsonObject userJSon = userResponseData.get(i).getAsJsonObject();
            String id = userJSon.get(JsonKeys.USER_ID).getAsString();
            String user = userJSon.get(JsonKeys.USER_USERNAME).getAsString();
            String fullname = userJSon.get(JsonKeys.USER_FULLNAME).getAsString();

            UserInstagram userInstagram = new UserInstagram(id,user,fullname);
            userInstagrams.add(userInstagram);
        }
        return userInstagrams;
    }
}
