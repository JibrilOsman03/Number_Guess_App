package com.example.numberguess;

import static com.example.numberguess.DifficultyActivity.algorithm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class GuessActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess);

        TextView guessLeftView = findViewById(R.id.guessesLeftNumber);
        String guessesLeftString = Integer.valueOf(algorithm.getGuessesLeft()).toString();
        guessLeftView.setText(guessesLeftString);
    }

    public void buttonClicked(View v)
    {
        EditText answerView = findViewById(R.id.answerBox);
        String aS = answerView.getText().toString();

        int aI = NumberGuessAlgorithm.toInt(aS);

        boolean outcome;

        outcome = algorithm.checkUserGuess(aI);

        if (outcome)
        {
            startActivity(new Intent(GuessActivity.this, OutcomeActivity.class));
        }
        else
        {
            if(algorithm.getGuessesLeft() > 0)
            {
                TextView guessLeftView = findViewById(R.id.guessesLeftNumber);
                String guessesLeftString = Integer.valueOf(algorithm.getGuessesLeft()).toString();
                guessLeftView.setText(guessesLeftString);
            }
            else
            {
                startActivity(new Intent(GuessActivity.this, OutcomeActivity.class));
            }
        }
    }

}