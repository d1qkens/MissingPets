package com.example.retrofittest.databases;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

public class MissingPetsDatabase extends SQLiteOpenHelper {

    public static final int VERSION = 5;
    public static final String DB_NAME = "missingpets.db";
    public static final String CREATE_TABLE = "CREATE TABLE " + PetsTable.TABLE_NAME + " ("
            + PetsTable.ID + " INTEGER PRIMARY KEY, "
            + PetsTable.PET + " VARCHAR(15), "
            + PetsTable.GENDER + " VARCHAR(15), "
            + PetsTable.NICKNAME + " VARCHAR(15), "
            + PetsTable.BREED + " VARCHAR(40), "
            + PetsTable.COLOR + " VARCHAR(20), "
            + PetsTable.LOCATION + " VARCHAR(40), "
            + PetsTable.CONTACTS + " VARCHAR(30), "
            + PetsTable.INFO + " VARCHAR(100));";

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
        public static final String PET = "Pet";
        public static final String GENDER = "Gender";
        public static final String NICKNAME = "Nickname";
        public static final String BREED = "Breed";
        public static final String COLOR = "Color";
        public static final String LOCATION = "Location";
        public static final String CONTACTS = "Contacts";
        public static final String INFO = "Additional_info";
    }
}