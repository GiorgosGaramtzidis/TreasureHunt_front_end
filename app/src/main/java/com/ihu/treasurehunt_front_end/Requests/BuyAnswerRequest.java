package com.ihu.treasurehunt_front_end.Requests;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BuyAnswerRequest {

    private String answer;

    public String getAnswer() {
        return answer;
    }

    public void buyAnswer(JsonPlaceHolderAPI jsonPlaceHolderAPI, String userName, String question) {
        Call<String> call = jsonPlaceHolderAPI.boughtAnswer(userName,question);

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (!response.isSuccessful()) {
                    System.out.println(response.code());
                }
                answer = response.body();
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });
    }
}
