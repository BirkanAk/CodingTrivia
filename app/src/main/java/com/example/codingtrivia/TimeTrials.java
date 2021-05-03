package com.example.codingtrivia;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Time;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class TimeTrials extends AppCompatActivity {
    TextView question_text;
    TextView scoreText;
    RadioButton ans1;
    RadioButton ans2;
    ImageView submitPng;
    RadioButton ans3;
    Questions question;
    TextView countdown_text;
    // Initialize Time Duration
    long duration = TimeUnit.MINUTES.toMillis(1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_trials);

        question_text=(TextView)findViewById(R.id.question_text);
        scoreText=(TextView)findViewById(R.id.scoreText);
        submitPng=(ImageView)findViewById(R.id.submitPng);
        ans1=(RadioButton)findViewById(R.id.ans1_radio);
        ans2=(RadioButton)findViewById(R.id.ans2_radio);
        ans3=(RadioButton)findViewById(R.id.ans3_radio);
        countdown_text = (TextView)findViewById(R.id.countdown_text);

        submitPng.setVisibility(View.INVISIBLE);


        // Initialize Countdown Timer
        new CountDownTimer(duration, 1000) {

            @Override
            public void onTick(long l) {
                String sDuration = String.format(Locale.ENGLISH, "%02d : %02d",
                        TimeUnit.MILLISECONDS.toMinutes(l),TimeUnit.MILLISECONDS.toSeconds(l) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(l)));
                countdown_text.setText(sDuration);

            }
            @Override
            public void onFinish() {
                AlertDialog timeEndDialog = new AlertDialog.Builder(TimeTrials.this).create();
                timeEndDialog.setTitle("Your time is up!");
                timeEndDialog.setMessage("Here is your score: " + Score.point);
                timeEndDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Take Me to Main Menu",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                Score.point = 0;
                                Intent act_action = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(act_action);
                            }
                        });
                timeEndDialog.show();

            }

        }.start();

        QuestionsArray.getInstance();
        Random ran = new Random();
        int randomquestion = ran.nextInt(QuestionsArray.questions_array.length);
        question =QuestionsArray.questions_array[randomquestion];
        question_text.setText(question.getQuestion());

        String[] ansArr=question.shuffleAnswerArray();
        ans1.setText(ansArr[0]);
        ans2.setText(ansArr[1]);
        ans3.setText(ansArr[2]);

        scoreText.setTextSize(20);
        Score.getInstance();
        scoreText.setText("Score: " + Score.point);
    }
    private void refresh(){
        Intent refresh = getIntent();
        finish();
        startActivity(refresh);
    }

    public void onSubmit(View view) {
        if(ans1.isChecked()){
            if(ans1.getText()==question.getReal_answer()){
                Toast.makeText(getApplicationContext(), "Correct! +1 Score", Toast.LENGTH_SHORT).show();
                Score.point += 1;
                duration += TimeUnit.MINUTES.toSeconds(5);
                refresh();
            }
            else{
                dialogAlert();
            }
        }
        else if(ans2.isChecked()){
            if(ans2.getText()==question.getReal_answer()){
                Toast.makeText(getApplicationContext(), "Correct! +1 Score", Toast.LENGTH_SHORT).show();
                Score.point += 1;
                duration += TimeUnit.MINUTES.toSeconds(5);
                refresh();
            }
            else{
                dialogAlert();
            }
        }
        else if(ans3.isChecked()){
            if(ans3.getText()==question.getReal_answer()){
                Toast.makeText(getApplicationContext(), "Correct! +1 Score", Toast.LENGTH_SHORT).show();
                Score.point += 1;
                duration += TimeUnit.MINUTES.toSeconds(5);
                refresh();
            }
            else{
                dialogAlert();
            }
        }

    }
    public void onCheck(View view) {
        submitPng.setVisibility(View.VISIBLE);
    }
    private void dialogAlert(){

        AlertDialog gameEndDialog = new AlertDialog.Builder(TimeTrials.this).create();
        gameEndDialog.setTitle("You Lost!");
        gameEndDialog.setMessage("Here is your score: " + Score.point);
        gameEndDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Take Me to Main Menu",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        Score.point = 0;
                        Intent act_action = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(act_action);
                    }
                });
        gameEndDialog.show();

    }

    //public void onGoBackClick(View view) {
     //   Intent act_action = new Intent(this, MainActivity.class);
      //  startActivity(act_action);}
}