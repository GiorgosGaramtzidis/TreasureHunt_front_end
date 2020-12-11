package com.ihu.treasurehunt_front_end.ResponseHandlers;


import com.ihu.treasurehunt_front_end.Model.RegistrationAnswer;

import retrofit2.Response;

public class RegisterResponseHandler implements IResponseHandler<String>
{

    @Override
    public String handleResponse(Response response) {
        RegistrationAnswer registrationAnswer = new RegistrationAnswer(response.body().toString());

        if (response.code() == 200)
            return registrationAnswer.getAnswer();
        if (response.code() == 500)
            return response.message();
        return "Error with connection";
    }
}
