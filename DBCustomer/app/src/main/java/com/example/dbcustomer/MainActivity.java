package com.example.dbcustomer;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private DbManager dbManager;
    EditText studentName,studentAddress,studentPhoNo;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbManager = new DbManager(this);
        studentName = (EditText) findViewById(R.id.editTextName);
        studentAddress = (EditText) findViewById(R.id.editTextAddress);
        studentPhoNo = (EditText) findViewById(R.id.editTextPhno);


    }

    public void addStudent(View view) {
//            Toast.makeText(MainActivity.this,">>>",Toast.LENGTH_SHORT).show();
            String name = studentName.getText().toString();
            String address = studentAddress.getText().toString();
            String pho_no= studentPhoNo.getText().toString();
            long newRowId =  dbManager.insert(name,address,pho_no);
            if (newRowId != -1) {
                showToast("Student inserted successfully, ID: " + newRowId);
            } else {
                showToast("Error inserting student.");
            }
        }

    public void getStudents(View view) {
        Cursor cursor = dbManager.getAllStudents();
        StringBuilder studentsDetails = new StringBuilder();
        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") int sid = cursor.getInt(cursor.getColumnIndex(DbManager.));
                @SuppressLint("Range") String sname = cursor.getString(cursor.getColumnIndex(dbManager.na);
                studentsDetails.append("SID: ").append(sid).append(", Name: ").append(sname).append("\n");
            } while (cursor.moveToNext());
        }
        cursor.close();
        showToast(studentsDetails.toString());
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}