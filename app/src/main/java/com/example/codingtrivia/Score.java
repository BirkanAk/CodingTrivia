package com.example.codingtrivia;

public class Score {
    private static Score SCORE=null;
    public static int advanced_point =0;
    public static int time_point =0;
    public static int quick_point =0;
    public static int advanced_highscore=0;
    public static int time_highscore=0;
    public static int quickplay_highscore=0;

    public static Score getInstance(){
        if(Score.SCORE==null){
            Score.SCORE=new Score();
        }
        return Score.SCORE;
    }
}
