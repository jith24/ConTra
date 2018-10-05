package com.example.abhijith.contactapp;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MainActivity extends AppCompatActivity {
    Button send, receive;
    private static final int CAMERA_REQUEST =123 ;
    private IntentIntegrator qrScan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        qrScan = new IntentIntegrator(this);
        send = (Button)findViewById(R.id.button);
        receive = (Button)findViewById(R.id.button2);
        //settings = (Button)findViewById(R.id.button3);
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
//                qrScan.initiateScan();

            }
        });


//       settings.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent settingsscreen = new Intent("com.contactapp.jith.SETTINGS");
//                startActivity(settingsscreen);
//            }
//        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        if(item.getItemId() == R.id.item1)
        {
//            Intent settingsscreen = new Intent("com.contactapp.jith.SETTINGS");
//            startActivity(settingsscreen);
            Toast.makeText(this,"Recieved",Toast.LENGTH_SHORT).show();
        }
        if(item.getItemId() == R.id.item2)
        {
//            Intent settingsscreen = new Intent("com.contactapp.jith.SETTINGS");
//            startActivity(settingsscreen);
            Toast.makeText(this,"Settings",Toast.LENGTH_SHORT).show();
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.layout.menu_main,menu);
        return true;
    }
}
