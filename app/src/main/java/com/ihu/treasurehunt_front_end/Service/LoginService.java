package com.ihu.treasurehunt_front_end.Service;

import android.content.Intent;

import com.ihu.treasurehunt_front_end.Model.User;
import com.ihu.treasurehunt_front_end.Model.UserRole;
import com.ihu.treasurehunt_front_end.Requests.JsonPlaceHolderAPI;

import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginService {

    private User user;
    private String message;

    public void LoginUser(JsonPlaceHolderAPI jsonPlaceHolderAPI, String username, String password) {
        Call<User> call = jsonPlaceHolderAPI.loginUser(username, password);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(@NotNull Call<User> call, @NotNull Response<User> response) {
                if (response.isSuccessful()) {
                    user = response.body();
                } else {
                    try {
                        assert response.errorBody() != null;
                        JSONObject jOb = new JSONObject(response.errorBody().string());
                        message = jOb.get("message").toString();

                    } catch (JSONException | IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            @Override
            public void onFailure(@NotNull Call<User> call, @NotNull Throwable t) {
                t.printStackTrace();
            }
        });
    }
    public User getUser() {
        return user;
    }
    public String getMessage() {
       return message;
    }
    public Intent chooseIntent(Intent playerIntent, Intent adminIntent)
    {
        if (user != null) {
            if (user.getRole().equals(UserRole.Player)) {
                playerIntent.putExtra("id",user.getUserId());
                playerIntent.putExtra("username",user.getName());
                playerIntent.putExtra("status",user.getStatus().toString());
                return playerIntent;
            }else {
                adminIntent.putExtra("id", user.getUserId());
                adminIntent.putExtra("role", user.getRole().toString());
                adminIntent.putExtra("username", user.getName());
                return adminIntent;
            }

        }else
            throw new NullPointerException();
    }
}