package com.example.farhad.rssfeedapp;

import android.content.Context;
import android.database.sqlite.*;

public class DatabaseHelper extends SQLiteOpenHelper {

    static final String dbName="rssDB";
    static final String rssTable="rssFeed";
    static final String keyID = "id";
    static final String keyTitle = "title";
    static final String keyDescription = "description";
    static final String keyPubDate = "pubDate";
    static final String keyLink ="link";

    public DatabaseHelper(Context context){
        super(context, dbName, null, 33);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //creating the tables, keys and columns
        db.execSQL("CREATE TABLE" + rssTable +" ("+keyID+ " INTEGER PRIMARY KEY , "
                + keyTitle + " TEXT" + keyDescription + " TEXT" + keyPubDate + " TEXT" + keyLink + " TEXT");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + rssTable);

        db.execSQL("DROP TRIGGER IF EXISTS keyID");
        onCreate(db);
    }
}
