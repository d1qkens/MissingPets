package com.example.retrofittest;

import android.database.Cursor;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.retrofittest.databases.ContentApiProvider;
import com.example.retrofittest.databases.MissingPetsDatabase;


public class InfoPage extends ActionBarActivity {

    TextView nickname, address, gender, breed, color, contacts, other;
    public static final String NUMBER = "number";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_page);

        int number = getIntent().getIntExtra(NUMBER, 80);
        nickname = (TextView) findViewById(R.id.nickname);
        address = (TextView) findViewById(R.id.address);
        gender = (TextView) findViewById(R.id.gender);
        breed = (TextView) findViewById(R.id.breed_i);
        color = (TextView) findViewById(R.id.color_i);
        contacts = (TextView) findViewById(R.id.contacts_i);
        other = (TextView) findViewById(R.id.other_i);
        Cursor c = getContentResolver().query(ContentApiProvider.CONTENT_URI,
                null,
                MissingPetsDatabase.PetsTable.ID+"=?",
                new String[] {String.valueOf(number)},
                null);

        c.moveToFirst();


        if(c.getInt(c.getColumnIndex(MissingPetsDatabase.PetsTable.GENDER))==0) {
            gender.setText("Пол: женский");
        }
        else {
            gender.setText("Пол: мужской");
        }

        nickname.setText(c.getString(c.getColumnIndex(MissingPetsDatabase.PetsTable.NICKNAME)));
        address.setText(c.getString(c.getColumnIndex(MissingPetsDatabase.PetsTable.ADDRESS)));
        breed.setText(c.getString(c.getColumnIndex(MissingPetsDatabase.PetsTable.BREED)));
        color.setText(c.getString(c.getColumnIndex(MissingPetsDatabase.PetsTable.COLOR)));
        contacts.setText(c.getString(c.getColumnIndex(MissingPetsDatabase.PetsTable.CONTACTS)));
        other.setText(c.getString(c.getColumnIndex(MissingPetsDatabase.PetsTable.ADDITIONAL_INFO)));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_info_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }
}
