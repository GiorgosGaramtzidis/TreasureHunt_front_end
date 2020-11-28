package com.ihu.treasurehunt_front_end.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.ihu.treasurehunt_front_end.Model.TreasureHuntGame;
import com.ihu.treasurehunt_front_end.Model.User;
import com.ihu.treasurehunt_front_end.R;


import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    private EditText name;
    private EditText password;
    private Button login;
    private TextView signUp;
    //private int counter=3;
    private List<User> userList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //ToDo...
        //TreasureHuntGame treasureHuntGame = MainActivity.getTreasureHuntGame();
        name = (EditText)findViewById(R.id.userName);
        password = (EditText)findViewById(R.id.userPassword);
        login = (Button) findViewById(R.id.loginBtn);
        signUp = (TextView) findViewById(R.id.signUp);
        //ToDo..
        //userList=treasureHuntGame.getUserList();



        Intent intentMain;
        intentMain = new Intent(this, MainActivity.class);
        Intent intentSignUp;
        intentSignUp = new Intent(this, RegisterActivity.class);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (User user : userList) {
                    if (user.getName().equals(name.getText().toString())&&user.getPassword().equals(password.getText().toString()))
                    {
                        startActivity(intentMain);

                    }
                }
            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentSignUp);
            }

        });
    }
}