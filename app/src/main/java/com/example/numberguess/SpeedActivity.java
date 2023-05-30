package com.example.numberguess;

import androidx.appcompat.app.AppCompatActivity;
import static com.example.numberguess.DifficultyActivity.algorithm;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SpeedActivity extends AppCompatActivity
{
    private TextView countdownText;
    private Button countdownButton;

    private CountDownTimer countDownTimer;
    private long timeLeftInMilliseconds = 30000;
    private boolean timerRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speed);

        countdownText = findViewById(R.id.countDownTimer);
        countdownButton = findViewById(R.id.confirmSpeedButton);

        countdownButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startTimer();
                checkWin();
            }
        });
    }

    public void startTimer()
    {
        countDownTimer = new CountDownTimer(timeLeftInMilliseconds, 1000) {
            @Override
            public void onTick(long l) {
                timeLeftInMilliseconds = l;
                updateTimer();
            }

            @Override
            public void onFinish()
            {
                algorithm.setGuessesLeft(0);
                startActivity(new Intent(SpeedActivity.this, OutcomeActivity.class));
            }
        }.start();
    }

    public void updateTimer()
    {
        int minutes = (int) timeLeftInMilliseconds / 60000;
        int seconds = (int) timeLeftInMilliseconds % 60000 / 1000;

        String timeLeftText;

        timeLeftText = " " + minutes;
        timeLeftText += ":";
        if (seconds < 10) timeLeftText += "0";
        timeLeftText += seconds;

        countdownText.setText(timeLeftText);
    }

    public void checkWin()
    {
        EditText answerView = findViewById(R.id.answerBoxSpeed);
        String aS = answerView.getText().toString();

        int aI = NumberGuessAlgorithm.toInt(aS);

        boolean outcome;

        outcome = algorithm.checkUserGuess(aI);

        if (outcome)
        {
            algorithm.setTimeLeft((int) timeLeftInMilliseconds % 60000 / 1000);
            startActivity(new Intent(SpeedActivity.this, OutcomeActivity.class));
        }

    }


}