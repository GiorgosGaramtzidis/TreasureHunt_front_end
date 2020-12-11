package com.ihu.treasurehunt_front_end.Requests;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RestartScoreAndLives {

    public void restartScoreAndLives(JsonPlaceHolderAPI jsonPlaceHolderAPI) {
        Call<Boolean> call = jsonPlaceHolderAPI.restartScoreAndLives();

        call.enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                if (!response.isSuccessful()) {
                    System.out.println(response.code());
                    return;
                }
            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });
    }
}
