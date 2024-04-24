package com.example.stringoperationsradiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button;
    EditText editText1,editText2;
    RadioButton radioButton;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.ans);
        button = (Button) findViewById(R.id.btn);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroupId);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                if (selectedId == -1){
                    Toast.makeText(MainActivity.this,"Nothing selected", Toast.LENGTH_SHORT).show();
                }else{
                    radioButton = (RadioButton) findViewById(selectedId);
                    String selectedOption = radioButton.getText().toString();
                    String enteredString = editText1.getText().toString();

                    switch (selectedOption){
                        case "UpperCase":
                            String uppercaseStr = enteredString.toUpperCase();
                            editText2.setText(uppercaseStr);
                            break;
                        case "LowerCase":
                            String lowercaseStr = enteredString.toLowerCase();
                            editText2.setText(lowercaseStr);
                            break;
                        case "Right 5 letters":
                            String leftSubstring = enteredString.substring(0, 5);
                            editText2.setText(leftSubstring);
                            break;
                        case "Left 5 Letters":
                            String rightSubstring = enteredString.substring(enteredString.length() - 5);
                            editText2.setText(rightSubstring);
                            break;
                    }
                }
            }
        });
    }
}