package com.example.codingtrivia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
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

        submitPng.setVisibility(View.INVISIBLE);

        QuestionsArray.getInstance();
        Random ran = new Random();
        int randomquestion = ran.nextInt(QuestionsArray.questions_array.length);
        question =QuestionsArray.questions_array[randomquestion];
        question_text.setText(question.getQuestion());

        String[] ansArr=question.shuffleAnswerArray();
        ans1.setText(ansArr[0]);
        ans2.setText(ansArr[1]);
        ans3.setText(ansArr[2]);
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
                refresh();
            }
        }
        else if(ans2.isChecked()){
            if(ans2.getText()==question.getReal_answer()){
                Toast.makeText(getApplicationContext(), "Correct! +1 Score", Toast.LENGTH_SHORT).show();
                refresh();
            }
        }
        else if(ans3.isChecked()){
            if(ans3.getText()==question.getReal_answer()){
                Toast.makeText(getApplicationContext(), "Correct! +1 Score", Toast.LENGTH_SHORT).show();
                refresh();
            }
        }
        scoreText.setTextSize(15);
        scoreText.setText("TODO: Implement wrong answer (game ending) and increment score.");

    }

    public void onCheck(View view) {
        submitPng.setVisibility(View.VISIBLE);
    }
}
