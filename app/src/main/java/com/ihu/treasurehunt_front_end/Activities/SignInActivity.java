package com.ihu.treasurehunt_front_end.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.ihu.treasurehunt_front_end.Model.User;
import com.ihu.treasurehunt_front_end.R;
import com.ihu.treasurehunt_front_end.Requests.RetroFitCreate;
import com.ihu.treasurehunt_front_end.Service.LoginService;


public class SignInActivity extends AppCompatActivity {


    protected TextView txtLoginUserName;
    protected TextView txtLoginPassword;
    private final RetroFitCreate retroFitCreate = new RetroFitCreate();
    public static LoginService loginPost = new LoginService();

    protected static User loginUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
         txtLoginUserName = findViewById(R.id.txtLoginUserName);
        txtLoginPassword = findViewById(R.id.txtLoginPassword);
        TextView btnRegisterIfNotSignedUp = findViewById(R.id.btnRegisterIfNotSignedUp);
        TextView btnLogin = findViewById(R.id.btnLogIn);
        Intent playerIntent = new Intent(this,MainActivity.class);
        //ToDo..
        Intent adminIntent = null;
        Intent intentToRegister = new Intent(this,SignUpActivity.class);


        btnLogin.setOnClickListener(v -> {

                loginPost.LoginUser(retroFitCreate.getJsonPlaceHolderAPI()
                        , txtLoginUserName.getText().toString()
                        , txtLoginPassword.getText().toString());
                new Handler().postDelayed(() -> {
                    if(loginPost.getUser() != null)
                    {
                        Snackbar.make(v,"You are logged in" , Snackbar.LENGTH_SHORT).show();
                        startActivity(loginPost.getRightIntent(playerIntent,adminIntent));

                    }else
                        Snackbar.make(v,loginPost.getMessage(),Snackbar.LENGTH_SHORT).show();

                 }, 300);
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
