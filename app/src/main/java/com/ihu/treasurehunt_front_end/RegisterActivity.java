package com.ihu.treasurehunt_front_end;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.ihu.treasurehunt_front_end.Model.TreasureHuntGame;
import com.ihu.treasurehunt_front_end.Model.User;
import com.ihu.treasurehunt_front_end.Requests.RetroFitCreate;
import com.ihu.treasurehunt_front_end.Requests.UserList;

import java.util.ArrayList;
import java.util.List;




public class RegisterActivity extends AppCompatActivity {

    private EditText userName;
    private EditText userPassword;
    private EditText userPasswordVerification;
    private Button register;
    private RequestQueue requestQueue;
    private List<User> userList = new ArrayList<>();
    private RetroFitCreate retroFitCreate = new RetroFitCreate();
    private UserList usersList = new UserList();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        RequestQueue requestQueue = Volley.newRequestQueue(RegisterActivity.this);
        TreasureHuntGame treasureHuntGame = MainActivity.getTreasureHuntGame();
        userList = treasureHuntGame.getUserList();
        userName = (EditText)findViewById(R.id.userNameRegister);
        userPassword = (EditText)findViewById(R.id.userPasswordRegister);
        userPasswordVerification = (EditText)findViewById(R.id.userPsswrdVerification);
        register = (Button)findViewById(R.id.registerBtn);

        Intent intentRegister;
        intentRegister = new Intent(this,LoginActivity.class);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!userPassword.getText().toString().equals(userPasswordVerification.getText().toString()))
                    Toast.makeText(RegisterActivity.this, "Confirm password is not correct", Toast.LENGTH_SHORT).show();
                else
                {
                    usersList.createUser(retroFitCreate.getJsonPlaceHolderAPI()
                                        ,userList.get(userList.size()-1).getUserId()+1
                                        ,userName.getText().toString()
                                        ,userPassword.getText().toString());
                    startActivity(intentRegister);
                }
            }
        });




    }

}