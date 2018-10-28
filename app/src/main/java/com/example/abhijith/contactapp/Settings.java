package com.example.abhijith.contactapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by Abhijith on 12-09-2017.
 */



public class Settings extends Activity {
//    ListView lv;
    Button Submit;
    EditText name;
    EditText phone;
    EditText email;
    EditText website, linkedin, facebook, snapchat, github, instagram, twitter;
    private SharedPreferences Preferences;
    private SharedPreferences.Editor Editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        Submit = (Button)findViewById(R.id.button3);
        name = (EditText)findViewById(R.id.et_name_settings);
        phone = (EditText)findViewById(R.id.et_phone_settings);
        email = (EditText)findViewById(R.id.et_email_settings);
        linkedin = (EditText)findViewById(R.id.et_linkedin_settings);
        website = (EditText)findViewById(R.id.et_website_settings);
        facebook=(EditText)findViewById(R.id.et_facebook_settings);
        snapchat=(EditText)findViewById(R.id.et_snapchat_settings);
        github = (EditText)findViewById(R.id.et_github_settings);
        instagram=(EditText)findViewById(R.id.et_instagram_settings);
        twitter =(EditText)findViewById(R.id.et_twitter_settings);



        Preferences = PreferenceManager.getDefaultSharedPreferences(this);
        Editor=Preferences.edit();
        checkSharedPreferences();


        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String contra_name=name.getText().toString();
                Editor.putString(getString(R.string.contra_name),contra_name);
                Editor.apply();

                String contra_phone=phone.getText().toString();
                Editor.putString(getString(R.string.contra_phone),contra_phone);
                Editor.apply();

                String contra_email=email.getText().toString();
                Editor.putString(getString(R.string.contra_email),contra_email);
                Editor.apply();

                String contra_website=website.getText().toString();
                Editor.putString(getString(R.string.contra_website),contra_website);
                Editor.apply();

                String contra_instagram=instagram.getText().toString();
                Editor.putString(getString(R.string.contra_instagram),contra_instagram);
                Editor.apply();

                String contra_facebook=facebook.getText().toString();
                Editor.putString(getString(R.string.contra_facebook),contra_facebook);
                Editor.apply();

                String contra_twitter=twitter.getText().toString();
                Editor.putString(getString(R.string.contra_twitter),contra_twitter);
                Editor.apply();

                String contra_snapchat=snapchat.getText().toString();
                Editor.putString(getString(R.string.contra_snapchat),contra_snapchat);
                Editor.apply();

                String contra_github=github.getText().toString();
                Editor.putString(getString(R.string.contra_github),contra_github);
                Editor.apply();

                String contra_linkedin=linkedin.getText().toString();
                Editor.putString(getString(R.string.contra_linkedin),contra_linkedin);
                Editor.apply();

                Context context = getApplicationContext();
                CharSequence text = "Changes Made";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

                Intent intent = new Intent("com.contactapp.jith.MAIN");
                startActivity(intent);
            }
        });


    }
    private void checkSharedPreferences(){
        String contra_name =Preferences.getString(getString(R.string.contra_name),"");
        name.setText(contra_name);
        String contra_phone =Preferences.getString(getString(R.string.contra_phone),"");
        phone.setText(contra_phone);
        String contra_email =Preferences.getString(getString(R.string.contra_email),"");
        email.setText(contra_email);
        String contra_instagram =Preferences.getString(getString(R.string.contra_instagram),"");
        instagram.setText(contra_instagram);
        String contra_facebook =Preferences.getString(getString(R.string.contra_facebook),"");
        facebook.setText(contra_facebook);
        String contra_twitter =Preferences.getString(getString(R.string.contra_twitter),"");
        twitter.setText(contra_twitter);
        String contra_snapchat =Preferences.getString(getString(R.string.contra_snapchat),"");
        snapchat.setText(contra_snapchat);
        String contra_linkedin =Preferences.getString(getString(R.string.contra_linkedin),"");
        linkedin.setText(contra_linkedin);
        String contra_github =Preferences.getString(getString(R.string.contra_github),"");
        github.setText(contra_github);
        String contra_website =Preferences.getString(getString(R.string.contra_website),"");
        website.setText(contra_website);

    }
}