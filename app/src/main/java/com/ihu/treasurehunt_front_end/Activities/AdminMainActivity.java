package com.ihu.treasurehunt_front_end.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.ihu.treasurehunt_front_end.R;
import com.ihu.treasurehunt_front_end.Requests.LogOutRequest;
import com.ihu.treasurehunt_front_end.Requests.RetroFitCreate;

public class AdminMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_main);

        TextView id = findViewById(R.id.userId);
        TextView username = findViewById(R.id.username);
        TextView role = findViewById(R.id.userRole);

        MaterialButton createGame = findViewById(R.id.btnCreateGame);
        Button logOut = findViewById(R.id.logOut);

        Bundle bundle = getIntent().getExtras();

        id.append(bundle.getString("id"));
        username.append(bundle.getString("username"));
        role.append(bundle.getString("role"));

        RetroFitCreate retroFitCreate = new RetroFitCreate();

        createGame.setOnClickListener(v ->
                startActivity(new Intent(this
                        ,AdminCreateGamesActivity.class)
                ));

        logOut.setOnClickListener(v ->{
            LogOutRequest logOutRequest = new LogOutRequest();
            logOutRequest.logOutUser(retroFitCreate.getJsonPlaceHolderAPI(),SignInActivity.loginUser.getName());
            new Handler().postDelayed(() -> System.exit(0),100);
        });


    }
}