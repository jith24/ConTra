package com.example.abhijith.contactapp;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import org.json.JSONObject;

/**
 * Created by Abhijith on 12-09-2017.
 */

public class Send extends Activity{
    Button Submit;
//    EditText a,b;

    ImageView i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.send);
        String name,phone,s;
        Submit = (Button) findViewById(R.id.Submit);
        final EditText a = (EditText)findViewById(R.id.editText);
        final EditText b = (EditText)findViewById(R.id.phone);
        i = (ImageView)findViewById(R.id.imageView);

        name = a.getText().toString();
        phone = b.getText().toString();
        s = (name+phone).toString();
        Log.d("name",name);
        final String text= s.toString();// Whatever you need to encode in the QR code
        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                name = a.getText().toString();
//                phone = b.getText().toString();
                Toast.makeText(getApplicationContext() ,(a.getText().toString()+" "+b.getText().toString()),Toast.LENGTH_SHORT).show();
                String j = a.getText().toString()+" "+b.getText().toString();
//                JSONObject obj = new JSONObject(j);
                    MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
                try {
                    BitMatrix bitMatrix = multiFormatWriter.encode( a.getText().toString()+" "+b.getText().toString(), BarcodeFormat.QR_CODE,600,600);
                    BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                    Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
                    i.setImageBitmap(bitmap);
                } catch (WriterException e) {
                    e.printStackTrace();
                }
            }
        });


//
    }
}
