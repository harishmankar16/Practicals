package com.example.intentforemployee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText firstName,middleName,lastname,salary,address,email;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.btn);
        firstName = (EditText) findViewById(R.id.firstName);
        lastname = (EditText) findViewById((R.id.lastname));
        middleName = (EditText) findViewById(R.id.middleName);
        salary = (EditText) findViewById(R.id.salary);
        address = (EditText) findViewById(R.id.address);
        email = (EditText) findViewById(R.id.email);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fname=firstName.getText().toString();
                String lname = lastname.getText().toString();
                String mname = middleName.getText().toString();
                String sal = salary.getText().toString();
                String add =address.getText().toString();
                String eId = email.getText().toString();

                Intent intent = new Intent(getApplicationContext(),MainActivity2.class);
                intent.putExtra("firstname", fname);
                intent.putExtra("lastname", lname);
                intent.putExtra("middlename", mname);
                intent.putExtra("salary", sal);
                intent.putExtra("address", add);
                intent.putExtra("email", eId);

                startActivity(intent);
            }
        });
    }
}