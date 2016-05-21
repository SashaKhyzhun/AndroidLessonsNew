package sashakhyzhun.com.dbcreateactivity;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.text.TextUtils;

public class ContactProvider extends ContentProvider {

    private SQLiteDatabase db;
    static final Uri CONTENT_URI = Uri.parse(
            "content://sashakhyzhun.com.dbcontacts.contactprovider/people");

    @Override
    public boolean onCreate() {
        db = new ContactDbHelper(getContext()).getWritableDatabase();
        return (db == null) ? false : true;
    }

    @Nullable
    @Override
    public Cursor query(Uri url, String[] projection, String selection, String[] selectionArgs, String sort) {

        String orderBy;
        if (TextUtils.isEmpty(sort)) {
            orderBy = ContactDbHelper.NAME;
        } else {
            orderBy = sort;
        }

        Cursor cursor = db.query(ContactDbHelper.TABLE_NAME,
                projection, selection, selectionArgs, null, null, orderBy);
        cursor.setNotificationUri(getContext().getContentResolver(), url);

        return cursor;
    }

    @Nullable
    @Override
    public String getType(Uri url) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri url, ContentValues inValues) {
        ContentValues values = new ContentValues(inValues);
        long rowId = db.insert(ContactDbHelper.TABLE_NAME, ContactDbHelper.NAME, values);

        if (rowId > 0 ) {
            Uri uri = ContentUris.withAppendedId(CONTENT_URI, rowId);
            getContext().getContentResolver().notifyChange(uri, null);
            return uri;
        } else {
            throw new SQLException("Failed to insert row into " + url);
        }
    }

    @Override
    public int delete(Uri url, String where, String[] whereArgs) {

        int retVal = db.delete(ContactDbHelper.TABLE_NAME, where, whereArgs);
        getContext().getContentResolver().notifyChange(url, null);
        return 0;
    }
    @Override
    public int update(Uri url, ContentValues values, String where, String[] whereArgs) {

        int retVal = db.update(ContactDbHelper.TABLE_NAME, values, where, whereArgs);
        getContext().getContentResolver().notifyChange(url, null);

        return retVal;
    }
}
