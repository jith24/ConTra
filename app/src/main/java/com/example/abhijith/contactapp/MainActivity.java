package com.example.abhijith.contactapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button send, receive,settings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        send = (Button)findViewById(R.id.button);
        receive = (Button)findViewById(R.id.button2);
        settings = (Button)findViewById(R.id.button3);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendscreen = new Intent("com.contactapp.jith.SEND");
                startActivity(sendscreen);
            }
        });
        receive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent receivescreen = new Intent("com.contactapp.jith.RECEIVE");
                startActivity(receivescreen);
            }
        });
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent settingsscreen = new Intent("com.contactapp.jith.SETTINGS");
                startActivity(settingsscreen);
            }
        });

    }
}
