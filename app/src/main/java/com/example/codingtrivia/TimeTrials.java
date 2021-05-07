package com.example.codingtrivia;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

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
    RadioGroup radioGroup;
    TextView timeTrialHighscore;
    // Initialize Time Duration
    long duration = TimeUnit.SECONDS.toMillis(15);

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
        radioGroup=(RadioGroup)findViewById(R.id.groupradio);
        timeTrialHighscore=(TextView)findViewById(R.id.highscoreText);
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
                timeEndDialog.setMessage("Here is your score: " + Score.time_point);
                timeEndDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Take Me to Main Menu",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                Score.time_point = 0;
                                Intent act_action = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(act_action);
                            }
                        });
                timeEndDialog.show();

            }

        }.start();

        refresh();
    }
    private void refresh(){
        QuestionsArray.getInstance();
        Random ran = new Random();
        int randomquestion = ran.nextInt(QuestionsArray.questions_array.length);
        question =QuestionsArray.questions_array[randomquestion];
        question_text.setText(question.getQuestion());

        String[] ansArr=question.shuffleAnswerArray();
        ans1.setText(ansArr[0]);
        ans2.setText(ansArr[1]);
        ans3.setText(ansArr[2]);

        radioGroup.clearCheck();



        scoreText.setTextSize(20);
        Score.getInstance();
        scoreText.setText("Score: " + Score.time_point);

        Score.getInstance();
        SharedPreferences prefs = getSharedPreferences("myPrefsKey", MODE_PRIVATE);
        Score.time_highscore = prefs.getInt("TimeTrial Highscore", 0);
        timeTrialHighscore.setText("TimeTrial Highscore: "+Score.time_highscore);
    }

    public void onSubmit(View view) {
        if(ans1.isChecked()){
            if(ans1.getText()==question.getReal_answer()){
                Toast.makeText(getApplicationContext(), "Correct! +1 Score", Toast.LENGTH_SHORT).show();
                Score.time_point += 1;
                if (Score.time_point>Score.time_highscore){
                    Score.time_highscore=Score.time_point;
                    SharedPreferences prefs = getSharedPreferences("myPrefsKey", MODE_PRIVATE);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putInt("TimeTrial Highscore", Score.time_highscore);
                    editor.commit();
                }
                duration += TimeUnit.SECONDS.toMillis(5);
                refresh();
                onCheckRemove();
            }
            else{
                dialogAlert();
            }
        }
        else if(ans2.isChecked()){
            if(ans2.getText()==question.getReal_answer()){
                Toast.makeText(getApplicationContext(), "Correct! +1 Score", Toast.LENGTH_SHORT).show();
                Score.time_point += 1;
                duration += TimeUnit.SECONDS.toMillis(5);
                if (Score.time_point>Score.time_highscore){
                    Score.time_highscore=Score.time_point;
                    SharedPreferences prefs = getSharedPreferences("myPrefsKey", MODE_PRIVATE);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putInt("TimeTrial Highscore", Score.time_highscore);
                    editor.commit();
                }
                refresh();
                onCheckRemove();
            }
            else{
                dialogAlert();
            }
        }
        else if(ans3.isChecked()){
            if(ans3.getText()==question.getReal_answer()){
                Toast.makeText(getApplicationContext(), "Correct! +1 Score", Toast.LENGTH_SHORT).show();
                Score.time_point += 1;
                if (Score.time_point>Score.time_highscore){
                    Score.time_highscore=Score.time_point;
                    SharedPreferences prefs = getSharedPreferences("myPrefsKey", MODE_PRIVATE);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putInt("TimeTrial Highscore", Score.time_highscore);
                    editor.commit();
                }
                duration += TimeUnit.SECONDS.toMillis(5);
                refresh();
                onCheckRemove();
            }
            else{
                dialogAlert();
            }
        }

    }
    public void onCheck(View view) {
        submitPng.setVisibility(View.VISIBLE);
    }
    public void onCheckRemove(){submitPng.setVisibility(View.INVISIBLE);}
    private void dialogAlert(){

        AlertDialog gameEndDialog = new AlertDialog.Builder(TimeTrials.this).create();
        gameEndDialog.setTitle("You Lost!");
        gameEndDialog.setCanceledOnTouchOutside(false);
        gameEndDialog.setMessage("Here is your score: " + Score.time_point);
        gameEndDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Take Me to Main Menu",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        Score.time_point = 0;
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