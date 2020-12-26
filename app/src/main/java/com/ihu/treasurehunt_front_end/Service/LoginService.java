package com.ihu.treasurehunt_front_end.Service;

import android.content.Intent;

import com.ihu.treasurehunt_front_end.Model.Role;
import com.ihu.treasurehunt_front_end.Model.User;
import com.ihu.treasurehunt_front_end.Requests.JsonPlaceHolderAPI;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginService {

    private User user ;
    private String failSignIn;

    public void LoginUser(JsonPlaceHolderAPI jsonPlaceHolderAPI, String username, String password) {

        if (isDataValid(username, password)) {
            Call<User> call = jsonPlaceHolderAPI.loginUser(username, password);
            call.enqueue(new Callback<User>() {
                @Override
                public void onResponse(@NotNull Call<User> call, @NotNull Response<User> response) {
                    if (response.code() == 200)
                        user = response.body();
                    if (response.code() == 500)
                        failSignIn = response.message();
                    if (response.code() == 404)
                        failSignIn = "Error with connection";
                }
                @Override
                public void onFailure(@NotNull Call<User> call, @NotNull Throwable t) {
                    t.printStackTrace();
                }
            });
        }else
            failSignIn = "Check your fields";
    }

    public Intent getRightIntent(Intent intentForPlayer , Intent intentForAdmin)throws NullPointerException
    {
        if (user.getRole().equals(Role.PLAYER))
            return intentForPlayer;
        if (user.getRole().equals(Role.ADMIN))
            return intentForAdmin;
        throw new NullPointerException();
    }
    public Boolean isDataValid(String usernameLength,String passwordLength)
    {
        //Login Rules
        final int maxUserNameLength = 20;
        final int minUserNameLength = 5 ;
        final int minPasswordLength = 8;

        return usernameLength.length() > minUserNameLength&& usernameLength.length() <= maxUserNameLength &&
                passwordLength.length() >=minPasswordLength;
    }
    public User getUser()
    {
        return this.user;
    }
    public String getMessage()
    {
        return this.failSignIn;
    }
}