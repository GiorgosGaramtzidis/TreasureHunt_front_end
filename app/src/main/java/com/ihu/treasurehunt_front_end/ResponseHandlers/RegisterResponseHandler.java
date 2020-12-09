package com.ihu.treasurehunt_front_end.ResponseHandlers;

import retrofit2.Response;

public class RegisterResponseHandler implements IResponseHandler<String>
{

    @Override
    public String handleResponse(Response response) {
        if (response.code() == 500)
            return "User with this username already exists";
        if (response.code() == 200)
                return response.body().toString();
        return "Error with connection";
    }
}
