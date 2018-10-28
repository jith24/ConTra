package com.example.abhijith.contactapp;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ContentProviderOperation;
import android.content.Context;
import android.content.Intent;


import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;

import android.view.View;
import android.widget.Button;


import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.journeyapps.barcodescanner.CaptureActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Abhijith on 12-09-2017.
 */



public class Receive extends Activity{
    private IntentIntegrator qrScan;
    private Button name, phone, email;
    private Button website, linkedin, facebook, snapchat, github, instagram, twitter;
    ClipboardManager clipboard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        qrScan = new IntentIntegrator(this);
        setContentView(R.layout.receive);

        name = (Button) findViewById(R.id.b_name_receive);
        phone = (Button) findViewById(R.id.b_phone_receive);
        email = (Button) findViewById(R.id.b_email_receive);

        linkedin = (Button)findViewById(R.id.b_linkedin_receive);
        website = (Button)findViewById(R.id.b_website_receive);
        facebook=(Button)findViewById(R.id.b_facebook_receive);
        snapchat=(Button)findViewById(R.id.b_snapchat_receive);
        github = (Button)findViewById(R.id.b_github_receive);
        instagram=(Button)findViewById(R.id.b_instagram_receive);
        twitter =(Button)findViewById(R.id.b_twitter_receive);
        
