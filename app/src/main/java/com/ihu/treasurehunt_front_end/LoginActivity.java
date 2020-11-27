package com.ihu.treasurehunt_front_end;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.ihu.treasurehunt_front_end.Model.UsersQuest;
import com.ihu.treasurehunt_front_end.Requests.RequestGetUsers;

import java.util.List;

public class LoginActivity extends AppCompatActivity {

    private EditText name;
    private EditText password;
    private Button login;
    private TextView signUp;
    private int counter=3;
    public static RequestGetUsers requestGetUsers = new RequestGetUsers();
    private UsersQuest usersQuest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        name = (EditText)findViewById(R.id.userName);
        password = (EditText)findViewById(R.id.userPassword);
        login = (Button) findViewById(R.id.loginBtn);
        signUp = (TextView) findViewById(R.id.signUp);

        RequestQueue requestQueue = Volley.newRequestQueue(LoginActivity.this);
        List<UsersQuest> users = requestGetUsers.requestGetUsers(requestQueue);


        Intent intentMain;
        intentMain = new Intent(this, MainActivity.class);
        Intent intentSignUp;
        intentSignUp = new Intent(this, RegisterActivity.class);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (UsersQuest usersQuest : users) {
                    if (usersQuest.name.equals(name.getText().toString())&&usersQuest.password.equals(password.getText().toString()))
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