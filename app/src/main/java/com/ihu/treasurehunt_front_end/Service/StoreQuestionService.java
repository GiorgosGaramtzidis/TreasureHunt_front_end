package com.ihu.treasurehunt_front_end.Service;

import com.ihu.treasurehunt_front_end.Model.Question;
import com.ihu.treasurehunt_front_end.Requests.JsonPlaceHolderAPI;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StoreQuestionService
{
    private String message;

    public void store(JsonPlaceHolderAPI jsonPlaceHolderAPI,String question,String answer,String points)throws Exception
    {
        String id = "";
        if (answer.equals("") || question.equals("") || points.equals(""))
        {
            throw new Exception("Fill the textViews");
        }
        if (pointMatcher(points)) {
            Question questionToStore = new Question(id, question, answer, Integer.parseInt(points));
            Call<Boolean> call = jsonPlaceHolderAPI.createQuestion(questionToStore);
            call.enqueue(new Callback<Boolean>() {
                @Override
                public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                    if (response.isSuccessful())
                        message = "Question Store Successfully";
                    else {
                        try {
                            JSONObject jOb = new JSONObject(response.errorBody().string());
                            message = jOb.get("message").toString();
                        } catch (JSONException | IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

                @Override
                public void onFailure(Call<Boolean> call, Throwable t) {
                    t.printStackTrace();
                }
            });
        }else
            throw new Exception("Points must be an number");
    }
    public String getMessage() {
        return message;
    }

    public Boolean pointMatcher(String string)
    {
        String pattern = "^(?=.*[0-9])"
            + "(?=\\S+$).{1,5}$";
        return string.matches(pattern);
    }
}
