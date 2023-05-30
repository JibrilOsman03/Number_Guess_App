package com.example.numberguess;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configureStartButton();
        configureSettingsButton();
        configureExitButton();
    }

    private void configureStartButton()
    {
        Button startButton = findViewById(R.id.startButton);
        startButton.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, DifficultyActivity.class)));
    }

    private void configureSettingsButton()
    {
        ImageButton settingsButton = findViewById(R.id.settingsButton);
        settingsButton.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, SettingsActivity.class)));
    }

    private void configureExitButton()
    {
        Button exitButton = findViewById(R.id.exitButton);
        exitButton.setOnClickListener(view -> finish());
    }
}