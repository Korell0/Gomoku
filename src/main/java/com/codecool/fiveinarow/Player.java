package com.codecool.fiveinarow;

public class Player {

    //private String name;
    private int score = 0;

    public Player(){
       // this.name = name;

    }
    /*
    public String getPlayerName(){
        return name;
    }
*/
    public int getPlayerScore(){
        return score;
    }

    public void increaseScore(){
        this.score += 1;
    }
}
