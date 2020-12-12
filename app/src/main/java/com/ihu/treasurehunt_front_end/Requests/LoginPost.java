package com.ihu.treasurehunt_front_end.Requests;

import com.ihu.treasurehunt_front_end.Model.User;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class    LoginPost {
    private Boolean userState;
    private String userLoggedIn;

    public void LoginUserPost(JsonPlaceHolderAPI jsonPlaceHolderAPI, String username, String password)
    {

        Call<Boolean> call = jsonPlaceHolderAPI.LoginUser(username,password);

        call.enqueue(new Callback<Boolean>() {

            @Override
            public void onResponse(@NotNull Call<Boolean> call, @NotNull Response<Boolean> response) {
                userState=response.body();
                userLoggedIn=username;
            }
            @Override
            public void onFailure(@NotNull Call<Boolean> call, @NotNull Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public Boolean getUserState() {
        return userState;
    }
    public String getUserLoggedIn(){
        return userLoggedIn;}

}