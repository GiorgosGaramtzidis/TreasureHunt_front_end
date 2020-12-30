package com.ihu.treasurehunt_front_end.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.ihu.treasurehunt_front_end.R;

public class AdminMainActivity extends AppCompatActivity {

    TextView id,username,role;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_main);

        id = findViewById(R.id.userId);
        username = findViewById(R.id.username);
        role = findViewById(R.id.userRole);

        Bundle bundle = getIntent().getExtras();

        id.append(bundle.getString("id"));
        username.append(bundle.getString("username"));
        role.append(bundle.getString("role"));
    }
}