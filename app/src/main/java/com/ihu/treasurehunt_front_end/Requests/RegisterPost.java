package com.ihu.treasurehunt_front_end.Requests;
import com.ihu.treasurehunt_front_end.Model.User;
import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterPost
{
    private String string = "";

    public void RegisterUserPost(JsonPlaceHolderAPI jsonPlaceHolderAPI,User user)
    {

        Call<User> call = jsonPlaceHolderAPI.RegisterUser(user);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(@NotNull Call<User> call, @NotNull Response<User> response) {
                if (response.message().equals("User with this username : " + user.getUserName() + " already exists")) {
                    string = "Invalid name";
                }
                else
                {
                    string = "Success register";
                }
            }
            @Override
            public void onFailure(@NotNull Call<User> call, @NotNull Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public String getString() {
        return string;
    }
}
