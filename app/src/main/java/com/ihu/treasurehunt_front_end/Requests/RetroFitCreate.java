package com.ihu.treasurehunt_front_end.Requests;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroFitCreate {

    Retrofit retrofit ;
    public JsonPlaceHolderAPI getJsonPlaceHolderAPI(){
        retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.56.1:6039/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(JsonPlaceHolderAPI.class);
    }
}
