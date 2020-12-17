package com.ihu.treasurehunt_front_end.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ihu.treasurehunt_front_end.Model.User;
import com.ihu.treasurehunt_front_end.R;
import com.ihu.treasurehunt_front_end.Requests.LeaderBoardList;
import com.ihu.treasurehunt_front_end.Requests.RetroFitCreate;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class LeaderBoardActivity extends AppCompatActivity {

     protected static TextView textView ;
private RetroFitCreate retroFitCreate = new RetroFitCreate();
private LeaderBoardList leaderBoardList = new LeaderBoardList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leader_board);
        leaderBoardList.getLeaderBoard(retroFitCreate.getJsonPlaceHolderAPI());
        new Handler().postDelayed(() -> {
            textView.setText(leaderBoardList.getLeaderBoardList().toString());
        },1000);
        textView = findViewById(R.id.Result);

    }
}