package com.example.abhijith.contactapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by jith2 on 28-10-2018.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="contranet.db";
    private static final String TABLE_NAME="contranet_details";


    private static final String COLUMN_ID="id";
    private static final String COLUMN_NAME="name";
    private static final String COLUMN_PHONE="phone";
    private static final String COLUMN_EMAIL="email";
    private static final String COLUMN_INSTAGRAM="instagram";
    private static final String COLUMN_FACEBOOK="facebook";
    private static final String COLUMN_SNAPCHAT="snapchat";
    private static final String COLUMN_GITHUB="github";
    private static final String COLUMN_WEBSITE="website";
    private static final String COLUMN_LINKEDIN="linkedin";


    SQLiteDatabase database;








    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        database = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE "+TABLE_NAME+"("+COLUMN_ID+" INTEGER PRIMARY KEY, "+COLUMN_NAME+" VARCHAR, "+COLUMN_PHONE+" VARCHAR, "+COLUMN_EMAIL+" VARCHAR, "+COLUMN_INSTAGRAM+" VARCHAR, "+COLUMN_FACEBOOK+" VARCHAR, "+COLUMN_SNAPCHAT+" VARCHAR, "+COLUMN_GITHUB+" VARCHAR, "+COLUMN_WEBSITE+" VARCHAR, "+COLUMN_LINKEDIN+")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
