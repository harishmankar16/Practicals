package com.example.registration;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText nameEditText, emailEditText, passwordEditText, ageEditText, mobileNoEditText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                nameEditText = (EditText) findViewById(R.id.name);
                emailEditText = (EditText) findViewById(R.id.email);
                passwordEditText = (EditText) findViewById(R.id.password);
                ageEditText = (EditText) findViewById(R.id.age);
                mobileNoEditText = (EditText) findViewById(R.id.mobileNo);

                String name = nameEditText.getText().toString();
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                String age = ageEditText.getText().toString();
                String mobile = mobileNoEditText.getText().toString();

                if (validate(name, email, password, age, mobile)) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage("Registration Succesfull");
                    builder.setTitle("Success");
                    // builder.setPositiveButton("yes")
                    builder.show();
                }

            }
        });

    }

    public boolean validate(String name, String email, String password, String age, String mobile) {
        if (name.isEmpty()) {
            Toast.makeText(MainActivity.this, "Name is required", Toast.LENGTH_LONG).show();
            return false;
        } else if (email.isEmpty()) {
            Toast.makeText(MainActivity.this, "Email is required", Toast.LENGTH_LONG).show();
            return false;
        } else if (password.isEmpty()) {
            Toast.makeText(MainActivity.this, "Password is required", Toast.LENGTH_LONG).show();
            return false;
        } else if (age.isEmpty()) {
            Toast.makeText(MainActivity.this, "Age is required", Toast.LENGTH_LONG).show();
            return false;
        } else if (mobile.isEmpty()) {
            Toast.makeText(MainActivity.this, "Mobile number is required", Toast.LENGTH_LONG).show();
            return false;
        }

        return true;
    }

}