package com.example.movierulz;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.movierulz.model.DataItem;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class DataItemAdapterListView extends ArrayAdapter<DataItem> {
    List<DataItem> mDataItems;
    LayoutInflater mInflater;

    public DataItemAdapterListView(Context context, List<DataItem> objects) {
        super(context,R.layout.new_layout,objects);

        mDataItems = objects;
        mInflater = LayoutInflater.from(context);

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.new_layout, parent, false);
        }

        TextView theatreName = (TextView) convertView.findViewById(R.id.theatreNameText);
        TextView timings = (TextView) convertView.findViewById(R.id.timingsText);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView);

        DataItem item = mDataItems.get(position);

        theatreName.setText(item.getTheatreName());
        timings.setText(item.getMovieTime());
        //imageView.setImageResource(R.drawable.image_1);

        InputStream inputStream = null;
        try {
            String imageFile = item.getImage();
            inputStream = getContext().getAssets().open(imageFile);
            Drawable d = Drawable.createFromStream(inputStream,null);
            imageView.setImageDrawable(d);
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if(inputStream != null)
                {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return convertView;
    }
}
