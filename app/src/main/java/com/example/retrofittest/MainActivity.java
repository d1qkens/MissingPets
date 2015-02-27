package com.example.retrofittest;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.Toast;

import com.example.retrofittest.databases.ContentApiProvider;
import com.example.retrofittest.network.AsyncServerQuery;

public class MainActivity extends ActionBarActivity {
    public AsyncServerQuery serverQuery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(isOnline()) {
            getContentResolver().delete(ContentApiProvider.CONTENT_URI, null, null);
            serverQuery = (AsyncServerQuery) new AsyncServerQuery(this).execute();
        }
        else Toast.makeText(this, "Нет соединения с сетью!", Toast.LENGTH_LONG).show();

    }

    public boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        }
        return false;
    }


}
