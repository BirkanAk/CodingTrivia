package com.example.codingtrivia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.Random;

public class QuickPlay extends AppCompatActivity {
    TextView question_text;
    RadioButton ans1;
    RadioButton ans2;
    RadioButton ans3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick_play);

        question_text=(TextView)findViewById(R.id.question_text);
        ans1=(RadioButton)findViewById(R.id.ans1_radio);
        ans2=(RadioButton)findViewById(R.id.ans2_radio);
        ans3=(RadioButton)findViewById(R.id.ans3_radio);

        QuestionsArray.getInstance();
        Random ran = new Random();
        int randomquestion = ran.nextInt(QuestionsArray.questions_array.length);
        Questions q =QuestionsArray.questions_array[randomquestion];
        question_text.setText(q.getQuestion());

        String[] ansArr=q.shuffleAnswerArray();
        ans1.setText(ansArr[0]);
        ans2.setText(ansArr[1]);
        ans3.setText(ansArr[2]);
    }



    public void onGoBackClick(View view) {
        Intent act_action = new Intent(this, MainActivity.class);
        startActivity(act_action);
    }
}
