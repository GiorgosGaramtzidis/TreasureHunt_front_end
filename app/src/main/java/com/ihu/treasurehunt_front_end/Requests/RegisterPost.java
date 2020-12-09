package com.ihu.treasurehunt_front_end.Requests;
import com.ihu.treasurehunt_front_end.ResponseHandlers.IResponseHandler;
import com.ihu.treasurehunt_front_end.ResponseHandlers.RegisterResponseHandler;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterPost
{
    private IResponseHandler<String> iResponseHandler;
    String responseInfo;

    public void RegisterUserPost(JsonPlaceHolderAPI jsonPlaceHolderAPI, String userName , String passWord)
    {

        Call<String> call = jsonPlaceHolderAPI.RegisterUser(userName,passWord);

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(@NotNull Call<String> call, @NotNull Response<String> response)
            {
                iResponseHandler = new RegisterResponseHandler();
                responseInfo =iResponseHandler.handleResponse(response);
            }
            @Override
            public void onFailure(@NotNull Call<String> call, @NotNull Throwable t) {
                t.printStackTrace();
            }
        });
    }
    public String getResponseInfo()
    {
        return this.responseInfo;
    }


}
