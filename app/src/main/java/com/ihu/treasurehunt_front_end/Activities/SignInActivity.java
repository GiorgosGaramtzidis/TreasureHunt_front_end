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

    public static User loginUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        TextView txtLoginUserName = findViewById(R.id.txtLoginUserName);
        TextView txtLoginPassword = findViewById(R.id.txtLoginPassword);
        TextView btnRegisterIfNotSignedUp = findViewById(R.id.btnRegisterIfNotSignedUp);
        TextView btnLogin = findViewById(R.id.btnLogIn);

        Intent playerIntent = new Intent(this,MainActivity.class);
        Intent adminIntent = new Intent(this,AdminMainActivity.class);
        Intent intentToRegister = new Intent(this,SignUpActivity.class);

        RetroFitCreate retroFitCreate = new RetroFitCreate();
        LoginService loginService = new LoginService();

        btnLogin.setOnClickListener(v -> {
                loginService.LoginUser(retroFitCreate.getJsonPlaceHolderAPI()
                        ,txtLoginUserName.getText().toString()
                        ,txtLoginPassword.getText().toString());
                new Handler().postDelayed(() -> {
                    try {
                        loginUser =loginService.getUser();
                        startActivity(loginService.chooseIntent(playerIntent,adminIntent));
                    } catch (NullPointerException e)
                    {
                        Snackbar.make(v,loginService.getMessage(),Snackbar.LENGTH_SHORT).show();
                    }

                },500);
        });


        btnRegisterIfNotSignedUp.setOnClickListener(v -> startActivity(intentToRegister));
    }
}
