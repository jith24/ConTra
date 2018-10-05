package com.example.abhijith.contactapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Camera;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Abhijith on 12-09-2017.
 */



public class Receive extends Activity{
    private IntentIntegrator qrScan;
    private TextView textViewName, textViewAddress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        qrScan = new IntentIntegrator(this);
        setContentView(R.layout.receive);
//        Intent cam = new Intent("android.media.action.IMAGE_CAPTURE");
//        startActivity(cam);
//        return c;
        textViewName = (TextView) findViewById(R.id.textViewName);
        textViewAddress = (TextView) findViewById(R.id.textViewAddress);
        qrScan.initiateScan();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            //if qrcode has nothing in it
            if (result.getContents() == null) {
                Toast.makeText(this, "Result Not Found", Toast.LENGTH_LONG).show();
            } else {
                //if qr contains data
                //converting the data to json
//                    JSONObject obj = new JSONObject(result.getContents());
                //setting values to textviews
                String r=result.getContents();
                String[] res = r.split(" ", 2);
                textViewName.setText(res[0]);
                textViewAddress.setText(res[1]);
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}