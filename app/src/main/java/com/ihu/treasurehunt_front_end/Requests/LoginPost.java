package com.ihu.treasurehunt_front_end.Requests;

import com.ihu.treasurehunt_front_end.Model.User;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPost {

    private String message;
    private User user;


    public void LoginUserPost(JsonPlaceHolderAPI jsonPlaceHolderAPI, String username, String password)
    {
        Call<User> call = jsonPlaceHolderAPI.loginUser(username,password);

        call.enqueue(new Callback<User>() {

            @Override
            public void onResponse(@NotNull Call<User> call, @NotNull Response<User> response) {

                if (response.code() == 200) {
                        user = response.body();
                        message = "login successful";
                    }
                    if (response.code() == 500)
                    {
                        message ="invalid inputs";
                        user = null;
                    }
                    if (response.code() == 404)
                    {
                        message="Problem with connection";
                        user = null;
                    }


            }
            @Override
            public void onFailure(@NotNull Call<User> call, @NotNull Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public String getMessage() {
        return this.message;
    }

    public User getUser() {
        return user;
    }
}