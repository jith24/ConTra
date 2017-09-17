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

public class MainActivity extends AppCompatActivity {
    Button send, receive;
    private static final int CAMERA_REQUEST =123 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        /*receive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent receivescreen = new Intent("com.contactapp.jith.RECEIVE");
                startActivity(receivescreen);
            }
        });*/
       /* settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent settingsscreen = new Intent("com.contactapp.jith.SETTINGS");
                startActivity(settingsscreen);
            }
        });*/

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
    getMenuInflater().inflate(R.layout.menu_main,menu);
    return true;
}
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        Toast.makeText(this,"MENU",Toast.LENGTH_SHORT).show();
        Intent settingsscreen = new Intent("com.contactapp.jith.SETTINGS");
        startActivity(settingsscreen);
        return true;
    }

    public void btnclick(View v){
        Intent cam = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cam, CAMERA_REQUEST);
    }
}
