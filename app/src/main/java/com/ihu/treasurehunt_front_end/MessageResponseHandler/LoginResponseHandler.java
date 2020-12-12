package com.ihu.treasurehunt_front_end.MessageResponseHandler;

import retrofit2.Response;

public class LoginResponseHandler implements IResponseHandler<String>{


    @Override
    public String handleResponse(Response response) {
        if (response.code() == 500 )
            return response.message();
        if (response.code() == 200)
            return "Successful log in ";
        return "Error with connection";
    }

}
