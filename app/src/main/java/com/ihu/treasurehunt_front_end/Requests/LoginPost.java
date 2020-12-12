package com.ihu.treasurehunt_front_end.Requests;

import com.ihu.treasurehunt_front_end.Model.User;
import com.ihu.treasurehunt_front_end.MessageResponseHandler.IResponseHandler;
import com.ihu.treasurehunt_front_end.MessageResponseHandler.LoginResponseHandler;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPost {

    private IResponseHandler<String> responseHandler;
    private String message;
    private User user;


    public void LoginUserPost(JsonPlaceHolderAPI jsonPlaceHolderAPI, String username, String password)
    {

        Call<User> call = jsonPlaceHolderAPI.loginUser(username,password);

        call.enqueue(new Callback<User>() {

            @Override
            public void onResponse(@NotNull Call<User> call, @NotNull Response<User> response) {
                    responseHandler = new LoginResponseHandler();
                    message = responseHandler.handleResponse(response);
                    if (message.equals("Successful log in"))
                        user = response.body();
            }
            @Override
            public void onFailure(@NotNull Call<User> call, @NotNull Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public String getMessage() {
        return message;
    }

    public User getUser() {
        return user;
    }
}