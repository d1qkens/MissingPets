package com.example.retrofittest.network;

import android.content.ContentValues;
import android.content.Context;
import android.os.AsyncTask;

import com.example.retrofittest.Address;
import com.example.retrofittest.MyApi;
import com.example.retrofittest.data.model.PureAnimal;
import com.example.retrofittest.databases.ContentApiProvider;
import com.example.retrofittest.databases.MissingPetsDatabase;

import retrofit.RestAdapter;

public class AsyncServerQuery extends AsyncTask<Void, Void, PureAnimal[]> {
    Context context;

    public AsyncServerQuery(Context context) {
        this.context = context;
    }

    @Override
    protected PureAnimal[] doInBackground(Void... params) {

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(Address.URL)
                .setLogLevel(RestAdapter.LogLevel.HEADERS_AND_ARGS)
                .build();
        MyApi myDog = restAdapter.create(MyApi.class);





        return myDog.fetchAnimal();
    }

    @Override
    protected void onPostExecute(PureAnimal[] animals) {
        for (PureAnimal animal : animals) {
            ContentValues contentValues = putData(animal);
            context.getContentResolver().insert(ContentApiProvider.CONTENT_URI, contentValues);
        }
    }

    public static ContentValues putData(PureAnimal animal) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(MissingPetsDatabase.PetsTable.REMOTE_ID, animal.getRemoteId());
        contentValues.put(MissingPetsDatabase.PetsTable.PET_TYPE_ID, animal.getPetType());
        contentValues.put(MissingPetsDatabase.PetsTable.GENDER, animal.getGender());
        contentValues.put(MissingPetsDatabase.PetsTable.NICKNAME, animal.getNickname());
        contentValues.put(MissingPetsDatabase.PetsTable.BREED, animal.getBreed());
        contentValues.put(MissingPetsDatabase.PetsTable.COLOR, animal.getColor());
        contentValues.put(MissingPetsDatabase.PetsTable.LOCATION_LAT, animal.getLocationLat());
        contentValues.put(MissingPetsDatabase.PetsTable.LOCATION_LON, animal.getLocationLog());
        contentValues.put(MissingPetsDatabase.PetsTable.ADDRESS, animal.getAddress());
        contentValues.put(MissingPetsDatabase.PetsTable.CONTACTS, animal.getContacts());
        contentValues.put(MissingPetsDatabase.PetsTable.ADDITIONAL_INFO, animal.getInfo());
        contentValues.put(MissingPetsDatabase.PetsTable.PHOTO, animal.getPhoto());
        return contentValues;
    }

}

