package com.example.intentforemployee;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView firstName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Retrieve the Intent that started this activity
        Intent intent = getIntent();

        // Get the data passed through the Intent
        String fname = intent.getStringExtra("firstName");

        // Initialize EditText
        firstName = findViewById(R.id.firstName);

        // Set the text of EditText to the value retrieved from the Intent
        firstName.setText(fname);
    }
}
