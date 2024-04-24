package com.example.radiobutton;

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
    RadioGroup radioGroup;
    RadioButton radioButton;
    EditText editText,ansEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroupId);
        button = (Button) findViewById(R.id.btn);
        ansEditText = (EditText) findViewById(R.id.ans);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int selectedId = radioGroup.getCheckedRadioButtonId();
                radioButton = (RadioButton) findViewById(selectedId);
                if(selectedId == -1){
                    Toast.makeText(MainActivity.this,"Nothing selected", Toast.LENGTH_SHORT).show();
                }else{

                    String selectedOption =(String) radioButton.getText();
                    editText = (EditText) findViewById(R.id.editText1);
                    int num = Integer.parseInt(editText.getText().toString());
                    switch (selectedOption){
                        case "Odd or Even":
                            if (checkOddOrEven(num)){
                                ansEditText.setText("Even");
                            }else{
                                ansEditText.setText("Odd");
                            }
                            break;
                        case "Positive or Negative":
                           if (checkPositiveOrNegative(num)){
                               ansEditText.setText("Positive");
                           }else{
                               ansEditText.setText("Negative");
                           }
                            break;
                        case "Square":
                             int res=  findSquare(num);

                             editText.setText(res);
                                break;
                        case "Factorial":
                           int fact = findFactorial(num);
                           ansEditText.setText(String.valueOf(fact));
                            break;
                    }


                }
            }
        });
    }

    public static boolean checkOddOrEven( int num){
            if (num % 2 == 0){
                return  true;
            }else{
                return  false;
            }
    }

    public static boolean checkPositiveOrNegative( int num){
            if (num > 0){
                return true;
            }
            return false;
    }

    public static int findSquare( int num){
        return  num * num;
    }

    public static int findFactorial( int num){
        int fact = 0;
        for (int i = num; i > 0 ; i--) {
            fact = fact * i;
        }
        return  fact;
    }
}