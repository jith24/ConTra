package com.example.abhijith.contactapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import org.json.JSONException;
import org.json.JSONObject;

import static android.content.ContentValues.TAG;

/**
 * Created by Abhijith on 12-09-2017.
 */

public class Send extends Activity{
    Button Submit;
    ToggleButton name, phone, email;
    ToggleButton website, linkedin, facebook, snapchat, github, instagram, twitter;

    SharedPreferences Preferences;
    SharedPreferences.Editor Editor;

    public static JSONObject contra;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.send);
        Submit = (Button) findViewById(R.id.Submit);
        Preferences = PreferenceManager.getDefaultSharedPreferences(this);
        Editor=Preferences.edit();

        final String contra_name =Preferences.getString(getString(R.string.contra_name),"");
        final String contra_phone =Preferences.getString(getString(R.string.contra_phone),"");
        final String contra_email =Preferences.getString(getString(R.string.contra_email),"");
        final String contra_instagram =Preferences.getString(getString(R.string.contra_instagram),"");
        final String contra_facebook =Preferences.getString(getString(R.string.contra_facebook),"");
        final String contra_twitter =Preferences.getString(getString(R.string.contra_twitter),"");
        final String contra_snapchat =Preferences.getString(getString(R.string.contra_snapchat),"");
        final String contra_linkedin =Preferences.getString(getString(R.string.contra_linkedin),"");
        final String contra_github =Preferences.getString(getString(R.string.contra_github),"");
        final String contra_website =Preferences.getString(getString(R.string.contra_website),"");


        name=(ToggleButton)findViewById(R.id.tb_name_send);
        name.setTextOn("Name - "+contra_name);
        name.setTextOff("Name - "+contra_name);
        name.setText("Name - "+contra_name);

        phone=(ToggleButton)findViewById(R.id.tb_phone_send);
        phone.setTextOn("Phone - "+contra_phone);
        phone.setTextOff("Phone - "+contra_phone);
        phone.setText("Phone - "+contra_phone);


        email=(ToggleButton)findViewById(R.id.tb_email_send);
        email.setTextOn("Email - "+contra_email);
        email.setTextOff("Email - "+contra_email);
        email.setText("Email - "+contra_email);

        instagram=(ToggleButton)findViewById(R.id.tb_instagram_send);
        instagram.setTextOn("Instagram - "+contra_instagram);
        instagram.setTextOff("Instagram - "+contra_instagram);
        instagram.setText("Instagram - "+contra_instagram);

        facebook=(ToggleButton)findViewById(R.id.tb_facebook_send);
        facebook.setTextOn("Facebook - "+contra_facebook);
        facebook.setTextOff("Facebook - "+contra_facebook);
        facebook.setText("Facebook - "+contra_facebook);

        twitter=(ToggleButton)findViewById(R.id.tb_twitter_send);
        twitter.setTextOn("Twitter - "+contra_twitter);
        twitter.setTextOff("Twitter - "+contra_twitter);
        twitter.setText("Twitter - "+contra_twitter);

        snapchat=(ToggleButton)findViewById(R.id.tb_snapchat_send);
        snapchat.setTextOn("Snapchat - "+contra_snapchat);
        snapchat.setTextOff("Snapchat - "+contra_snapchat);
        snapchat.setText("Snapchat - "+contra_snapchat);

        linkedin=(ToggleButton)findViewById(R.id.tb_linkedin_send);
        linkedin.setTextOn("LinkedIN - "+contra_linkedin);
        linkedin.setTextOff("LinkedIN - "+contra_linkedin);
        linkedin.setText("LinkedIN - "+contra_linkedin);

        github=(ToggleButton)findViewById(R.id.tb_github_send);
        github.setTextOn("GitHub - "+contra_github);
        github.setTextOff("GitHub - "+contra_github);
        github.setText("GitHub - "+contra_github);

        website=(ToggleButton)findViewById(R.id.tb_website_send);
        website.setTextOn("Website - "+contra_website);
        website.setTextOff("Website - "+contra_website);
        website.setText("Website - "+contra_website);



        if(!contra_name.equals("")){
            name.setVisibility(View.VISIBLE);
        }
        else{
            name.setVisibility(View.GONE);
        }
        if(!contra_phone.equals("")){
            phone.setVisibility(View.VISIBLE);
        }
        else{
            phone.setVisibility(View.GONE);
        }
        if(!contra_email.equals("")){
            email.setVisibility(View.VISIBLE);
            }
        else{
            email.setVisibility(View.GONE);
        }
        if(!contra_instagram.equals("")){
            instagram.setVisibility(View.VISIBLE);
        }
        else{
            instagram.setVisibility(View.GONE);
        }
        if(!contra_facebook.equals("")){
            facebook.setVisibility(View.VISIBLE);
        }
        else{
            facebook.setVisibility(View.GONE);
        }
        if(!contra_twitter.equals("")){
            twitter.setVisibility(View.VISIBLE);
        }
        else{
            twitter.setVisibility(View.GONE);
        }
        if(!contra_snapchat.equals("")){
            snapchat.setVisibility(View.VISIBLE);
        }
        else{
            snapchat.setVisibility(View.GONE);
        }
        if(!contra_linkedin.equals("")){
            linkedin.setVisibility(View.VISIBLE);
        }
        else{
            linkedin.setVisibility(View.GONE);
        }
        if(!contra_github.equals("")){
            github.setVisibility(View.VISIBLE);
        }
        else{
            github.setVisibility(View.GONE);
        }
        if(!contra_website.equals("")){
            website.setVisibility(View.VISIBLE);
        }
        else{
            website.setVisibility(View.GONE);
        }



        contra = new JSONObject();

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(name.isChecked()){
                    try {
                        contra.put("contra_name",contra_name);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
                else try {
                    contra.put("contra_name", "");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if(phone.isChecked()){
                    try {
                        contra.put("contra_phone",contra_phone);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
                else try {
                    contra.put("contra_phone", "");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if(email.isChecked()){
                    try {
                        contra.put("contra_email",contra_email);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
                else try {
                    contra.put("contra_email", "");
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                if(instagram.isChecked()){
                    try {
                        contra.put("contra_instagram",contra_instagram);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
                else try {
                    contra.put("contra_instagram", "");
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                if(facebook.isChecked()){
                    try {
                        contra.put("contra_facebook",contra_facebook);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
                else try {
                    contra.put("contra_facebook", "");
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                if(twitter.isChecked()){
                    try {
                        contra.put("contra_twitter",contra_twitter);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
                else try {
                    contra.put("contra_twitter", "");
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                if(snapchat.isChecked()){
                    try {
                        contra.put("contra_snapchat",contra_snapchat);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
                else try {
                    contra.put("contra_snapchat", "");
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                if(linkedin.isChecked()){
                    try {
                        contra.put("contra_linkedin",contra_linkedin);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
                else try {
                    contra.put("contra_linkedin", "");
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                if(github.isChecked()){
                    try {
                        contra.put("contra_github",contra_github);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
                else try {
                    contra.put("contra_github", "");
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                if(website.isChecked()){
                    try {
                        contra.put("contra_website",contra_website);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
                else try {
                    contra.put("contra_website", "");
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                Intent intent = new Intent("com.contactapp.jith.SENDFINAL");
                startActivity(intent);
            }
        });

    }

}
