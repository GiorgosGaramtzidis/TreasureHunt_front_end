package com.ihu.treasurehunt_front_end.Requests;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddPointsRequest {


    private int succeeded;


    public void addScoreToPlayer(JsonPlaceHolderAPI jsonPlaceHolderAPI,String userName) {
        Call<Integer> call = jsonPlaceHolderAPI.addScore(userName, 50);

        call.enqueue(new Callback<Integer>() {
            @Override
            public void onResponse(Call<Integer> call, Response<Integer> response) {
                if (!response.isSuccessful()) {
                    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++SUCCESS====================Code: " + response.code());
                    return;
                }
                succeeded = response.body();

            }

            @Override
            public void onFailure(Call<Integer> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });
    }
}