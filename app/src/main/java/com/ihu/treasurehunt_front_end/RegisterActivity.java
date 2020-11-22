package com.ihu.treasurehunt_front_end;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.ihu.treasurehunt_front_end.Model.UsersQuest;
import com.ihu.treasurehunt_front_end.Requests.RequestGetUsers;
//import com.ihu.treasurehunt_front_end.Requests.RequestGetUsers;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;


public class RegisterActivity extends AppCompatActivity {

    private EditText userName;
    private EditText userPassword;
    private EditText userPasswordVerification;
    private Button register;
    private RequestQueue requestQueue;
    //private RequestPostUsers requestPostUsers;
    public static RequestGetUsers requestGetUsers = new RequestGetUsers();
    private List<UsersQuest> users = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        RequestQueue requestQueue = Volley.newRequestQueue(RegisterActivity.this);
        users = requestGetUsers.requestGetUsers(requestQueue);
        userName = (EditText)findViewById(R.id.userNameRegister);
        userPassword = (EditText)findViewById(R.id.userPasswordRegister);
        userPasswordVerification = (EditText)findViewById(R.id.userPsswrdVerification);
        register = (Button)findViewById(R.id.registerBtn);

        Intent intentRegister;
        intentRegister = new Intent(this,LoginActivity.class);
        //requestPostUsers = new RequestPostUsers();
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!userPassword.getText().toString().equals(userPasswordVerification.getText().toString()))
                    Toast.makeText(RegisterActivity.this, "Confirm password is not correct", Toast.LENGTH_SHORT).show();
                else
                {

                    String data = "{" +
                            "        \"userId\":"+ "\""+(users.get(users.size()-1).userId+1)+"\""+","+
                            "        \"name\":"+ "\""+userName.getText().toString()+"\""+"," +
                            "        \"score\": 0," +
                            "        \"password\": "+"\""+userPassword.getText().toString()+"\""+
                            "    }";
                    submit(data);
                    startActivity(intentRegister);
                }
            }
        });




    }

    public void submit(String data)
    {
        final String savedata= data;
        String URL = "http://192.168.1.9:6039/Users/addUsers";
        requestQueue = Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest  = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                try {
                    JSONObject objres = new JSONObject(response);
                    Toast.makeText(getApplicationContext(), objres.toString(), Toast.LENGTH_LONG).show();

                } catch (JSONException e) {
                    Toast.makeText(getApplicationContext(), "Server Error", Toast.LENGTH_LONG).show();
                }
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            public String getBodyContentType() {
                return "application/json; charset = utf-8";
            }

            @Override
            public byte[] getBody() throws AuthFailureError {
                try{
                    return savedata==null?null:savedata.getBytes("utf-8");
                }
                catch (UnsupportedEncodingException uee){
                    return null;
                }
            }
        };
        requestQueue.add(stringRequest);
    }



}