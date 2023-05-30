package com.example.numberguess;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DifficultyActivity extends AppCompatActivity
{
    public static NumberGuessAlgorithm algorithm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty);

        configureEasyButton();
        configureMediumButton();
        configureHardButton();
        configureSpeedButton();
        configureBackButton();
    }

    private void configureEasyButton()
    {
        Button easyButton = findViewById(R.id.easyButton);
        easyButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(android.view.View v){
                algorithm = new NumberGuessAlgorithm("Easy");
                startActivity(new Intent(DifficultyActivity.this, InputRangeActivity.class));
            }
        });
    }

    private void configureMediumButton()
    {
        Button mediumButton = findViewById(R.id.mediumButton);
        mediumButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(android.view.View v){
                algorithm = new NumberGuessAlgorithm("Medium");
                startActivity(new Intent(DifficultyActivity.this, InputRangeActivity.class));
            }
        });
    }

    private void configureHardButton()
    {
        Button hardButton = findViewById(R.id.hardButton);
        hardButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(android.view.View v){
                algorithm = new NumberGuessAlgorithm("Hard");
                startActivity(new Intent(DifficultyActivity.this, InputRangeActivity.class));
            }
        });
    }

    private void configureSpeedButton()
    {
        Button speedButton = findViewById(R.id.speedButton);
        speedButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(android.view.View v){
                algorithm = new NumberGuessAlgorithm("Speed");
                startActivity(new Intent(DifficultyActivity.this, InputRangeActivity.class));
            }
        });
    }

    private void configureBackButton()
    {
        Button BackButton = findViewById(R.id.backButton);
        BackButton.setOnClickListener(view -> finish());
    }

}