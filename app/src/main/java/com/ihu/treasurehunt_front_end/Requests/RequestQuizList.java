package com.ihu.treasurehunt_front_end.Requests;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.ihu.treasurehunt_front_end.Model.QuizQuest;
import com.ihu.treasurehunt_front_end.Model.RiddleQuest;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class RequestQuizList
{
    public List<QuizQuest> requestQuestions(RequestQueue requestQueue)
    {
        String URL="http://192.168.1.8:6039/Quiz/all";
        List<QuizQuest> list = new ArrayList<>();
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                URL,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject jsonObject = (JSONObject) response.get(i);
                                JSONArray jarray =jsonObject.getJSONArray("characters");
                                String[] strings = new String[jarray.length()];
                                for (int j=0;j<jarray.length();j++)
                                {
                                    strings[j] = jarray.getString(j);
                                }
                                list.add(new QuizQuest(
                                        jsonObject.getInt("quizId"),
                                        jsonObject.getString("quiz"),
                                        jsonObject.getString("answer"),
                                        jsonObject.getInt("points"),
                                        strings
                                ));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("rest Response",error.toString());
                    }
                }
        );
        requestQueue.add(jsonArrayRequest);
        return list;
    }
}


