package com.ihu.treasurehunt_front_end.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.ihu.treasurehunt_front_end.Model.User;
import com.ihu.treasurehunt_front_end.R;
import com.ihu.treasurehunt_front_end.Requests.JsonPlaceHolderAPI;
import com.ihu.treasurehunt_front_end.Requests.LoginPost;
import com.ihu.treasurehunt_front_end.Requests.RetroFitCreate;


public class SignInActivity extends AppCompatActivity {


    private TextView txtLoginUserName;
    private TextView txtLoginPassword;
    private final RetroFitCreate retroFitCreate = new RetroFitCreate();
    protected final LoginPost loginPost = new LoginPost();
    protected static User loginUser;

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

            if (confirmTextViews()) {
                loginPost.LoginUserPost(retroFitCreate.getJsonPlaceHolderAPI(), txtLoginUserName.getText().toString(), txtLoginPassword.getText().toString());
                new Handler().postDelayed(() -> {
                    Snackbar.make(v, loginPost.getMessage(), Snackbar.LENGTH_SHORT).show();
                    if (loginPost.getUser() != null) {
                        loginUser = loginPost.getUser();
                        startActivity(intent);
                    }
                }, 1000);
            }else
                Snackbar.make(v,"Check your fields",Snackbar.LENGTH_SHORT).show();
        });
        btnRegisterIfNotSignedUp.setOnClickListener(v -> startActivity(intentToRegister));
    }
    public Boolean confirmTextViews()
    {
        return txtLoginUserName.getText().length() >= 5
                && txtLoginUserName.getText().length() <= 20
                && txtLoginPassword.getText().length() >= 8;
    }
}
