package com.example.fleetmanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Dashboard extends AppCompatActivity {
    CardView loginCard,showDataCard,registerCard,Logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        loginCard=findViewById(R.id.cardLogin);
        showDataCard=findViewById(R.id.cardShowData);
        registerCard=findViewById(R.id.cardShowData);
        Logout=findViewById(R.id.cardLogout);
        loginCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             Intent loginIntent=new Intent(getApplicationContext(),login.class);
             startActivity(loginIntent);
             finish();
            }
        });
        showDataCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent showDataIntent=new Intent(getApplicationContext(),DisplayData.class);
                startActivity(showDataIntent);
                finish();
            }
        });
        registerCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              Intent RegisterIntent=new Intent(getApplicationContext(),Register.class);
              startActivity(RegisterIntent);
              finish();
            }
        });
        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent logoutIntent=new Intent(getApplicationContext(),login.class);
                startActivity(logoutIntent);
                finish();
            }
        });
    }
}