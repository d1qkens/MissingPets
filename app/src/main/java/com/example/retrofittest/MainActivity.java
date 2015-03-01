package com.example.retrofittest;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Toast;

import com.example.retrofittest.Fragment.ListFragment;
import com.example.retrofittest.data.model.PureAnimal;
import com.example.retrofittest.databases.ContentApiProvider;
import com.example.retrofittest.network.AsyncServerQuery;
import com.gc.materialdesign.views.ButtonFloat;

public class MainActivity extends ActionBarActivity implements ListFragment.OnFragmentInteractionListener {
    public AsyncServerQuery serverQuery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (isOnline()) {
            getContentResolver().delete(ContentApiProvider.CONTENT_URI, null, null);
            serverQuery = (AsyncServerQuery) new AsyncServerQuery(this).execute();
        } else
            Toast.makeText(this, "Нет соединения с сетью!", Toast.LENGTH_LONG).show();
        ButtonFloat buttonFloat = (ButtonFloat) findViewById(R.id.buttonFloat);
        buttonFloat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, RegisteredMissingPets.class);
                startActivity(myIntent);
            }
        });

    }

    public boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        }
        return false;
    }



    @Override
    public void onFragmentInteraction(PureAnimal missingPets) {

    }
}
