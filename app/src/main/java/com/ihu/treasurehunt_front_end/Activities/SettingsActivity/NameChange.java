package com.ihu.treasurehunt_front_end.Activities.SettingsActivity;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.material.snackbar.Snackbar;
import com.ihu.treasurehunt_front_end.Activities.MainActivity;
import com.ihu.treasurehunt_front_end.R;
import com.ihu.treasurehunt_front_end.Requests.ChangeNameRequest;
import com.ihu.treasurehunt_front_end.Requests.RetroFitCreate;



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

                    if (name1.getText().toString().equals(name2.getText().toString()) ) {
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