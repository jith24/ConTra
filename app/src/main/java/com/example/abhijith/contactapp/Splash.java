package com.example.abhijith.contactapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by Abhijith on 07-09-2017.
 */

public class Splash extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        Thread timer = new Thread(){
            public void run(){
              try{
                sleep(5000);
              } catch (InterruptedException e1) {
                    e1.printStackTrace();}
              finally{
                Intent openStartingPoint = new Intent("com.contactapp.jith.MAIN");
                startActivity(openStartingPoint);

            }}
        };
        timer.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