        qrScan.setCaptureActivity(CaptureActivityPortrait.class);
        qrScan.initiateScan();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            //if qrcode has nothing in it
            if (result.getContents() == null) {
                Toast.makeText(this, "Result Not Found", Toast.LENGTH_LONG).show();
                Intent intent = new Intent("com.contactapp.jith.MAIN");
                startActivity(intent);
            } else {

                String r=result.getContents();


                String contra_name="";
                String contra_phone="";
                String contra_email="";
                String contra_instagram="";
                String contra_facebook="";
                String contra_twitter="";
                String contra_snapchat="";
                String contra_github="";
                String contra_website="";
                String contra_linkedin="";
                final String copy_name;
                final String copy_phone;
                final String copy_email;
                final String copy_instagram;
                final String copy_facebook;
                final String copy_twitter;
                final String copy_snapchat;
                final String copy_github;
                final String copy_website;
                final String copy_linkedin;

                try {
                    JSONObject json = new JSONObject(r);
                    contra_name= json.getString("contra_name");
                    contra_phone= json.getString("contra_phone");
                    contra_email= json.getString("contra_email");
                    contra_instagram= json.getString("contra_instagram");
                    contra_facebook= json.getString("contra_facebook");
                    contra_twitter= json.getString("contra_twitter");
                    contra_snapchat= json.getString("contra_snapchat");
                    contra_github= json.getString("contra_github");
                    contra_website= json.getString("contra_website");
                    contra_linkedin= json.getString("contra_linkedin");


                } catch (JSONException e) {
                    e.printStackTrace();
                }

                if(contra_name.equals("")){
                    name.setVisibility(View.GONE);
                    copy_name="";
                }
                else {
                    name.setText("Name - "+contra_name);
                    copy_name=contra_name;
                }
                if(contra_phone.equals("")){
                    phone.setVisibility(View.GONE);
                    copy_phone="";
                }
                else {
                    phone.setText("Phone - "+contra_phone);
                    copy_phone=contra_phone;
                }
                if(contra_email.equals("")){
                    email.setVisibility(View.GONE);
                    copy_email="";
                }
                else {
                    email.setText("Email - "+contra_email);
                    copy_email=contra_email;
                }
                if(contra_instagram.equals("")){
                    instagram.setVisibility(View.GONE);
                    copy_instagram="";
                }
                else {
                    instagram.setText("Instagram - "+contra_instagram);
                    copy_instagram=contra_instagram;
                }
                if(contra_facebook.equals("")){
                    facebook.setVisibility(View.GONE);
                    copy_facebook="";
                }
                else {
                    facebook.setText("Facebook - "+contra_facebook);
                    copy_facebook=contra_facebook;
                }
                if(contra_twitter.equals("")){
                    twitter.setVisibility(View.GONE);
                    copy_twitter="";
                }
                else {
                    twitter.setText("Twitter - "+contra_twitter);
                    copy_twitter=contra_twitter;
                }
                if(contra_snapchat.equals("")){
                    snapchat.setVisibility(View.GONE);
                    copy_snapchat="";
                }
                else {
                    snapchat.setText("Snapchat - "+contra_snapchat);
                    copy_snapchat=contra_snapchat;
                }
                if(contra_github.equals("")){
                    github.setVisibility(View.GONE);
                    copy_github="";
                }
                else {
                    github.setText("GitHub - "+contra_github);
                    copy_github=contra_github;
                }
                if(contra_website.equals("")){
                    website.setVisibility(View.GONE);
                    copy_website="";
                }
                else {
                    website.setText("Website - "+contra_website);
                    copy_website=contra_website;
                }
                if(contra_linkedin.equals("")){
                    linkedin.setVisibility(View.GONE);
                    copy_linkedin="";
                }
                else {
                    linkedin.setText("LinkedIN - "+contra_linkedin);
                    copy_linkedin=contra_linkedin;
                }

                //DatabaseHandler db = new DatabaseHandler(this);



                if(!contra_name.equals("")&&!contra_phone.equals("")) {

                    String DisplayName = contra_name;
                    String MobileNumber = contra_phone;
                    //String HomeNumber = "1111";
                    //String WorkNumber = "2222";
                    String emailID = contra_email;
                    //String company = "bad";
                    //String jobTitle = "abcd";

                    ArrayList<ContentProviderOperation> ops = new ArrayList<ContentProviderOperation>();

                    ops.add(ContentProviderOperation.newInsert(
                            ContactsContract.RawContacts.CONTENT_URI)
                            .withValue(ContactsContract.RawContacts.ACCOUNT_TYPE, null)
                            .withValue(ContactsContract.RawContacts.ACCOUNT_NAME, null)
                            .build());

                    //------------------------------------------------------ Names
                    if (DisplayName != null) {
                        ops.add(ContentProviderOperation.newInsert(
                                ContactsContract.Data.CONTENT_URI)
                                .withValueBackReference(ContactsContract.Data.RAW_CONTACT_ID, 0)
                                .withValue(ContactsContract.Data.MIMETYPE,
                                        ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE)
                                .withValue(
                                        ContactsContract.CommonDataKinds.StructuredName.DISPLAY_NAME,
                                        DisplayName).build());
                    }

                    //------------------------------------------------------ Mobile Number
                    if (MobileNumber != null) {
                        ops.add(ContentProviderOperation.
                                newInsert(ContactsContract.Data.CONTENT_URI)
                                .withValueBackReference(ContactsContract.Data.RAW_CONTACT_ID, 0)
                                .withValue(ContactsContract.Data.MIMETYPE,
                                        ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE)
                                .withValue(ContactsContract.CommonDataKinds.Phone.NUMBER, MobileNumber)
                                .withValue(ContactsContract.CommonDataKinds.Phone.TYPE,
                                        ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE)
                                .build());
                    }

                    /*//------------------------------------------------------ Home Numbers
                    if (HomeNumber != null) {
                        ops.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI)
                                .withValueBackReference(ContactsContract.Data.RAW_CONTACT_ID, 0)
                                .withValue(ContactsContract.Data.MIMETYPE,
                                        ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE)
                                .withValue(ContactsContract.CommonDataKinds.Phone.NUMBER, HomeNumber)
                                .withValue(ContactsContract.CommonDataKinds.Phone.TYPE,
                                        ContactsContract.CommonDataKinds.Phone.TYPE_HOME)
                                .build());
                    }

                    //------------------------------------------------------ Work Numbers
                    if (WorkNumber != null) {
                        ops.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI)
                                .withValueBackReference(ContactsContract.Data.RAW_CONTACT_ID, 0)
                                .withValue(ContactsContract.Data.MIMETYPE,
                                        ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE)
                                .withValue(ContactsContract.CommonDataKinds.Phone.NUMBER, WorkNumber)
                                .withValue(ContactsContract.CommonDataKinds.Phone.TYPE,
                                        ContactsContract.CommonDataKinds.Phone.TYPE_WORK)
                                .build());
                    }*/

                    //------------------------------------------------------ Email
                    if (emailID != null) {
                        ops.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI)
                                .withValueBackReference(ContactsContract.Data.RAW_CONTACT_ID, 0)
                                .withValue(ContactsContract.Data.MIMETYPE,
                                        ContactsContract.CommonDataKinds.Email.CONTENT_ITEM_TYPE)
                                .withValue(ContactsContract.CommonDataKinds.Email.DATA, emailID)
                                .withValue(ContactsContract.CommonDataKinds.Email.TYPE, ContactsContract.CommonDataKinds.Email.TYPE_WORK)
                                .build());
                    }

                    /*//------------------------------------------------------ Organization
                    if (!company.equals("") && !jobTitle.equals("")) {
                        ops.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI)
                                .withValueBackReference(ContactsContract.Data.RAW_CONTACT_ID, 0)
                                .withValue(ContactsContract.Data.MIMETYPE,
                                        ContactsContract.CommonDataKinds.Organization.CONTENT_ITEM_TYPE)
                                .withValue(ContactsContract.CommonDataKinds.Organization.COMPANY, company)
                                .withValue(ContactsContract.CommonDataKinds.Organization.TYPE, ContactsContract.CommonDataKinds.Organization.TYPE_WORK)
                                .withValue(ContactsContract.CommonDataKinds.Organization.TITLE, jobTitle)
                                .withValue(ContactsContract.CommonDataKinds.Organization.TYPE, ContactsContract.CommonDataKinds.Organization.TYPE_WORK)
                                .build());
                    }*/

