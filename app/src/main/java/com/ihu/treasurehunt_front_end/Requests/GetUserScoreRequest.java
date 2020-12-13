package com.ihu.treasurehunt_front_end.Requests;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetUserScoreRequest {


    private int score;

    public int getScore() {
        return score;
    }

    public void getUserScore(JsonPlaceHolderAPI jsonPlaceHolderAPI, String userName) {
        Call<Integer> call = jsonPlaceHolderAPI.getUserScore(userName);

        call.enqueue(new Callback<Integer>() {
            @Override
            public void onResponse(Call<Integer> call, Response<Integer> response) {
                if (!response.isSuccessful()) {
                    System.out.println( "============================OXI==================="+ response.code());
                    return;
                }
                GetUserScoreRequest.this.score = response.body();
                System.out.println( "============================NAI==================="+ response.body());
            }

            @Override
            public void onFailure(Call<Integer> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });
    }
}
