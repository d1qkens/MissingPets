package com.example.retrofittest.Fragment;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.CursorLoader;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.retrofittest.AdapterFragment;
import com.example.retrofittest.InfoPage;
import com.example.retrofittest.R;
import com.example.retrofittest.data.model.PureAnimal;
import com.example.retrofittest.databases.ContentApiProvider;
import com.example.retrofittest.databases.MissingPetsDatabase;

public class ListFragment extends Fragment implements
        android.support.v4.app.LoaderManager.LoaderCallbacks<Cursor> {
    private static final int ID_LOADER = 0;
    private OnFragmentInteractionListener mListener;

    private AdapterFragment mAdapter;
    private Cursor mCursor;

    public ListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        LayoutInflater gridInflater = (LayoutInflater) getActivity().getSystemService(getActivity().LAYOUT_INFLATER_SERVICE);
        View view = gridInflater.inflate(R.layout.fragment_item, null);
        GridView gridView = (GridView) view.findViewById(android.R.id.list);

        mCursor = getActivity().getContentResolver().query(ContentApiProvider.CONTENT_URI, null, null, null, null);
        mAdapter = new AdapterFragment(getActivity(), mCursor, 0);
        gridView.setAdapter(mAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.e("Animals", "Listener");
                mCursor.moveToPosition(position);
                int number = mCursor.getInt(mCursor.getColumnIndex(MissingPetsDatabase.PetsTable.ID));

                Intent intent = new Intent(getActivity(), InfoPage.class);
                intent.putExtra(InfoPage.NUMBER, number);
                startActivity(intent);
                //Toast.makeText(getActivity(), "Click "+id, Toast.LENGTH_LONG).show();
            }
        });
        //setListAdapter(mAdapter);
        getActivity().getSupportLoaderManager().initLoader(ID_LOADER, null, this);

        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    @Override
    public android.support.v4.content.Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(getActivity(), ContentApiProvider.CONTENT_URI, null, null, null, null);
    }


    @Override
    public void onLoadFinished(android.support.v4.content.Loader<Cursor> loader, Cursor data) {
        mAdapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(android.support.v4.content.Loader<Cursor> loader) {
        mAdapter.swapCursor(null);
    }



    public interface OnFragmentInteractionListener {

        public void OnFragmentInteractionListener(PureAnimal missingPets);
    }
}
