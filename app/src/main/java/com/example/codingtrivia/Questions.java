package com.example.codingtrivia;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

enum QType{
    Python,
    Cpp,
    Java
}

public class Questions {
    private String question,answer1,answer2,answer3,real_answer;
    private QType qType;

    public Questions(QType qType,String question,String answer1,String answer2, String answer3, String real_answer){
        this.qType=qType;
        this.question=question;
        this.answer1=answer1;
        this.answer2=answer2;
        this.answer3=answer3;
        this.real_answer=real_answer;
    }

    public String getQuestion(){
        return question;
    }

    public String getAnswer1() {
        return answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public String getReal_answer() {
        return real_answer;
    }

    public QType getqType() {
        return qType;
    }
    public String[] shuffleAnswerArray()
    {
        String[] answerArray = {answer1,answer2,answer3};
        Collections.shuffle(Arrays.asList(answerArray));
        return answerArray;

    }
}
