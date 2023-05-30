package com.example.numberguess;

import java.lang.Math;

public class NumberGuessAlgorithm {
    private int randomNumber = -1;
    private int guessesLeft;
    private boolean isSpeed;
    private String mode;
    private int timeLeft;
    private int range;

    //Object initializer
    //return chosen mode as a string

    public NumberGuessAlgorithm (String mode){
        //This code calculates how much guesses a user gets depending
        //on their difficulty choice
        this.timeLeft = 0;
        if (mode.equals("Easy")){
            this.guessesLeft = 10;
            this.isSpeed = false;
            this.mode = mode;
        }
        if (mode.equals("Medium")){
            this.guessesLeft = 5;
            this.isSpeed = false;
            this.mode = mode;
        }
        if (mode.equals("Hard")){
            this.guessesLeft = 3;
            this.isSpeed = false;
            this.mode = mode;
        }
        if (mode.equals("Speed")) {
            this.guessesLeft = 100;
            this.isSpeed = true;
            this.mode = mode;
        }
    }

    //This line calculates the value of the random number
    public void guessAmount(int x){
        this.range = x;
        this.randomNumber = (int) (Math.random() * (x)) + 1;
    }

    //This line checks if the user guesses the correct number
    public boolean checkUserGuess(int guess){
        if (guess == this.randomNumber) {
            if (!this.isSpeed)
                this.guessesLeft--;
            return true;
        }
        else{
            if (!this.isSpeed)
                this.guessesLeft--;
            return false;
        }
    }

    public void setGuessesLeft(int guessesLeft)
    {
        this.guessesLeft = guessesLeft;
    }

    public void setMode(String mode)
    {
        this.mode = mode;
    }

    public int getRandomNumber()
    {
        return this.randomNumber;
    }


    public String getMode(){
        return this.mode;
    }

    //This line returns how many guesses are left
    public int getGuessesLeft(){
        return  this.guessesLeft;
    }

    public boolean getIsSpeed()
    {
        return this.isSpeed;
    }

    public void setTimeLeft(int time){
        this.timeLeft = time;
    }

    public int getTimeLeft(){
        return this.timeLeft;
    }

    public static int toInt(String s)
    {
        return Integer.parseInt(s);
    }

    public int getRange(){
        return this.range;
    }
}
