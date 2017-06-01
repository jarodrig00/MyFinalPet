package com.softnopal.myfinalpet.restApi.adapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.softnopal.myfinalpet.restApi.EndPointApi;
import com.softnopal.myfinalpet.restApi.RestApiConstant;
import com.softnopal.myfinalpet.restApi.UserDeserializador.MediaDeserialiador;
import com.softnopal.myfinalpet.restApi.UserDeserializador.UserDeseliarizador;
import com.softnopal.myfinalpet.restApi.model.MediaResponse;
import com.softnopal.myfinalpet.restApi.model.UserResponse;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jarodrig00 on 29/05/17.
 */

public class RestApiAdapter {
    public EndPointApi establecerConexionRestApiInstagram(Gson gson){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RestApiConstant.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return retrofit.create(EndPointApi.class);
    }

    public Gson construyeGsonDeserializadorUserInstagram(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(UserResponse.class, new UserDeseliarizador());
        return gsonBuilder.create();
    }

    public Gson construyeGsonDeserializadorMediaInstagram(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(MediaResponse.class, new MediaDeserialiador());
        return gsonBuilder.create();
    }
}
