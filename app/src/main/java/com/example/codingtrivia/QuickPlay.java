package com.example.codingtrivia;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

public class QuickPlay extends AppCompatActivity {
    TextView question_text;
    TextView scoreText;
    RadioButton ans1;
    RadioButton ans2;
    ImageView submitPng;
    RadioButton ans3;
    Questions question;
    RadioGroup radioGroup;
    TextView quickplayHighscore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick_play);

        question_text=(TextView)findViewById(R.id.question_text);
        scoreText=(TextView)findViewById(R.id.scoreText);
        submitPng=(ImageView)findViewById(R.id.submitPng);
        ans1=(RadioButton)findViewById(R.id.ans1_radio);
        ans2=(RadioButton)findViewById(R.id.ans2_radio);
        ans3=(RadioButton)findViewById(R.id.ans3_radio);
        radioGroup=(RadioGroup)findViewById(R.id.groupradio);
        quickplayHighscore=(TextView)findViewById(R.id.highscoreText);

        submitPng.setVisibility(View.INVISIBLE);

        refresh();
    }

    private void refresh(){
        QuestionsArray.getInstance();
        if(QuestionsArray.selected=="All"){
            Random ran = new Random();
            int randomquestion = ran.nextInt(QuestionsArray.all_questions.length);
            question =QuestionsArray.all_questions[randomquestion];
            question_text.setText(question.getQuestion());

            String[] ansArr=question.shuffleAnswerArray();
            ans1.setText(ansArr[0]);
            ans2.setText(ansArr[1]);
            ans3.setText(ansArr[2]);
        }
        else if(QuestionsArray.selected=="C++"){
            Random ran = new Random();
            int randomquestion = ran.nextInt(QuestionsArray.cpp_questions.length);
            question =QuestionsArray.cpp_questions[randomquestion];
            question_text.setText(question.getQuestion());

            String[] ansArr=question.shuffleAnswerArray();
            ans1.setText(ansArr[0]);
            ans2.setText(ansArr[1]);
            ans3.setText(ansArr[2]);
        }
        else if(QuestionsArray.selected=="Python"){
            Random ran = new Random();
            int randomquestion = ran.nextInt(QuestionsArray.python_questions.length);
            question =QuestionsArray.python_questions[randomquestion];
            question_text.setText(question.getQuestion());

            String[] ansArr=question.shuffleAnswerArray();
            ans1.setText(ansArr[0]);
            ans2.setText(ansArr[1]);
            ans3.setText(ansArr[2]);
        }
        else if(QuestionsArray.selected=="Java"){
            Random ran = new Random();
            int randomquestion = ran.nextInt(QuestionsArray.java_questions.length);
            question =QuestionsArray.java_questions[randomquestion];
            question_text.setText(question.getQuestion());

            String[] ansArr=question.shuffleAnswerArray();
            ans1.setText(ansArr[0]);
            ans2.setText(ansArr[1]);
            ans3.setText(ansArr[2]);
        }

        radioGroup.clearCheck();


        scoreText.setTextSize(20);
        Score.getInstance();
        scoreText.setText("Score: " + Score.quick_point);

        Score.getInstance();
        SharedPreferences prefs = getSharedPreferences("myPrefsKey", MODE_PRIVATE);
        Score.quickplay_highscore = prefs.getInt("QuickPlay Highscore", 0);
        quickplayHighscore.setText("QuickPlay Highscore: "+Score.quickplay_highscore);
    }

    public void onSubmit(View view) {
        if(ans1.isChecked()){
            if(ans1.getText()==question.getReal_answer()){
                Toast.makeText(getApplicationContext(), "Correct! +1 Score", Toast.LENGTH_SHORT).show();
                Score.quick_point += 1;
                if (Score.quick_point>Score.quickplay_highscore){
                    Score.quickplay_highscore=Score.quick_point;
                    SharedPreferences prefs = getSharedPreferences("myPrefsKey", MODE_PRIVATE);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putInt("QuickPlay Highscore", Score.quickplay_highscore);
                    editor.commit();
                }
                refresh();
                submitPng.setVisibility(View.INVISIBLE);
            }
            else{
                dialogAlert();
            }
        }
        else if(ans2.isChecked()){
            if(ans2.getText()==question.getReal_answer()){
                Toast.makeText(getApplicationContext(), "Correct! +1 Score", Toast.LENGTH_SHORT).show();
                Score.quick_point += 1;
                if (Score.quick_point>Score.quickplay_highscore){
                    Score.quickplay_highscore=Score.quick_point;
                    SharedPreferences prefs = getSharedPreferences("myPrefsKey", MODE_PRIVATE);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putInt("QuickPlay Highscore", Score.quickplay_highscore);
                    editor.commit();
                }
                refresh();
                submitPng.setVisibility(View.INVISIBLE);
            }
            else{
                dialogAlert();
            }
        }
        else if(ans3.isChecked()){
            if(ans3.getText()==question.getReal_answer()){
                Toast.makeText(getApplicationContext(), "Correct! +1 Score", Toast.LENGTH_SHORT).show();
                Score.quick_point += 1;
                if (Score.quick_point>Score.quickplay_highscore){
                    Score.quickplay_highscore=Score.quick_point;
                    SharedPreferences prefs = getSharedPreferences("myPrefsKey", MODE_PRIVATE);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putInt("QuickPlay Highscore", Score.quickplay_highscore);
                    editor.commit();
                }
                refresh();
                submitPng.setVisibility(View.INVISIBLE);
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

        AlertDialog gameEndDialog = new AlertDialog.Builder(QuickPlay.this).create();
        gameEndDialog.setTitle("You Lost!");
        gameEndDialog.setCanceledOnTouchOutside(false);
        gameEndDialog.setMessage("Here is your score: " + Score.quick_point);
        gameEndDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Take Me to Main Menu",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        Score.quick_point = 0;
                        Intent act_action = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(act_action);
                    }
                });
        gameEndDialog.show();

    }
}
