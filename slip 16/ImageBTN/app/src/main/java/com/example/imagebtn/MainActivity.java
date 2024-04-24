package com.example.imagebtn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editTextNumber1, editTextNumber2;
    private ImageButton button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNumber1 = findViewById(R.id.editTextNumber1);
        editTextNumber2 = findViewById(R.id.editTextNumber2);

        button = (ImageButton) findViewById(R.id.imageButtonCalculate);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double number1 = Double.parseDouble(editTextNumber1.getText().toString());
                double number2 = Double.parseDouble(editTextNumber2.getText().toString());

                double power = Math.pow(number1,number2);
                double average = (number1 + number2) / 2;

                Intent intent = new Intent(getApplicationContext(),MainActivity2.class);
                intent.putExtra("power", power);
                intent.putExtra("average", average);
                startActivity(intent);

            }
        });
    }
}