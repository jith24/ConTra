package com.example.abhijith.contactapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by USER on 9/11/2018.
 */

public class db extends SQLiteOpenHelper {
    public static final String DB_NAME = "Contacts.db";
    public static final String Table_name = "Contact_Table";
    public static final String Col1 = "id";
    public static final String Col2 = "name";
    public static final String Col3 = "Phone";

    public db(Context context){
        super(context,DB_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase d){
        d.execSQL("CREATE TABLE " + Table_name + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,PHONE TEXT)");
    }

    public void onUpgrade(SQLiteDatabase d,int oldv,int newv){
        d.execSQL("DROP TABLE IF EXIXTS "+ Table_name);
    }
    public boolean insertdata(String name,String phone){
        SQLiteDatabase d = this.getWritableDatabase();
        ContentValues c = new ContentValues();
        c.put(Col2,name);
        c.put(Col3,phone);
        long r = d.insert(Table_name,null,c);
        d.close();
        if(r==-1)
            return false;
        else
            return true;
    }
}
