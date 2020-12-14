package com.ihu.treasurehunt_front_end.Activities.SettingsActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.material.snackbar.Snackbar;
import com.ihu.treasurehunt_front_end.Activities.MainActivity;
import com.ihu.treasurehunt_front_end.Activities.MapsActivity;
import com.ihu.treasurehunt_front_end.Activities.SignInActivity;
import com.ihu.treasurehunt_front_end.Activities.SignUpActivity;
import com.ihu.treasurehunt_front_end.Model.Game;
import com.ihu.treasurehunt_front_end.Model.User;
import com.ihu.treasurehunt_front_end.R;
import com.ihu.treasurehunt_front_end.Requests.ChangeNameRequest;
import com.ihu.treasurehunt_front_end.Requests.JsonPlaceHolderAPI;
import com.ihu.treasurehunt_front_end.Requests.LoginPost;
import com.ihu.treasurehunt_front_end.Requests.RegisterPost;
import com.ihu.treasurehunt_front_end.Requests.RequestFirstLocation;
import com.ihu.treasurehunt_front_end.Requests.RetroFitCreate;
import com.ihu.treasurehunt_front_end.Service.UserRegistrationService;

import org.w3c.dom.Text;

public class NameChange extends AppCompatActivity {


    private RetroFitCreate retroFitCreate = new RetroFitCreate();
    private ChangeNameRequest changeNameRequest = new ChangeNameRequest();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_change);
        EditText OldNameTEXT = (EditText) findViewById(R.id.OldNameTEXT);
        TextView btnGoback = (TextView) findViewById(R.id.btnGoback);
        TextView btnChangeName = (TextView) findViewById(R.id.btnChangeName);
        EditText name1 = (EditText) findViewById(R.id.NewName);
        EditText name2 = (EditText) findViewById(R.id.NewNameConf);



        OldNameTEXT.setText(SettingsActivity.game.getUserLoggedIn());

        btnChangeName.setOnClickListener(v -> {
            UserRegistrationService userRegistrationService = new UserRegistrationService(
                    name1.getText().toString(),
                    name2.getText().toString(),
                    name2.getText().toString()
            );
                    if (name1.getText().toString().equals(name2.getText().toString()) && userRegistrationService.userNameValidator()) {
                        changeNameRequest.changeNamePlayer(retroFitCreate.getJsonPlaceHolderAPI(),MainActivity.game.getUserLoggedIn(),name2.getText().toString());
                        Snackbar.make(v, "The name has changed successfully!" ,Snackbar.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Snackbar.make(v, "Please check again new names!" ,Snackbar.LENGTH_SHORT).show();
                    }
                });


            btnGoback.setOnClickListener(v -> {
                startActivity(new Intent(this, SettingsActivity.class));
            });

    }
}