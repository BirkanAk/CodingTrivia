package com.example.codingtrivia;

public class QuestionsArray {
    private static QuestionsArray QUESTIONS=null;
    public static Questions[] java_questions;
    public static Questions[] python_questions;
    public static Questions[] cpp_questions;
    public static Questions[] bing_questions;
    public static String selected;

    public QuestionsArray(){
        java_questions=new Questions[5];
        python_questions=new Questions[5];
        cpp_questions=new Questions[5];
        bing_questions=new Questions[10];

        Questions q;

        q=new Questions(QType.Python,"What is a correct syntax to output \"Hello World\" in Python?","p(\"Hello World\")","echo(\"Hello World\");","print(\"Hello World\")","print(\"Hello World\")");
        python_questions[0]=q;

        q=new Questions(QType.Python,"How do you insert COMMENTS in Python code?"," #This is a comment"," /*This is a comment*/"," //This is a comment"," #This is a comment");
        python_questions[1]=q;

        q=new Questions(QType.Python,"Which one is NOT a legal variable name?","my-var","_myvar","my_var","my-var");
        python_questions[2]=q;

        q=new Questions(QType.Python,"How do you create a variable with the numeric value 5?","x = int(5)","x = 5","Both the other answers are correct","Both the other answers are correct");
        python_questions[3]=q;

        q=new Questions(QType.Python,"What is the correct file extension for Python files?",".pyth",".pyt",".py",".py");
        python_questions[4]=q;

        q=new Questions(QType.Cpp,"Choose the operator which cannot be overloaded.","/","()","::","::");
        cpp_questions[0]=q;

        q=new Questions(QType.Cpp,"A user defined header file is included by following statement in general.","#include “file.h\""," #include <file.h>","#include <file>","#include “file.h\"");
        cpp_questions[1]=q;

        q=new Questions(QType.Cpp,"Class function which is called automatically as soon as the object is created is called as __","Constructor","Destructor","Friend function","Constructor");
        cpp_questions[2]=q;

        q=new Questions(QType.Cpp,"Objects created using new operator are stored in __ memory.","Cache","Heap","Stack","Heap");
        cpp_questions[3]=q;

        q=new Questions(QType.Cpp,"A C++ program statements can be commented using","Single line comment","Multi line comment","Both (a) and (b).","Both (a) and (b).");
        cpp_questions[4]=q;

        q=new Questions(QType.Java,"What is the default value of byte variable?","0","0.0","null","0");
        java_questions[0]=q;

        q=new Questions(QType.Java,"java.util.Collections is a:","Class","Interface","Object","Class");
        java_questions[1]=q;

        q=new Questions(QType.Java,"Which of those allows duplicate elements?","Set","List","All","List");
        java_questions[2]=q;

        q=new Questions(QType.Java,"Which of those doesn’t have an index based structure?","List","Set","Map","Set");
        java_questions[3]=q;

        q=new Questions(QType.Java,"Which allows the storage of a null key and null values?","Hashtable","HashMap","None of the above","HashMap");
        java_questions[4]=q;

        q=new Questions(QType.Java,"Which company was founded in Endicott and maintained its R&D campus there until the early 1990s?","IBM","Apple","Amazon","IBM");
        bing_questions[0]=q;

        q=new Questions(QType.Java,"Who is the pioneer of television and creator of the Twilight Zone, grew up on Bennett Avenue on the West Side?(His house still looks creepy tbh)","David Fincher","Rod Sterling","Alfred Hitchcock","Rod Sterling");
        bing_questions[0]=q;

        q=new Questions(QType.Java," Who is the person that city is named after him? (Never visited Binghamton, but instead was simply a land speculator)","Bruce Wayne","Patrick Madden","William Bingham","William Bingham");
        bing_questions[0]=q;

        q=new Questions(QType.Java,"What is the default value of byte variable?","0","0.0","null","0");
        bing_questions[0]=q;

        q=new Questions(QType.Java,"What is the default value of byte variable?","0","0.0","null","0");
        bing_questions[0]=q;

        q=new Questions(QType.Java,"What is the default value of byte variable?","0","0.0","null","0");
        bing_questions[0]=q;

        q=new Questions(QType.Java,"What is the default value of byte variable?","0","0.0","null","0");
        bing_questions[0]=q;

        q=new Questions(QType.Java,"What is the default value of byte variable?","0","0.0","null","0");
        bing_questions[0]=q;

        q=new Questions(QType.Java,"What is the default value of byte variable?","0","0.0","null","0");
        bing_questions[0]=q;

        q=new Questions(QType.Java,"What is the default value of byte variable?","0","0.0","null","0");
        bing_questions[0]=q;

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
