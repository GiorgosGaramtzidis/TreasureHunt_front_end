package com.ihu.treasurehunt_front_end;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText name;
    private EditText password;
    private Button login;
    private TextView signUp;
    private int counter=3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        name = (EditText)findViewById(R.id.userName);
        password = (EditText)findViewById(R.id.userPassword);
        login = (Button) findViewById(R.id.loginBtn);
        signUp = (TextView) findViewById(R.id.signUp);

        Intent intentMain;
        intentMain = new Intent(this,MainActivity.class);
        Intent intentSignUp;
        intentSignUp = new Intent(this,RegisterActivity.class);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(name.getText().toString(),password.getText().toString());
            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentSignUp);
            }
        });
    }
    private void validate(String userName, String userPassword) {
        if(userName.equals("Admin")&&userPassword.equals("1234")){
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        }
        else
        {
            counter--;
            Toast.makeText(this, "No of attempts remaining: " +String.valueOf(counter), Toast.LENGTH_SHORT).show();
            if(counter==0)
            {
                login.setEnabled(false);
            }
        }

    }
}