package com.ihu.treasurehunt_front_end.Requests;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroFitCreate {

    Retrofit retrofit ;

    Gson gson = new GsonBuilder()
            .setLenient()
            .create();

    public JsonPlaceHolderAPI getJsonPlaceHolderAPI(){
        retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.2:6040/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return retrofit.create(JsonPlaceHolderAPI.class);
    }
}
