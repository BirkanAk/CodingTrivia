package com.example.codingtrivia;

public class Score {
    private static Score SCORE=null;
    public static int point =0;
    public static int highscore=0;


    public static Score getInstance(){
        if(Score.SCORE==null){
            Score.SCORE=new Score();
        }
        return Score.SCORE;
    }
}