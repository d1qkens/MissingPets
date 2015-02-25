package com.example.retrofittest;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import com.example.retrofittest.network.AsyncServerQuery;

public class MainActivity extends ActionBarActivity {
    public AsyncServerQuery serverQuery;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;
        serverQuery = (AsyncServerQuery) new AsyncServerQuery(context).execute();
    }


}
