package com.example.numberguess;

import androidx.appcompat.app.AppCompatActivity;
import static com.example.numberguess.DifficultyActivity.algorithm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class InputRangeActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_range);

        configureBackButton();
        configureConfirmButton();

        TextView gameModeView = findViewById(R.id.gameMode);

        gameModeView.setText(algorithm.getMode());
    }

    private void configureBackButton()
    {
        Button BackButton = findViewById(R.id.backButtonRange);
        BackButton.setOnClickListener(view -> finish());
    }

    private void configureConfirmButton()
    {
        Button ConfirmButton = findViewById(R.id.confirmButton);
        ConfirmButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(android.view.View v){
                EditText range = findViewById(R.id.rangeBox);
                String ranges = range.getText().toString();
                int rangeInt = Integer.parseInt(ranges);
                if (rangeInt > 10)
                {
                    algorithm.guessAmount(rangeInt);

                    if(!algorithm.getIsSpeed())
                    {
                        startActivity(new Intent(InputRangeActivity.this, GuessActivity.class));
                    }

                    if(algorithm.getIsSpeed())
                    {
                        startActivity(new Intent(InputRangeActivity.this, SpeedActivity.class));
                    }
                }
            }
        });
    }
}