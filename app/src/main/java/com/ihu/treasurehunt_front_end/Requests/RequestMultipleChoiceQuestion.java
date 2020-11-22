package com.ihu.treasurehunt_front_end.Requests;
import android.util.Log;

import com.ihu.treasurehunt_front_end.Model.MultipleChoiceQuest;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.ihu.treasurehunt_front_end.Model.RiddleQuest;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
public class RequestMultipleChoiceQuestion {
        public List<MultipleChoiceQuest> requestMultipleQuestions(RequestQueue requestQueue) {
            String URL = "http://192.168.42.65:6039/MultipleChoiceQuestions/find";

            List<MultipleChoiceQuest> list = new ArrayList<>();
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
                                    list.add(new MultipleChoiceQuest(
                                            jsonObject.getString("questionId")
                                            , jsonObject.getString("question")
                                            , jsonObject.getString("wrongAnswer1")
                                            , jsonObject.getString("wrongAnswer2")
                                            , jsonObject.getString("correctAnswer")
                                            , jsonObject.getInt("points")));
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.e("rest Response", error.toString());
                        }
                    }
            );
            requestQueue.add(jsonArrayRequest);
            return list;
        }

    }
