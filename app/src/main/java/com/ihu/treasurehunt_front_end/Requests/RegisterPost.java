package com.ihu.treasurehunt_front_end.Requests;
import com.ihu.treasurehunt_front_end.Model.RegistrationAnswer;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterPost
{
    private  RegistrationAnswer registrationAnswer;

    public void RegisterUserPost(JsonPlaceHolderAPI jsonPlaceHolderAPI, String userName , String passWord)
    {

        Call<RegistrationAnswer> call = jsonPlaceHolderAPI.RegisterUser(userName,passWord);

        call.enqueue(new Callback<RegistrationAnswer>() {
            @Override
            public void onResponse(@NotNull Call<RegistrationAnswer> call, @NotNull Response<RegistrationAnswer> response)
            {
               if(response.code() == 200)
                   registrationAnswer = response.body();
               if (response.code() == 500)
                   registrationAnswer = new RegistrationAnswer(response.message());
               if (response.code()== 404)
                   registrationAnswer = new RegistrationAnswer("Problem with network");
            }
            @Override
            public void onFailure(@NotNull Call<RegistrationAnswer> call, @NotNull Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public RegistrationAnswer  getRegistrationAnswer()
    {
        return this.registrationAnswer;
    }

}
