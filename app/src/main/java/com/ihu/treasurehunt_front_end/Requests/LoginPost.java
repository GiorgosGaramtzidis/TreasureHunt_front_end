package com.ihu.treasurehunt_front_end.Requests;

import com.ihu.treasurehunt_front_end.Model.User;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPost {
    private String string;

    public void LoginUserPost(JsonPlaceHolderAPI jsonPlaceHolderAPI)
    {

        Call<String> call = jsonPlaceHolderAPI.LoginUser("Konto4","Konto1");

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(@NotNull Call<String> call, @NotNull Response<String> response) {
                //string = response.body();
                System.out.println("============================================================"+response.code());
            }
            @Override
            public void onFailure(@NotNull Call<String> call, @NotNull Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public String getString() {
        return string;
    }
}