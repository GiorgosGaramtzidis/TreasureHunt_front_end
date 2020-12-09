package com.ihu.treasurehunt_front_end.ResponseHandlers;

import retrofit2.Response;

public interface IResponseHandler <T>
{
    T handleResponse(Response response);
}
