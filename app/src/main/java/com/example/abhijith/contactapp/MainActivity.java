package com.example.abhijith.contactapp;

import android.Manifest;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.provider.MediaStore;
import android.renderscript.ScriptGroup;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MainActivity extends AppCompatActivity {
    Button send, receive, settings;
    private static final int CAMERA_REQUEST =123 ;
    private IntentIntegrator qrScan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (!checkIfAlreadyhavePermission()) {
            requestForSpecificPermission();
        }

        Boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                .getBoolean("isFirstRun", true);

        if (isFirstRun) {
            //show start activity

            startActivity(new Intent(MainActivity.this, Settings.class));
            Toast.makeText(MainActivity.this, "First Run", Toast.LENGTH_LONG)
                    .show();
        }


        getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
                .putBoolean("isFirstRun", false).commit();


        qrScan = new IntentIntegrator(this);
        send = (Button)findViewById(R.id.button);
        receive = (Button)findViewById(R.id.button2);
        settings = (Button)findViewById(R.id.settings);
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
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendscreen = new Intent("com.contactapp.jith.SETTINGS");
                startActivity(sendscreen);
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
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case 101:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Context context = getApplicationContext();
                    CharSequence text = "Contact will be saved";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                } else {
                    Context context = getApplicationContext();
                    CharSequence text = "Contact will not be saved";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    /*@Override
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
    } */

    private void requestForSpecificPermission() {
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_CONTACTS},101);
    }

    private boolean checkIfAlreadyhavePermission() {
        int result = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_CONTACTS);
        if (result == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            return false;
        }
    }


}
