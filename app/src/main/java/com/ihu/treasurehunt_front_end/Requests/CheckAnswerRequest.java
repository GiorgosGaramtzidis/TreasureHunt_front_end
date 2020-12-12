package com.ihu.treasurehunt_front_end.Requests;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CheckAnswerRequest {

    private boolean result;

    public boolean isResult() {
        return result;
    }

    public void answerCheck(JsonPlaceHolderAPI jsonPlaceHolderAPI, String usersAnswer, String locationTitle) {
        Call<Boolean> call = jsonPlaceHolderAPI.checkAnswer(usersAnswer, locationTitle);

        call.enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                if (!response.isSuccessful()) {
                    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++SUCCESS====================Code: " + response.code());

                }
                System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++SUCCESS====================Code: " + response.body());

                result=response.body();

            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });
    }
}
