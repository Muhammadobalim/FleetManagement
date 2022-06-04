package com.example.fleetmanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class welcomeActivity extends AppCompatActivity {
                 CardView loginCard,registerCard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        loginCard=(CardView) findViewById(R.id.loginCard);
        registerCard=(CardView) findViewById(R.id.register_card);
        loginCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginIntent=new Intent(getApplicationContext(),login.class);
                startActivity(loginIntent);
                finish();//creating a door

            }
        });
        registerCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent=new Intent(getApplicationContext(),Register.class);
                startActivity(registerIntent);
                finish();

            }
        });
    }

    public void onShow(View view){finish();}

}