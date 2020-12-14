package com.ihu.treasurehunt_front_end.Activities.SettingsActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.ihu.treasurehunt_front_end.Activities.MainActivity;
import com.ihu.treasurehunt_front_end.Activities.SignInActivity;

import com.ihu.treasurehunt_front_end.R;

import com.ihu.treasurehunt_front_end.Requests.ChangePasswordRequest;

import com.ihu.treasurehunt_front_end.Requests.RequestFirstLocation;
import com.ihu.treasurehunt_front_end.Requests.RetroFitCreate;


public class PasswordChange extends AppCompatActivity {

    private ChangePasswordRequest changePasswordRequest = new ChangePasswordRequest();
    protected static RequestFirstLocation requestFirstLocation = new RequestFirstLocation();
    private RetroFitCreate retroFitCreate = new RetroFitCreate();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_change);

        TextView btnGoback = (TextView) findViewById(R.id.btnGoback);
        EditText OldPasswordTEXT = (EditText) findViewById(R.id.OldPasswordTEXT);
        TextView btnChangePass = (TextView) findViewById(R.id.btnChangePass);
        EditText Pass1 = (EditText) findViewById(R.id.newPass);
        EditText Pass2 = (EditText) findViewById(R.id.newPassConf);

        OldPasswordTEXT.setText(SignInActivity.loginPost.getUser().getPassword());

        btnChangePass.setOnClickListener(v -> {
            if (Pass1.getText().toString().equals(Pass2.getText().toString())) {
                changePasswordRequest.changePasswordPlayer(retroFitCreate.getJsonPlaceHolderAPI(), MainActivity.game.getUserLoggedIn(),Pass1.getText().toString());
                Snackbar.make(v, "The Password has changed successfully!" ,Snackbar.LENGTH_SHORT).show();
            }
            else
            {
                Snackbar.make(v, "Please check again new password!" ,Snackbar.LENGTH_SHORT).show();
            }
        });

        btnGoback.setOnClickListener(v -> {
            startActivity(new Intent(this, SettingsActivity.class));
        });
    }
}