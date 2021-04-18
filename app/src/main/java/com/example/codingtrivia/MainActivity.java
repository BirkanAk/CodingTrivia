package com.example.codingtrivia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button QuickPlay;
    Button Settings;
    Button AdvancedQuizButton;
    Button TimeTrialButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        QuickPlay =(Button) findViewById(R.id.quickPlayButton);
        Settings=(Button) findViewById(R.id.settingsButton);
        AdvancedQuizButton=(Button) findViewById(R.id.advancedQuizButton);
        TimeTrialButton=(Button) findViewById(R.id.timeTrialButton);

        QuickPlay.setBackgroundColor(Color.parseColor("#3C3239"));
        Settings.setBackgroundColor(Color.parseColor("#9E1E11"));
        AdvancedQuizButton.setBackgroundColor(Color.parseColor("#C6A414"));
        TimeTrialButton.setBackgroundColor(Color.parseColor("#164321"));
    }

    public void openQuickPlay(View view) {
        Intent act_action = new Intent(this, com.example.codingtrivia.QuickPlay.class);
        startActivity(act_action);
    }

    public void onSettings(View view) {
        Intent act_action = new Intent(this, GameSettings.class);
        startActivity(act_action);
    }

    public void onTimeTrial(View view) {
        Intent act_action = new Intent(this,TimeTrials.class);
        startActivity(act_action);
    }

    public void onAdvancedClick(View view) {
        Intent act_action = new Intent(this,AdvancedQuiz.class);
        startActivity(act_action);
    }
}