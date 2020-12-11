package com.ihu.treasurehunt_front_end.Requests;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroFitCreate {

    Retrofit retrofit ;

    public JsonPlaceHolderAPI getJsonPlaceHolderAPI(){
        retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.2:6038/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(JsonPlaceHolderAPI.class);
    }
}
