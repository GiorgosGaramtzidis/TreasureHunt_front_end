package com.ihu.treasurehunt_front_end.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.snackbar.Snackbar;
import com.ihu.treasurehunt_front_end.Dialogs.RegistrationPatternDialog;
import com.ihu.treasurehunt_front_end.R;
import com.ihu.treasurehunt_front_end.Requests.RegisterPost;
import com.ihu.treasurehunt_front_end.Requests.RetroFitCreate;


public class SignUpActivity extends AppCompatActivity {

    private TextView passwordText;
    private TextView passwordText2;
    private TextView userNameText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        userNameText = findViewById(R.id.txtUserName);
        passwordText = findViewById(R.id.txtPassword);
        passwordText2 = findViewById(R.id.txtPassword2);
        TextView btnRegister = findViewById(R.id.btnRegister);
        TextView registrationPattern = findViewById(R.id.btnRegistrationPattern);


        RetroFitCreate retroFitCreate = new RetroFitCreate();
        RegisterPost registerPost = new RegisterPost();
        RegistrationPatternDialog registrationPatternDialog = new RegistrationPatternDialog();
        Intent intent = new Intent(this,SignInActivity.class);

        btnRegister.setOnClickListener(v ->{
            if (ConfirmTextViews())
            {
                registerPost.RegisterUserPost(retroFitCreate
                        .getJsonPlaceHolderAPI()
                        ,userNameText.getText().toString()
                        ,passwordText.getText().toString());

                new Handler().postDelayed(() -> Snackbar.make(v,
                        registerPost.getResponseInfo()
                        ,Snackbar.LENGTH_LONG).setAction("Go back", v1 ->
                        startActivity(intent)).show(),1000);
            }
            else
                Snackbar.make(v,"Check your password fields",Snackbar.LENGTH_SHORT).show();
        });

        registrationPattern.setOnClickListener(v ->
                registrationPatternDialog.show(getSupportFragmentManager(),"Registration Rules"));
    }

    public Boolean ConfirmTextViews()
    {
        if (userNameText.getText().length() >= 5
                && userNameText.getText().length()<=20
                && passwordText.getText().length() >= 8)
        {
            return passwordText.getText().length() == passwordText2.getText().length();
        }
        return false;
    }
}