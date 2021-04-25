package com.example.codingtrivia;

public class QuestionsArray {
    private static QuestionsArray QUESTIONS=null;
    public static Questions[] questions_array;

    public QuestionsArray(){
        questions_array=new Questions[1];

        Questions q;

        q=new Questions(QType.Python,"What is a correct syntax to output \"Hello World\" in Python?","p(\"Hello World\")","echo(\"Hello World\");","print(\"Hello World\")","print(\"Hello World\")");
        questions_array[0]=q;
    }


    public static QuestionsArray getInstance(){
        if(QuestionsArray.QUESTIONS==null){
            QuestionsArray.QUESTIONS=new QuestionsArray();
            return QuestionsArray.QUESTIONS;
        }else{
            return QuestionsArray.QUESTIONS;
        }

    }

}
