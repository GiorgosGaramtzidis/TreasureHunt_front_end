package com.ihu.treasurehunt_front_end.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;
import android.widget.Toast;

import com.ihu.treasurehunt_front_end.R;
import com.ihu.treasurehunt_front_end.Requests.JsonPlaceHolderAPI;
import com.ihu.treasurehunt_front_end.Requests.LoginPost;
import com.ihu.treasurehunt_front_end.Requests.RetroFitCreate;


public class SignInActivity extends AppCompatActivity {


    private TextView txtLoginUserName;
    private TextView txtLoginPassword;
    private final RetroFitCreate retroFitCreate = new RetroFitCreate();
    protected static LoginPost loginPost = new LoginPost();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        txtLoginUserName = findViewById(R.id.txtLoginUserName);
        txtLoginPassword = findViewById(R.id.txtLoginPassword);
        TextView btnRegisterIfNotSignedUp = findViewById(R.id.btnRegisterIfNotSignedUp);
        TextView btnLogin = findViewById(R.id.btnLogin);
        Intent intent = new Intent(this,MainActivity.class);
        Intent intentToRegister = new Intent(this,SignUpActivity.class);


        btnLogin.setOnClickListener(v -> {

            loginPost.LoginUserPost(retroFitCreate.getJsonPlaceHolderAPI(),txtLoginUserName.getText().toString(),txtLoginPassword.getText().toString());
            new Handler().postDelayed(() -> {

                if (loginPost.getUserState()==null) {
                    Toast.makeText(this, "User does not exist!!", Toast.LENGTH_SHORT).show();

                }
                else if(!loginPost.getUserState()) {
                    Toast.makeText(this, "Wrong Password!!", Toast.LENGTH_SHORT).show();

                }
                else{
                    startActivity(intent);
                    Toast.makeText(this, "You logged in", Toast.LENGTH_SHORT).show();
                }

            }, 500);
    });
        btnRegisterIfNotSignedUp.setOnClickListener(v -> {
            startActivity(intentToRegister);
        });
    }
}
