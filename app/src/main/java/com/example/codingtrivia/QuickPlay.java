package com.example.codingtrivia;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

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

        submitPng.setVisibility(View.INVISIBLE);

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
        scoreText.setText("Score: " + Score.quick_point);
    }

    public void onSubmit(View view) {
        if(ans1.isChecked()){
            if(ans1.getText()==question.getReal_answer()){
                Toast.makeText(getApplicationContext(), "Correct! +1 Score", Toast.LENGTH_SHORT).show();
                Score.quick_point += 1;
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
