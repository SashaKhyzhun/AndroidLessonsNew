package sashakhyzhun.com.dbcreateactivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.provider.BaseColumns;

public class ContactDbHelper extends SQLiteOpenHelper implements BaseColumns {

    public static final String DB_CONTACTS = "contacts.db";
    public static final String TABLE_NAME = "people";
    public static final String NAME = "first_name";
    public static final String PHONE = "phone";

    public ContactDbHelper(Context context) {
        super(context, DB_CONTACTS, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME
                + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME + " TEXT, "
                + PHONE + " TEXT);");

        ContentValues values = new ContentValues();

        values.put(NAME, "Jacob Anderson");
        values.put(PHONE, "4463732");
        db.insert(TABLE_NAME, NAME, values);

        values.put(NAME, "Emily Duncan");
        values.put(PHONE, "4486219");
        db.insert(TABLE_NAME, NAME, values);

        values.put(NAME, "Michael Fuller");
        values.put(PHONE, "88005553535");
        db.insert(TABLE_NAME, NAME, values);

        values.put(NAME, "Emma Greenman");
        values.put(PHONE, "228228882");
        db.insert(TABLE_NAME, NAME, values);

        values.put(NAME, "Madison Johnson");
        values.put(PHONE, "7984168432");
        db.insert(TABLE_NAME, NAME, values);

        values.put(NAME, "Matthew Cotman");
        values.put(PHONE, "48616728");
        db.insert(TABLE_NAME, NAME, values);

        values.put(NAME, "Olivia Lawson");
        values.put(PHONE, "192837912835");
        db.insert(TABLE_NAME, NAME, values);

        values.put(NAME, "Daniel Honeyman");
        values.put(PHONE, "123512312");
        db.insert(TABLE_NAME, NAME, values);

        values.put(NAME, "Isabella Jackson");
        values.put(PHONE, "6079682");
        db.insert(TABLE_NAME, NAME, values);

        values.put(NAME, "Andrew Bush");
        values.put(PHONE, "13371448228");
        db.insert(TABLE_NAME, NAME, values);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " + TABLE_NAME);
        onCreate(db);
    }
}
