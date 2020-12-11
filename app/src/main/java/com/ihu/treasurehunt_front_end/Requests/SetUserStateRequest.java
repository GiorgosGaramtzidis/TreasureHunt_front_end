package com.ihu.treasurehunt_front_end.Requests;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SetUserStateRequest {

    private boolean succeeded;

    public void setUserState(JsonPlaceHolderAPI jsonPlaceHolderAPI, String userName) {

        Call<Boolean> call = jsonPlaceHolderAPI.setUserState(userName);

        call.enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                if (!response.isSuccessful()) {
                    System.out.println(response.code());
                    return;
                }
                succeeded = response.body();
            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });
    }
}
