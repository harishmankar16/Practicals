package com.example.imagebtn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView textViewPower = findViewById(R.id.textViewPower);
        TextView textViewAverage = findViewById(R.id.textViewAverage);

        double power = getIntent().getDoubleExtra("power", 0);
        double average = getIntent().getDoubleExtra("average", 0);

        textViewPower.setText("Power: " + power);
        textViewAverage.setText("Average: " + average);

    }
}