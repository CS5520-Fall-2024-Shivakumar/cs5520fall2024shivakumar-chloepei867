package com.example.numad24fa_zhiyanpei;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(@Nullable Context context) {
        super(context, Constants.DATABASE_NAME, null, Constants.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //create table on database
        db.execSQL(Constants.CREATE_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //upgrade table

        //drop table if exists
        db.execSQL("DROP TABLE IF EXISTS "+Constants.TABLE_NAME);

        onCreate(db);
    }

    public long addContact(String name, String phone) {
        //to get writable database to write data on db
        SQLiteDatabase db = this.getWritableDatabase();

        //to save data
        ContentValues contentValues = new ContentValues();

        contentValues.put(Constants.C_NAME, name);
        contentValues.put(Constants.C_PHONE, phone);

        long id = db.insert(Constants.TABLE_NAME, null, contentValues);
        db.close();

        return id;
    }
}
