package com.ihu.treasurehunt_front_end.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.ihu.treasurehunt_front_end.R;
import com.ihu.treasurehunt_front_end.Requests.LogOutRequest;
import com.ihu.treasurehunt_front_end.Requests.RetroFitCreate;
import com.ihu.treasurehunt_front_end.Service.TreasureHuntGameService;

public class AdminCreateGamesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_create_games);

        TextInputEditText textGameId = findViewById(R.id.textGameId);
        TextInputEditText textGameTitle = findViewById(R.id.textGameTitle);
        TextInputEditText textGameArea = findViewById(R.id.textGameArea);

        MaterialButton generateId = findViewById(R.id.btnGenerateID);
        MaterialButton complete = findViewById(R.id.btnGameComplete);
        MaterialButton goBack = findViewById(R.id.btnGoback);
        TreasureHuntGameService treasureHuntGameService = new TreasureHuntGameService();
        RetroFitCreate retroFitCreate = new RetroFitCreate();
        generateId.setOnClickListener( v -> textGameId.setText(treasureHuntGameService.generateID()));

        goBack.setOnClickListener( v ->{
            textGameId.setText("");
            textGameArea.setText("");
            textGameTitle.setText("");
           finish();
        });
        complete.setOnClickListener(v ->{
            try {
                treasureHuntGameService.CreateGame(retroFitCreate.getJsonPlaceHolderAPI(),
                        textGameId.getText().toString(),
                        textGameTitle.getText().toString(),
                        textGameArea.getText().toString());
                new Handler().postDelayed(() -> Snackbar.make(
                        v,treasureHuntGameService.getMessage()
                        ,Snackbar.LENGTH_SHORT).show()
                        ,500);
            }catch (NullPointerException e){
             Snackbar.make(v,"Fill all textviews",Snackbar.LENGTH_SHORT).show();
            }
        });
    }
}