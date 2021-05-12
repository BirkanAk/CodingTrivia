package com.example.codingtrivia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;

import java.util.Arrays;

public class GameSettings extends AppCompatActivity {
    Button filterButton;
    RadioButton javacb;
    RadioButton pythoncb;
    RadioButton cppcb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        filterButton=(Button)findViewById(R.id.filterButton);
        javacb=(RadioButton)findViewById(R.id.cb_java);
        pythoncb=(RadioButton)findViewById(R.id.cb_python);
        cppcb=(RadioButton)findViewById(R.id.cb_cpp);


    }

    public void onGoBackClick(View view) {
        Intent act_action = new Intent(this, MainActivity.class);
        startActivity(act_action);
    }

    public void applyFilter(View view) {
        QuestionsArray.getInstance();

        if(javacb.isChecked()){
            QuestionsArray.selected="Java";
        }
        if(pythoncb.isChecked()){
            QuestionsArray.selected="Python";
        }
        if(cppcb.isChecked()){
            QuestionsArray.selected="C++";
        }
    }
}