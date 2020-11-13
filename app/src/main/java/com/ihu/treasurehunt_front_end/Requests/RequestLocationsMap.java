package com.ihu.treasurehunt_front_end.Requests;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.ihu.treasurehunt_front_end.Model.LocationsMap;
import com.ihu.treasurehunt_front_end.Model.RiddleQuest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class RequestLocationsMap {
    public List<LocationsMap> requestLocationsMap(RequestQueue requestQueue)
    {
        String URL="http://192.168.56.1:6039/Locations/find";

        List<LocationsMap> list = new ArrayList<>();
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
                                list.add(new LocationsMap(
                                        jsonObject.getInt("Id")
                                        , jsonObject.getDouble("v")
                                        , jsonObject.getDouble("v1")
                                        , jsonObject.getString("title")
                                        ,jsonObject.getString("color")));
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
