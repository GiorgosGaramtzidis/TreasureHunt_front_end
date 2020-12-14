package com.ihu.treasurehunt_front_end.Requests;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LogOutRequest
{
    public void logOutUser(JsonPlaceHolderAPI jsonPlaceHolderAPI, String username)
    {
        Call<Void> call = jsonPlaceHolderAPI.logoutUser(username);

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }
}
