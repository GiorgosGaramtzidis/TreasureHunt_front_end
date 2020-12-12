package com.ihu.treasurehunt_front_end.Requests;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CheckUserState {

    private String userToWIN;

    public String getUserToWIN() {
        return userToWIN;
    }

    public void checkUserState(JsonPlaceHolderAPI jsonPlaceHolderAPI) {
        Call<String> call = jsonPlaceHolderAPI.checkUserState();

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (!response.isSuccessful()) {
                    System.out.println( "======================================================================================"+response.code());
                }
                System.out.println( "======================================================================================"+response.body());

                userToWIN = response.body();

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                System.out.println("==============================================================MARKOS==================="+t.getMessage());
            }
        });
    }
}
