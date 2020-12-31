package com.ihu.treasurehunt_front_end.Service;

import com.ihu.treasurehunt_front_end.Requests.JsonPlaceHolderAPI;
import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TreasureHuntGameService
{

    private String message;

    public void CreateGame(JsonPlaceHolderAPI jsonPlaceHolderAPI, String id, String title, String gameLocation)
    {
        if (isValidData(id,title,gameLocation)) {
            Call<Boolean> call = jsonPlaceHolderAPI.createGame(id, title, gameLocation);

            call.enqueue(new Callback<Boolean>() {
                @Override
                public void onResponse(@NotNull Call<Boolean> call, @NotNull Response<Boolean> response) {
                   if (response.body())
                       message = "Game Created successful";
                   else
                       message = "Check your inputs";
                }
                @Override
                public void onFailure(@NotNull Call<Boolean> call, @NotNull Throwable t) {
                }
            });
        }
    }

    public String generateID()
    {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder(5);

        for (int i = 0; i < 5; i++) {
            int index = (int)(AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }

        return sb.toString();
    }

    public Boolean isValidData(String id , String title ,String gameLocation)
    {
        if (id.matches(generateID()))
            return !title.equals("") && !gameLocation.equals("");
        return false;
    }
    public String getMessage() {
        return this.message;
    }
}
