package com.example.codingtrivia;

import java.util.Arrays;

public class QuestionsArray {
    private static QuestionsArray QUESTIONS=null;
    public static Questions[] all_questions;
    public static Questions[] java_questions;
    public static Questions[] python_questions;
    public static Questions[] cpp_questions;
    public static Questions[] bing_questions;
    public static String selected="All";

    public QuestionsArray(){
        java_questions=new Questions[5];
        python_questions=new Questions[5];
        cpp_questions=new Questions[5];
        bing_questions=new Questions[10];
        all_questions=new Questions[15];

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

        q=new Questions(QType.Python,"A continuation loop can be converted to a for loop?","True","False"," ","True");
        python_questions[5]=q;

        q=new Questions(QType.Python,"Which of the following functions would NOT require an argument?","sum()","random()","type()","random()");
        python_questions[6]=q;

        q=new Questions(QType.Python,"Given the following expression: \n (status_light1 or status_light2) \n if status_light1 is True, then the entire expression is True","True","False"," ","True");
        python_questions[7]=q;

        q=new Questions(QType.Python,"Which can NOT be returned by a function with the keyword “return”?","a negative number","a positive number","all of the above","all of the above");
        python_questions[8]=q;


        q=new Questions(QType.Python,"What can cause an infinite loop?","Forgetting to update the control variable","Updating the control variable incorrectly","All of the above","All of the above");
        python_questions[9]=q;

        q=new Questions(QType.Python,"Which of the following methods give access to the element of the list which  is removed?","del","remove()","pop()","pop()");
        python_questions[10]=q;

        q=new Questions(QType.Python,"It is permitted to have a list as an element in a list.","True","False"," ","True");
        python_questions[11]=q;

        q=new Questions(QType.Python,"Given may = 'isolated', which of the following would return the full string?","may[:]","may[1:10]","may[2:]","may[:]");
        python_questions[12]=q;

        q=new Questions(QType.Python,"Which can be used as a sequence in a for loop?","a string","a list","All of the above","All of the above");
        python_questions[13]=q;

        q=new Questions(QType.Python,"Which of the following could be used to generate a list (i.e., type of  <class 'list'>)? ","[]","split()","All of the above","All of the above");
        python_questions[14]=q;

        q=new Questions(QType.Python,"You can loop through a dictionary with two iteration variables in the same loop by invoking the items() method on the dictionary.","True","False"," ","True");
        python_questions[15]=q;

        q=new Questions(QType.Python,"Which of the following is NOT a collection type?","a tuple","an expression","a list","an expression");
        python_questions[16]=q;


        q=new Questions(QType.Python,"What do dictionaries use in order to access their data?","keys that are immutable","a list of tuples","integers indexes beginning at 0","keys that are immutable");
        python_questions[17]=q;

        q=new Questions(QType.Python,"If word = “puppy”, what is the value of word[4]? ","p","y","u","y");
        python_questions[18]=q;

        q=new Questions(QType.Python,"What does the list method append() do?","adds an item to the end of a list","creates a new list in place of the first item","replaces the first item of a list with a new item","adds an item to the end of a list");
        python_questions[19]=q;

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




        q=new Questions(QType.Python,"What is a correct syntax to output \"Hello World\" in Python?","p(\"Hello World\")","echo(\"Hello World\");","print(\"Hello World\")","print(\"Hello World\")");
        all_questions[0]=q;

        q=new Questions(QType.Python,"How do you insert COMMENTS in Python code?"," #This is a comment"," /*This is a comment*/"," //This is a comment"," #This is a comment");
        all_questions[1]=q;

        q=new Questions(QType.Python,"Which one is NOT a legal variable name?","my-var","_myvar","my_var","my-var");
        all_questions[2]=q;

        q=new Questions(QType.Python,"How do you create a variable with the numeric value 5?","x = int(5)","x = 5","Both the other answers are correct","Both the other answers are correct");
        all_questions[3]=q;

        q=new Questions(QType.Python,"What is the correct file extension for Python files?",".pyth",".pyt",".py",".py");
        all_questions[4]=q;

        q=new Questions(QType.Cpp,"Choose the operator which cannot be overloaded.","/","()","::","::");
        all_questions[5]=q;

        q=new Questions(QType.Cpp,"A user defined header file is included by following statement in general.","#include “file.h\""," #include <file.h>","#include <file>","#include “file.h\"");
        all_questions[6]=q;

        q=new Questions(QType.Cpp,"Class function which is called automatically as soon as the object is created is called as __","Constructor","Destructor","Friend function","Constructor");
        all_questions[7]=q;

        q=new Questions(QType.Cpp,"Objects created using new operator are stored in __ memory.","Cache","Heap","Stack","Heap");
        all_questions[8]=q;

        q=new Questions(QType.Cpp,"A C++ program statements can be commented using","Single line comment","Multi line comment","Both (a) and (b).","Both (a) and (b).");
        all_questions[9]=q;

        q=new Questions(QType.Java,"What is the default value of byte variable?","0","0.0","null","0");
        all_questions[10]=q;

        q=new Questions(QType.Java,"java.util.Collections is a:","Class","Interface","Object","Class");
        all_questions[11]=q;

        q=new Questions(QType.Java,"Which of those allows duplicate elements?","Set","List","All","List");
        all_questions[12]=q;

        q=new Questions(QType.Java,"Which of those doesn’t have an index based structure?","List","Set","Map","Set");
        all_questions[13]=q;

        q=new Questions(QType.Java,"Which allows the storage of a null key and null values?","Hashtable","HashMap","None of the above","HashMap");
        all_questions[14]=q;

        q=new Questions(QType.Python,"A continuation loop can be converted to a for loop?","True","False"," ","True");
        all_questions[15]=q;

        q=new Questions(QType.Python,"Which of the following functions would NOT require an argument?","sum()","random()","type()","random()");
        all_questions[16]=q;

        q=new Questions(QType.Python,"Given the following expression: \n(status_light1 or status_light2) \n if status_light1 is True, then the entire expression is True","True","False"," ","True");
        all_questions[17]=q;

        q=new Questions(QType.Python,"Which can NOT be returned by a function with the keyword “return”?","a negative number","a positive number","all of the above","all of the above");
        all_questions[18]=q;


        q=new Questions(QType.Python,"What can cause an infinite loop?","Forgetting to update the control variable","Updating the control variable incorrectly","All of the above","All of the above");
        all_questions[19]=q;

        q=new Questions(QType.Python,"Which of the following methods give access to the element of the list which  is removed?","del","remove()","pop()","pop()");
        all_questions[20]=q;

        q=new Questions(QType.Python,"It is permitted to have a list as an element in a list.","True","False"," ","True");
        all_questions[21]=q;

        q=new Questions(QType.Python,"Given may = 'isolated', which of the following would return the full string?","may[:]","may[1:10]","may[2:]","may[:]");
        all_questions[22]=q;

        q=new Questions(QType.Python,"Which can be used as a sequence in a for loop?","a string","a list","All of the above","All of the above");
        all_questions[23]=q;

        q=new Questions(QType.Python,"Which of the following could be used to generate a list (i.e., type of  <class 'list'>)? ","[]","split()","All of the above","All of the above");
        all_questions[24]=q;

        q=new Questions(QType.Python,"You can loop through a dictionary with two iteration variables in the same loop by invoking the items() method on the dictionary.","True","False"," ","True");
        all_questions[25]=q;

        q=new Questions(QType.Python,"Which of the following is NOT a collection type?","a tuple","an expression","a list","an expression");
        all_questions[26]=q;


        q=new Questions(QType.Python,"What do dictionaries use in order to access their data?","keys that are immutable","a list of tuples","integers indexes beginning at 0","keys that are immutable");
        all_questions[27]=q;

        q=new Questions(QType.Python,"If word = “puppy”, what is the value of word[4]? ","p","y","u","y");
        all_questions[28]=q;

        q=new Questions(QType.Python,"What does the list method append() do?","adds an item to the end of a list","creates a new list in place of the first item","replaces the first item of a list with a new item","adds an item to the end of a list");
        all_questions[29]=q;

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
