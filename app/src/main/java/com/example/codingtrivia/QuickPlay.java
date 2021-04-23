package com.example.codingtrivia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class QuickPlay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick_play);
    }

    public void onGoBackClick(View view) {
        Intent act_action = new Intent(this, MainActivity.class);
        startActivity(act_action);
    }
}