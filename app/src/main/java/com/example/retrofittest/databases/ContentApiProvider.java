package com.example.retrofittest.databases;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.text.TextUtils;

import java.sql.SQLException;

public class ContentApiProvider extends ContentProvider {

    public static final Uri CONTENT_URI = Uri.parse("content://com.example.retrofittest.contentapiprovider/missing");
    SQLiteDatabase db;

    @Override
    public boolean onCreate() {
        db = new MissingPetsDatabase(getContext()).getWritableDatabase();
        return (db != null);
    }

    @Override  // SELECT QUERY
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {

        String orderBy;

        if(TextUtils.isEmpty(sortOrder)) {
            orderBy = MissingPetsDatabase.PetsTable.ID;
        }
        else {
            orderBy = sortOrder;
        }

        Cursor c = db.query(MissingPetsDatabase.PetsTable.TABLE_NAME, projection, selection, selectionArgs, null, null, orderBy);
        c.setNotificationUri(getContext().getContentResolver(), uri);
        return c;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        ContentValues contentValues = new ContentValues(values);
        long rowId = db.insertWithOnConflict(MissingPetsDatabase.PetsTable.TABLE_NAME, null, contentValues, SQLiteDatabase.CONFLICT_REPLACE);

        if(rowId<=0){
            try {
                throw new SQLException("Failed to insert row into "+uri);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }
        else  {
            Uri url = ContentUris.withAppendedId(CONTENT_URI, rowId);
            getContext().getContentResolver().notifyChange(url, null);

            return url;
        }

    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        int retVal = db.delete(MissingPetsDatabase.PetsTable.TABLE_NAME, selection, selectionArgs);
        getContext().getContentResolver().notifyChange(uri, null);

        return retVal;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        int retVal = db.update(MissingPetsDatabase.PetsTable.TABLE_NAME, values, selection, selectionArgs);
        getContext().getContentResolver().notifyChange(uri, null);

        return retVal;
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }
}
