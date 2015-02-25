package com.example.retrofittest.databases;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

public class MissingPetsDatabase extends SQLiteOpenHelper {

    public static final int VERSION = 14;
    public static final String DB_NAME = "missingpets.db";
    public static final String CREATE_TABLE = "CREATE TABLE " + PetsTable.TABLE_NAME + " ("
            + PetsTable.ID + " VARCHAR(50) PRIMARY KEY, "
            + PetsTable.PET_TYPE_ID + " INTEGER, "
            + PetsTable.GENDER + " INTEGER, "
            + PetsTable.NICKNAME + " VARCHAR(20), "
            + PetsTable.BREED + " VARCHAR(40), "
            + PetsTable.COLOR + " VARCHAR(20), "
            + PetsTable.LOCATION_LAT + " DOUBLE, "
            + PetsTable.LOCATION_LON + " DOUBLE, "
            + PetsTable.ADDRESS + " VARCHAR(40), "
            + PetsTable.CONTACTS + " VARCHAR(30), "
            + PetsTable.ADDITIONAL_INFO + " TEXT, "
            + PetsTable.PHOTO + " VARCHAR(255));";

    public MissingPetsDatabase(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {
            db.execSQL("DROP TABLE IF EXISTS "+PetsTable.TABLE_NAME);
            onCreate(db);
        }
        catch (SQLiteException e){
            Log.e("lol", "lol");
        }

    }

    public class PetsTable {
        public static final String TABLE_NAME = "missing";
        public static final String ID = BaseColumns._ID;
        public static final String PET_TYPE_ID = "Pet_type";
        public static final String GENDER = "Gender";
        public static final String NICKNAME = "Nickname";
        public static final String BREED = "Breed";
        public static final String COLOR = "Color";
        public static final String LOCATION_LAT = "Location_lat";
        public static final String LOCATION_LON = "Location_lon";
        public static final String ADDRESS = "Address";
        public static final String CONTACTS = "Contacts";
        public static final String ADDITIONAL_INFO = "Additional_info";
        public static final String PHOTO = "Photo";
    }
}