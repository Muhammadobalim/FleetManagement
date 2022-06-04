package com.example.fleetmanagement;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper
{
    public  static final String DATABASENAME = "Fleetdatabase.db";
    public  static final String TABLENAME = "users";
    // declairing the table columns..............................................

    public static final String COLUMNONE   = " Id";
    public static final String COLUMNTWO   = " fullname";
    public static final String COLUMNTHREE = " email";
    public static final String COLUMNFOUR  = " phoneNumber";
    public static final String COLUMNFIVE  = " address";
    public static final String COLUMNSIX   = "userpassword";
    // creating database version.................................................

    public static final int DATABASEVERSION = 1;
    // string for concertination............an sql to write in database, create table statement...................................
    public static final String CREATETABLE="CREATE TABLE " + TABLENAME  + " (userId INTEGER PRIMARY KEY AUTOINCREMENT, fullname TEXT, email TEXT, age INTEGER, address TEXT, userpassword TEXT);";
    //creating constructor..............
    public DatabaseHelper(Context context){
        super(context,DATABASENAME,null,DATABASEVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
      db.execSQL(CREATETABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLENAME);
    }




}
