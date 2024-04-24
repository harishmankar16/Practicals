package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button;
    EditText email,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email=(EditText) findViewById(R.id.email);
        password=(EditText) findViewById(R.id.password);
        button = (Button) findViewById(R.id.btn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String eMail = email.getText().toString();
                String Password = password.getText().toString();
                String my="test@gmail.com";
                System.out.println(">>>>>>>"+eMail.equals(my));
                if (eMail.equals(my)){
                    Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                    intent.putExtra("user",eMail);
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this,"Invalid",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}