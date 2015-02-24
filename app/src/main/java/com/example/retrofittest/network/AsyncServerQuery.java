package com.example.retrofittest.network;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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
                .setEndpoint(Address.URL)  //call your base url
                .build();


        MyApi myDog = restAdapter.create(MyApi.class); //this is how retrofit create your api
        PureAnimal[] animals = myDog.fetchAnimal();
        return animals;
    }

    @Override
    protected void onPostExecute(PureAnimal[] animals) {

        for (int i = 0; i < animals.length; i++) {
            Cursor c = context.getContentResolver().query(ContentApiProvider.CONTENT_URI,
                    new String[] {MissingPetsDatabase.PetsTable.ID},
                    MissingPetsDatabase.PetsTable.ID+"=?", new String[] {String.valueOf(animals[i].getId())},
                    null);
            if(c.getCount()<=0){
                ContentValues contentValues = new ContentValues();
                contentValues.put(MissingPetsDatabase.PetsTable.ID, animals[i].getId());
                contentValues.put(MissingPetsDatabase.PetsTable.PET, animals[i].getPet());
                contentValues.put(MissingPetsDatabase.PetsTable.GENDER, animals[i].getGender());
                contentValues.put(MissingPetsDatabase.PetsTable.NICKNAME, animals[i].getNickname());
                contentValues.put(MissingPetsDatabase.PetsTable.BREED, animals[i].getBreed());
                contentValues.put(MissingPetsDatabase.PetsTable.COLOR, animals[i].getColor());
                contentValues.put(MissingPetsDatabase.PetsTable.LOCATION, animals[i].getLocation());
                contentValues.put(MissingPetsDatabase.PetsTable.CONTACTS, animals[i].getContacts());
                contentValues.put(MissingPetsDatabase.PetsTable.INFO, animals[i].getInfo());
                context.getContentResolver().insert(ContentApiProvider.CONTENT_URI, contentValues);
            }

        }
    }
}
