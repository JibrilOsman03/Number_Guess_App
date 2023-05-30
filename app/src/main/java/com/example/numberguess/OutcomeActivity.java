package com.example.numberguess;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.numberguess.DifficultyActivity.algorithm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OutcomeActivity extends AppCompatActivity {
    boolean victory = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outcome);
        configureBackButton();
        TextView outcomeView = findViewById(R.id.outcomeText);

        String outcomeString = "";

        if(algorithm.getGuessesLeft() == 0 && !algorithm.getIsSpeed())
            outcomeString = "YOU LOST!";
        else if (algorithm.getGuessesLeft() != 0 && !algorithm.getIsSpeed())
        {
            outcomeString = "YOU WON!";
            victory = true;
        }
        else if ((algorithm.getGuessesLeft() != 0 ) && (algorithm.getIsSpeed()))
        {
            outcomeString = "YOU WON!";
            victory = true;
        }
        else if (algorithm.getGuessesLeft() == 0 && algorithm.getIsSpeed())
            outcomeString = "YOU LOST!";

        outcomeView.setText(outcomeString);
    }
    private void configureBackButton()
    {
        Button goBackButton = findViewById(R.id.goBackButton);
        goBackButton.setOnClickListener(view -> startActivity(new Intent(OutcomeActivity.this, MainActivity.class)));
    }
}