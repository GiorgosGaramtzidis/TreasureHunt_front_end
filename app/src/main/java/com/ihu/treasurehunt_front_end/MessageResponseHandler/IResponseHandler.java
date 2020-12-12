package com.ihu.treasurehunt_front_end.MessageResponseHandler;

import retrofit2.Response;

public interface IResponseHandler <T>
{
    T handleResponse(Response response);
}
