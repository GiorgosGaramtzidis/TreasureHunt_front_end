package com.ihu.treasurehunt_front_end.Service;

import com.ihu.treasurehunt_front_end.Model.RegistrationAnswer;
import com.ihu.treasurehunt_front_end.Requests.JsonPlaceHolderAPI;

import org.jetbrains.annotations.NotNull;

import java.sql.SQLOutput;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterService
{
    private RegistrationAnswer registrationAnswer;

    public void RegisterUserPost(JsonPlaceHolderAPI jsonPlaceHolderAPI, String userName , String passWord ,String password2) {

        if (isStringMatches(passWord,password2) && isValidInputs(userName, passWord)) {
            Call<RegistrationAnswer> call = jsonPlaceHolderAPI.RegisterUser(userName, passWord);

            call.enqueue(new Callback<RegistrationAnswer>() {
                @Override
                public void onResponse(@NotNull Call<RegistrationAnswer> call, @NotNull Response<RegistrationAnswer> response)
                {
                    if (response.isSuccessful())
                        registrationAnswer = response.body();
                    else
                        registrationAnswer = new RegistrationAnswer(response.message());

                }
                @Override
                public void onFailure(@NotNull Call<RegistrationAnswer> call, @NotNull Throwable t) {
                    t.printStackTrace();
                }
            });
        }else {
            registrationAnswer = new RegistrationAnswer("Check your inputs");
        }
    }
    public Boolean isValidInputs(String usernameString , String passwordString)
    {

        final int userNameMinLength = 5;
        final int userNameMaxLength = 20;
        final int passwordMinLength = 8;

        return usernameString.length() > userNameMinLength
                && usernameString.length() <= userNameMaxLength
                && passwordString.length() >= passwordMinLength;
    }
   public Boolean isStringMatches(String str1 , String str2)
   {
       return str1.equals(str2);
   }
   public String getAnswer()
   {
       return this.registrationAnswer.getAnswer();
   }
}
