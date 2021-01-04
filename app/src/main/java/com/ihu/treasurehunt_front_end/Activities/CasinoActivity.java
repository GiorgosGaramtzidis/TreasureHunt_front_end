package com.ihu.treasurehunt_front_end.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.ihu.treasurehunt_front_end.R;
import com.ihu.treasurehunt_front_end.Requests.CasinoRequest;
import com.ihu.treasurehunt_front_end.Requests.RetroFitCreate;

import org.w3c.dom.Text;

public class CasinoActivity extends AppCompatActivity {

    TextView casinoRisk;
    TextView casinoTxt;
    ImageButton riskBtn;
    ImageButton backBtn;

    private CasinoRequest casinoRequest = new CasinoRequest();
    private RetroFitCreate retroFitCreate = new RetroFitCreate();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_casino);

        backBtn = (ImageButton)findViewById(R.id.backBtn);
        riskBtn = (ImageButton)findViewById(R.id.riskBtn);
        casinoRisk = (TextView)findViewById(R.id.casinoRisk);
        casinoTxt = (TextView)findViewById(R.id.casinoTxt);

        riskBtn.setOnClickListener(v -> {
            casinoRequest.updateScore(retroFitCreate.getJsonPlaceHolderAPI(),MainActivity.game.getUserLoggedIn());
            new Handler().postDelayed(()->{
                if(casinoRequest.getHasWonRisk()){
                    Toast.makeText(CasinoActivity.this, "Congratulations! You just doubled your points!!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(CasinoActivity.this, "Seems like it's not your lucky day! You lost all your points.", Toast.LENGTH_SHORT).show();
                }
                finish();
            },1000);
            startActivity(new Intent(this, MapsActivity.class));
        });

        backBtn.setOnClickListener(v -> {
            startActivity(new Intent(this, MapsActivity.class));
        });


    }
}