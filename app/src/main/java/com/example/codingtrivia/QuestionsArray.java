package com.example.codingtrivia;

public class QuestionsArray {
    private static QuestionsArray QUESTIONS=null;
    public static Questions[] questions_array;

    public QuestionsArray(){
        questions_array=new Questions[15];

        Questions q;

        q=new Questions(QType.Python,"What is a correct syntax to output \"Hello World\" in Python?","p(\"Hello World\")","echo(\"Hello World\");","print(\"Hello World\")","print(\"Hello World\")");
        questions_array[0]=q;

        q=new Questions(QType.Python,"How do you insert COMMENTS in Python code?"," #This is a comment"," /*This is a comment*/"," //This is a comment"," #This is a comment");
        questions_array[1]=q;

        q=new Questions(QType.Python,"Which one is NOT a legal variable name?","my-var","_myvar","my_var","my-var");
        questions_array[2]=q;

        q=new Questions(QType.Python,"How do you create a variable with the numeric value 5?","x = int(5)","x = 5","Both the other answers are correct","Both the other answers are correct");
        questions_array[3]=q;

        q=new Questions(QType.Python,"What is the correct file extension for Python files?",".pyth",".pyt",".py",".py");
        questions_array[4]=q;

        q=new Questions(QType.Cpp,"Choose the operator which cannot be overloaded.","/","()","::","::");
        questions_array[5]=q;

        q=new Questions(QType.Cpp,"A user defined header file is included by following statement in general.","#include “file.h\""," #include <file.h>","#include <file>","#include “file.h\"");
        questions_array[6]=q;

        q=new Questions(QType.Cpp,"Class function which is called automatically as soon as the object is created is called as __","Constructor","Destructor","Friend function","Constructor");
        questions_array[7]=q;

        q=new Questions(QType.Cpp,"Objects created using new operator are stored in __ memory.","Cache","Heap","Stack","Heap");
        questions_array[8]=q;

        q=new Questions(QType.Cpp,"A C++ program statements can be commented using","Single line comment","Multi line comment","Both (a) and (b).","Both (a) and (b).");
        questions_array[9]=q;

        q=new Questions(QType.Java,"What is the default value of byte variable?","0","0.0","null","0");
        questions_array[10]=q;

        q=new Questions(QType.Java,"java.util.Collections is a:","Class","Interface","Object","Class");
        questions_array[11]=q;

        q=new Questions(QType.Java,"Which of those allows duplicate elements?","Set","List","All","List");
        questions_array[12]=q;

        q=new Questions(QType.Java,"Which of those doesn’t have an index based structure?","List","Set","Map","Set");
        questions_array[13]=q;

        q=new Questions(QType.Java,"Which allows the storage of a null key and null values?","Hashtable","HashMap","None of the above","HashMap");
        questions_array[14]=q;

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
