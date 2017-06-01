package com.softnopal.myfinalpet.restApi;

import com.softnopal.myfinalpet.pojo.Pet;
import com.softnopal.myfinalpet.pojo.UserInstagram;
import com.softnopal.myfinalpet.restApi.model.MediaResponse;
import com.softnopal.myfinalpet.restApi.model.UserResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/**
 * Created by jarodrig00 on 29/05/17.
 */

public interface EndPointApi {

    @GET(RestApiConstant.URL_USER)
    Call <UserResponse> getUser(@QueryMap Map<String, String> params);
    //Pet getMedia();

    @GET(RestApiConstant.URL_MEDIA)
    Call<MediaResponse> getMedia();
}
