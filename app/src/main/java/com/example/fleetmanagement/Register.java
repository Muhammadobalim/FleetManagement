package com.example.fleetmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    EditText fullname,email,phoneNumber,password;
    Button RegisterBtn;
    DatabaseHelper myhelper;
    SQLiteDatabase myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        fullname=findViewById(R.id.fullname);
        email=findViewById(R.id.Email);
        phoneNumber=findViewById(R.id.phoneNumber);
        password=findViewById(R.id.password);
        RegisterBtn=(Button) findViewById(R.id.reg_btn);
        myhelper=new DatabaseHelper(this);
        myDB=myhelper.getWritableDatabase();
        RegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fullnamestring=fullname.getText().toString();
                String emailString=email.getText().toString();
                String phoneNumberstring=phoneNumber.getText().toString();
                String passwordstring=password.getText().toString();


                ContentValues myvalues=new ContentValues();
                myvalues.put(DatabaseHelper.COLUMNTWO,fullnamestring);
                myvalues.put(DatabaseHelper.COLUMNTHREE,emailString);
                myvalues.put(DatabaseHelper.COLUMNFOUR,phoneNumberstring);
                myvalues.put(DatabaseHelper.COLUMNFIVE,passwordstring);
                myDB.insert(DatabaseHelper.TABLENAME,null,myvalues);
                Toast.makeText(getApplicationContext(),"Record Added", Toast.LENGTH_LONG).show();
            }
        });

    }
}