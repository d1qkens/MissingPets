package com.example.retrofittest;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.retrofittest.databases.ContentApiProvider;
import com.example.retrofittest.databases.MissingPetsDatabase;
import com.example.retrofittest.network.AsyncServerQuery;


public class MainActivity extends ActionBarActivity {
    public AsyncServerQuery serverQuery;
    Context context;
    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;
        serverQuery = (AsyncServerQuery) new AsyncServerQuery(context).execute();

        button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] projection = new String[] {MissingPetsDatabase.PetsTable.CONTACTS};
                Cursor cursor = context.getContentResolver().query(ContentApiProvider.CONTENT_URI,
                        null,
                        null,
                        null,
                        null);
                cursor.moveToFirst();

                String dogInfo="";
                for(int i=0; i<8; i++) {
                    dogInfo+=cursor.getString(i)+"\n";
                }
                textView.setText(dogInfo);
            }
        });
    }


}
