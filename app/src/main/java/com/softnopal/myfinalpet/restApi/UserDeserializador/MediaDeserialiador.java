package com.softnopal.myfinalpet.restApi.UserDeserializador;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.softnopal.myfinalpet.pojo.Pet;
import com.softnopal.myfinalpet.restApi.JsonKeys;
import com.softnopal.myfinalpet.restApi.model.MediaResponse;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by jarodrig00 on 31/05/17.
 */

public class MediaDeserialiador implements JsonDeserializer<MediaResponse> {
    @Override
    public MediaResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        MediaResponse mediaResponse = gson.fromJson(json, MediaResponse.class);
        JsonArray mediaResponseData = json.getAsJsonObject().getAsJsonArray(JsonKeys.MEDIA_RESPONSE_DATA);

        mediaResponse.setPets (deserializarMediaJSon(mediaResponseData));

        return mediaResponse;
    }

    private ArrayList<Pet> deserializarMediaJSon(JsonArray mediaResponseData) {
        ArrayList<Pet> pets = new ArrayList<>();

        for(int i = 0; i < mediaResponseData.size(); i++){
            JsonObject mediaJSon = mediaResponseData.get(i).getAsJsonObject();
            int id = 0;
            String nombre = "";
            int foto = 0;
            int cuenta = 0;
            String urlFoto = "";
            JsonObject imageJSon = mediaJSon.get(JsonKeys.IMAGES_OBJECT).getAsJsonObject();
            urlFoto = imageJSon.get(JsonKeys.IMAGES_RESOLUTION).getAsString();
            JsonObject likeJSon = mediaJSon.get(JsonKeys.LIKE_OBJECT).getAsJsonObject();
            cuenta = likeJSon.get(JsonKeys.LIKE_COUNT).getAsInt();
            JsonObject userJSon = mediaJSon.get(JsonKeys.USER_OBJECT).getAsJsonObject();
            id = userJSon.get(JsonKeys.USER_ID).getAsInt();
            nombre = userJSon.get(JsonKeys.USER_FULLNAME).getAsString();
            Pet pet = new Pet(id, nombre, foto,cuenta, urlFoto);
            pets.add(pet);
        }
        return pets;
    }
}
