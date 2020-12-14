package com.ihu.treasurehunt_front_end.Requests;

import com.ihu.treasurehunt_front_end.Model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChangeNameRequest {


    String ok ;

    public void changeNamePlayer(JsonPlaceHolderAPI jsonPlaceHolderAPI,String userName , String newName) {
        Call<String> call = jsonPlaceHolderAPI.changeName(userName,newName);

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (!response.isSuccessful()) {
                    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++SUCCESS====================Code: " + response.code());
                    return;
                }
                ok = response.body();

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });
    }
}