                    // Asking the Contact provider to create a new contact
                    try {
                        getContentResolver().applyBatch(ContactsContract.AUTHORITY, ops);

                        Context context = getApplicationContext();
                        CharSequence text = DisplayName+" Contact Created";
                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(this, "Exception: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                }











                name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                    ClipData clip = ClipData.newPlainText("contra_name", copy_name);
                    clipboard.setPrimaryClip(clip);

                    Context context = getApplicationContext();
                    CharSequence text = "Copied Name";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            });


                phone.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                        ClipData clip = ClipData.newPlainText("contra_phone", copy_phone);
                        clipboard.setPrimaryClip(clip);

                        Context context = getApplicationContext();
                        CharSequence text = "Copied Phone Number";
                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                        Intent intent = new Intent(Intent.ACTION_DIAL);
                        intent.setData(Uri.parse("tel:"+copy_phone));
                        startActivity(intent);
                    }
                });


                email.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                        ClipData clip = ClipData.newPlainText("contra_email", copy_email);
                        clipboard.setPrimaryClip(clip);

                        Context context = getApplicationContext();
                        CharSequence text = "Copied Email";
                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + copy_email));
                        startActivity(emailIntent);

                    }
                });

                linkedin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                        ClipData clip = ClipData.newPlainText("contra_linkedin", copy_linkedin);
                        clipboard.setPrimaryClip(clip);

                        Context context = getApplicationContext();
                        CharSequence text = "Copied LinkedIN URL";
                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                        try{String url_linkedin=copy_linkedin;
                            Intent i = new Intent(Intent.ACTION_VIEW);
                            i.setData(Uri.parse(url_linkedin));
                            startActivity(i);
                        }catch(Exception e){
                            e.printStackTrace();
                        }
                    }
                });

                github.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                        ClipData clip = ClipData.newPlainText("contra_github", copy_github);
                        clipboard.setPrimaryClip(clip);

                        Context context = getApplicationContext();
                        CharSequence text = "Copied Name Github Profile URL";
                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                        try{String url_github=copy_github;
                            Intent i = new Intent(Intent.ACTION_VIEW);
                            i.setData(Uri.parse(url_github));
                            startActivity(i);
                        }catch(Exception e){
                            e.printStackTrace();
                        }
                    }
                });

                website.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                        ClipData clip = ClipData.newPlainText("contra_website", copy_website);
                        clipboard.setPrimaryClip(clip);

                        Context context = getApplicationContext();
                        CharSequence text = "Copied Website URL";
                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                        try{String url_website="https://"+copy_website;
                            Intent i = new Intent(Intent.ACTION_VIEW);
                            i.setData(Uri.parse(url_website));
                            startActivity(i);
                        }catch(Exception e){
                            e.printStackTrace();
                        }


                    }
                });

                snapchat.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                        ClipData clip = ClipData.newPlainText("contra_snapchat", copy_snapchat);
                        clipboard.setPrimaryClip(clip);

                        Context context = getApplicationContext();
                        CharSequence text = "Copied Snapchat";
                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                        try{String url_snapchat="https://www.snapchat.com/add/"+copy_snapchat;
                            Intent i = new Intent(Intent.ACTION_VIEW);
                            i.setData(Uri.parse(url_snapchat));
                            startActivity(i);
                        }catch(Exception e){
                            e.printStackTrace();
                        }
                    }
                });

                twitter.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                        ClipData clip = ClipData.newPlainText("contra_twitter", copy_twitter);
                        clipboard.setPrimaryClip(clip);

                        Context context = getApplicationContext();
                        CharSequence text = "Copied Twitter ID";
                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                        try{String url_twitter="https://www.twitter.com/"+copy_twitter;
                            Intent i = new Intent(Intent.ACTION_VIEW);
                            i.setData(Uri.parse(url_twitter));
                            startActivity(i);
                        }catch(Exception e){
                            e.printStackTrace();
                        }
                    }
                });

                facebook.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                        ClipData clip = ClipData.newPlainText("contra_facebook", copy_facebook);
                        clipboard.setPrimaryClip(clip);

                        Context context = getApplicationContext();
                        CharSequence text = "Copied Facebook Name";
                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                        try{String url_facebook=copy_facebook;
                            Intent i = new Intent(Intent.ACTION_VIEW);
                            i.setData(Uri.parse(url_facebook));
                            startActivity(i);
                        }catch(Exception e){
                            e.printStackTrace();
                        }
                    }
                });

                instagram.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                        ClipData clip = ClipData.newPlainText("contra_instagram", copy_instagram);
                        clipboard.setPrimaryClip(clip);

                        Context context = getApplicationContext();
                        CharSequence text = "Copied Instagram UserID";
                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                        try{String url_instagram="https://www.instagram.com/"+copy_instagram;
                            Intent i = new Intent(Intent.ACTION_VIEW);
                            i.setData(Uri.parse(url_instagram));
                            startActivity(i);
                        }catch(Exception e){
                            e.printStackTrace();
                        }
                    }
                });


            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}