package com.example.fleetmanagement;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DisplayData extends AppCompatActivity {
    Button showDataBtn,cancelBtn;
    SQLiteDatabase myDB;
    DatabaseHelper myhelper;
    Cursor mycursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_data);
        showDataBtn=findViewById(R.id.shButton);
        cancelBtn=findViewById(R.id.cButton);
        myhelper=new DatabaseHelper(this);
        myDB=myhelper.getWritableDatabase();
        showDataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mycursor=myDB.rawQuery("select * from "+DatabaseHelper.TABLENAME,null);
                if(mycursor.getCount()==0)
                {
                    Toast.makeText(getApplicationContext(), "No data", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Data found", Toast.LENGTH_SHORT).show();
                    StringBuffer myBuffer= new StringBuffer();
                    while (mycursor.moveToNext()){
                        myBuffer.append("userId" + mycursor.getString(0)+ "\n");
                        myBuffer.append("fullname" + mycursor.getString(1)+ "\n");
                        myBuffer.append("email" + mycursor.getString(2)+ "\n");
                        myBuffer.append("phoneNumber" + mycursor.getString(3)+ "\n");
                        myBuffer.append("password" + mycursor.getString(4)+ "\n");

                    }
                    mycursor.close();
                    Showdata("Data",myBuffer.toString());
                }
            }
        });

    }
    public void Showdata (String title, String message)
    {
        AlertDialog.Builder mybuilder=new AlertDialog.Builder(this);
        mybuilder.setCancelable(true);
        mybuilder.setTitle(title);
        mybuilder.setMessage(message);
        mybuilder.show();
    }
    public void onCancel(View View){finish();}
}