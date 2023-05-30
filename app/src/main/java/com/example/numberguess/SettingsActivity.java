package com.example.numberguess;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        configureBackButton();
    }

    private void configureBackButton()
    {
        Button backButton = findViewById(R.id.backButtonSettings);
        backButton.setOnClickListener(view -> finish());
    }
}