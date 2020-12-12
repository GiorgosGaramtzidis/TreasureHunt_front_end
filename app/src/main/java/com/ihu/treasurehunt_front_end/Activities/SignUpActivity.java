package com.ihu.treasurehunt_front_end.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;
import android.widget.Toast;

import com.ihu.treasurehunt_front_end.Dialogs.RegistrationPatternDialog;
import com.ihu.treasurehunt_front_end.Model.User;
import com.ihu.treasurehunt_front_end.R;
import com.ihu.treasurehunt_front_end.Requests.RegisterPost;
import com.ihu.treasurehunt_front_end.Requests.RetroFitCreate;
import com.ihu.treasurehunt_front_end.Service.UserRegistrationService;


public class SignUpActivity extends AppCompatActivity {

    private TextView passwordText;
    private TextView passwordText2;
    private TextView userNameText;
    private final RetroFitCreate retroFitCreate = new RetroFitCreate();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        userNameText = findViewById(R.id.txtUserName);
        passwordText = findViewById(R.id.txtPassword);
        passwordText2 = findViewById(R.id.txtPassword2);
        TextView btnRegister = findViewById(R.id.btnRegister);
        Intent intent = new Intent(this,SignInActivity.class);
        TextView registrationPattern = findViewById(R.id.btnRegistrationPattern);

        btnRegister.setOnClickListener(v ->{
            UserRegistrationService userRegistrationService = new UserRegistrationService(
                    userNameText.getText().toString(),
                    passwordText.getText().toString()
                    ,passwordText2.getText().toString());
            if (userRegistrationService.isPasswordsMatch()
                    && userRegistrationService.passWordValidator()
                    && userRegistrationService.userNameValidator())
            {
                User user = new User(userNameText.getText().toString(), passwordText.getText().toString());
                RegisterPost registerPost = new RegisterPost();
                registerPost.RegisterUserPost(retroFitCreate.getJsonPlaceHolderAPI(),user);
                new Handler().postDelayed(() -> {
                    String string = registerPost.getString();
                    if (string.equals("Success register"))
                    {
                        startActivity(intent);
                        Toast.makeText(SignUpActivity.this, string, Toast.LENGTH_SHORT).show();
                    }
                    else
                        Toast.makeText(SignUpActivity.this, string, Toast.LENGTH_SHORT).show();

                }, 1000);


            }else
                Toast.makeText(this, "Invalid inputs", Toast.LENGTH_SHORT).show();
        });
        registrationPattern.setOnClickListener(v ->
        {
            RegistrationPatternDialog registrationPatternDialog = new RegistrationPatternDialog();
            registrationPatternDialog.show(getSupportFragmentManager(),"Registration Rules");
        });
    }
}