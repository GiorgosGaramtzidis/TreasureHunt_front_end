package com.ihu.treasurehunt_front_end.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.ihu.treasurehunt_front_end.R;

public class GameWinActivity extends AppCompatActivity {

    private static final int SPLASH_SCREEN= 5000;
    Animation topAnimation,botAnimation;
    ImageView imageView;
    TextView treasure,slogan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_win);

        //Animations
        topAnimation = AnimationUtils.loadAnimation(this,R.anim.top_anim);
        botAnimation = AnimationUtils.loadAnimation(this,R.anim.bott_anim);

        //Hooks
        imageView = findViewById(R.id.TreasurePic);
        treasure = findViewById(R.id.txtTreasure);
        slogan = findViewById(R.id.txtSlogan);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(GameWinActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);
    }
}