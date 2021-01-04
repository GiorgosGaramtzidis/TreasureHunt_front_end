package com.ihu.treasurehunt_front_end.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import com.google.android.material.button.MaterialButton;
import com.ihu.treasurehunt_front_end.R;
import com.ihu.treasurehunt_front_end.Requests.LogOutRequest;
import com.ihu.treasurehunt_front_end.Requests.RetroFitCreate;


public class AdminMainActivity extends AppCompatActivity {

    TextView id,username,role;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_main);

        id = findViewById(R.id.userId);
        username = findViewById(R.id.username);
        role = findViewById(R.id.userRole);

        MaterialButton storeQuestion = findViewById(R.id.btnAddQuestions);
        Button logOut = findViewById(R.id.logOut);

        Bundle bundle = getIntent().getExtras();

        id.append(bundle.getString("id"));
        username.append(bundle.getString("username"));
        role.append(bundle.getString("role"));

        storeQuestion.setOnClickListener( v ->
                startActivity(new Intent(this,AdminStoreQuestionsActivity.class)));
        logOut.setOnClickListener(v ->{
            LogOutRequest logOutRequest = new LogOutRequest();
            RetroFitCreate retroFitCreate = new RetroFitCreate();
            logOutRequest.logOutUser(retroFitCreate.getJsonPlaceHolderAPI(),bundle.getString("username"));
            finish();
            System.exit(0);
        });
    }
}