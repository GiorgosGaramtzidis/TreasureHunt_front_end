package com.ihu.treasurehunt_front_end.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.ihu.treasurehunt_front_end.R;

public class AdminMainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_main);

        TextView id = findViewById(R.id.userId);
        TextView username = findViewById(R.id.username);
        TextView role = findViewById(R.id.userRole);

        MaterialButton createGame = findViewById(R.id.btnCreateGame);

        Bundle bundle = getIntent().getExtras();

        id.append(bundle.getString("id"));
        username.append(bundle.getString("username"));
        role.append(bundle.getString("role"));

        createGame.setOnClickListener(v ->
                startActivity(new Intent(this
                        ,AdminCreateGamesActivity.class)
                ));

    }
}