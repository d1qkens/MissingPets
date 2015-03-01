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
                .setEndpoint(Address.URL)  //call your base url
                .build();


        MyApi myDog = restAdapter.create(MyApi.class); //this is how retrofit create your api
        //PureAnimal animal = new PureAnimal();
//        animal.setPet_type_id(1);
//        animal.setGender(true);
//        animal.setNickname("Джекки");
//        animal.setBreed("Боксер");
//        animal.setColor("белый");
//        animal.setLocation_lat(11.01);
//        animal.setLocation_lon(01.11);
//        animal.setAddress("Крытый рынок");
//        animal.setContacts("0522334422");
//        animal.setAdditional_info("Хромает");
//        animal.setPhoto("http://afsddsf.com/sdf.jpg");
//        PureAnimal newAnimal = myDog.addAnimal(animal);

        //context.getContentResolver().insert(ContentApiProvider.CONTENT_URI, putData(newAnimal));
                //myDog.addAnimal(1, true, "Чакки", "Боксер", "белый", 11.21, 33.1, "Крытый рынок", "0522334422", "Хромает", "http://");
        PureAnimal[] animals = myDog.fetchAnimal();
        return animals;
    }

    @Override
    protected void onPostExecute(PureAnimal[] animals) {

        for (int i = 0; i < animals.length; i++) {
            ContentValues contentValues = putData(animals[i]);
            context.getContentResolver().insert(ContentApiProvider.CONTENT_URI, contentValues);
        }

    }

    public static ContentValues putData(PureAnimal animal) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(MissingPetsDatabase.PetsTable.REMOTE_ID, animal.getRemoteId());
        contentValues.put(MissingPetsDatabase.PetsTable.PET_TYPE_ID, animal.getPetTypeId());
        contentValues.put(MissingPetsDatabase.PetsTable.GENDER, animal.getGender());
        contentValues.put(MissingPetsDatabase.PetsTable.NICKNAME, animal.getNickname());
        contentValues.put(MissingPetsDatabase.PetsTable.BREED, animal.getBreed());
        contentValues.put(MissingPetsDatabase.PetsTable.COLOR, animal.getColor());
        contentValues.put(MissingPetsDatabase.PetsTable.LOCATION_LAT, animal.getLocationLat());
        contentValues.put(MissingPetsDatabase.PetsTable.LOCATION_LON, animal.getLocationLon());
        contentValues.put(MissingPetsDatabase.PetsTable.ADDRESS, animal.getAddress());
        contentValues.put(MissingPetsDatabase.PetsTable.CONTACTS, animal.getContacts());
        contentValues.put(MissingPetsDatabase.PetsTable.ADDITIONAL_INFO, animal.getInfo());
        contentValues.put(MissingPetsDatabase.PetsTable.PHOTO, animal.getPhoto());
        return contentValues;
    }

}

