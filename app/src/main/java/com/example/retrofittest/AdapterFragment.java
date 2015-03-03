package com.example.retrofittest;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.widget.CursorAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.retrofittest.databases.MissingPetsDatabase;

public class AdapterFragment extends CursorAdapter{
    private static final String LOG ="Animals" ;
    private final Context context;

    public AdapterFragment(Context context, Cursor c, int flags) {
        super(context, c, flags);
        this.context=context;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }




    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        LayoutInflater mLayout = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        return mLayout.inflate(R.layout.pets_raw, parent, false);

    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ImageView image = (ImageView) view.findViewById(R.id.dogImage);
        TextView nickname = (TextView) view.findViewById(R.id.nickname);
        TextView address = (TextView) view.findViewById(R.id.address);

        String image_title  = cursor.getString(cursor.getColumnIndex(MissingPetsDatabase.PetsTable.PHOTO));
        String nickname_title  = cursor.getString(cursor.getColumnIndex(MissingPetsDatabase.PetsTable.NICKNAME));
        String address_title  = cursor.getString(cursor.getColumnIndex(MissingPetsDatabase.PetsTable.ADDRESS));

        if (cursor.moveToLast()) {

            Bitmap img;
            if ((img = BitmapFactory.decodeFile(image_title)) != null) {
                image.setImageBitmap(img);
            } else {
                image.setImageResource(R.drawable.doggie);
                Log.d(LOG, "add image launcher");
            }
            if(nickname_title!=null){
                nickname.setText(nickname_title);
            }else
                nickname.setText("not have nickname");
            if(address_title!=null){
                address.setText(address_title);
            }else
                address.setText("not have address");
        }
    }

}
