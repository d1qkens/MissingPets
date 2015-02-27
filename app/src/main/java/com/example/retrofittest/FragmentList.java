package com.example.retrofittest;

import android.annotation.TargetApi;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.example.retrofittest.databases.ContentApiProvider;
import com.example.retrofittest.databases.MissingPetsDatabase;

public class FragmentList extends Fragment implements LoaderManager.LoaderCallbacks<Cursor> {
    public static final int PETS_INFO_LOADER = 1;
    ListView listView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onPause() {
        super.onPause();
        getActivity().getSupportLoaderManager().restartLoader(PETS_INFO_LOADER, null, this);
    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().getSupportLoaderManager().restartLoader(PETS_INFO_LOADER, null, this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        listView = (ListView) view.findViewById(R.id.listView);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getLoaderManager().initLoader(1, null, this);
    }

    //____________________________________________________________________
    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        String[] projection = new String[] {MissingPetsDatabase.PetsTable.ID,
                MissingPetsDatabase.PetsTable.NICKNAME,
                MissingPetsDatabase.PetsTable.ADDRESS };

        Uri baseUri = ContentApiProvider.CONTENT_URI;
        switch (id) {
            case PETS_INFO_LOADER :
                return new CursorLoader(getActivity(), baseUri, projection, null, null, null);
        }
        return null;
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        if(loader.getId()==PETS_INFO_LOADER) {

            SimpleCursorAdapter adapter = new SimpleCursorAdapter(getActivity(), R.layout.pets_raw,
                    data,
                    new String[] {MissingPetsDatabase.PetsTable.ADDRESS, MissingPetsDatabase.PetsTable.NICKNAME},
                    new int[] {R.id.address, R.id.nickname}, 0);
            listView.setAdapter(adapter);
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }
    //____________________________________________________________________


//    public static class PetsInfoAdapter extends SimpleCursorAdapter {
//        Context context;
//        Cursor cursor;
//
//        public PetsInfoAdapter(Context context, int layout, Cursor c, String[] from, int[] to, int flags) {
//            super(context, layout, c, from, to, flags);
//            cursor = c;
//        }
//
//
//        @Override
//        public int getCount() {
//            return cursor.getCount();
//        }
//
//        @Override
//        public Object getItem(int position) {
//            return position;
//        }
//
//        @Override
//        public long getItemId(int position) {
//            return position;
//        }
//
//        @Override
//        public View getView(int position, View convertView, ViewGroup parent) {
//            View row = convertView;
//            if (row == null) {
//                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//                row = inflater.inflate(R.layout.pets_raw, parent, false);
//            }
//
//            return row;
//        }
//    }

}
