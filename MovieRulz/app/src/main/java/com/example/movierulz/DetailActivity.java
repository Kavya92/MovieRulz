package com.example.movierulz;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.movierulz.model.DataItem;

import java.io.IOException;
import java.io.InputStream;
import java.text.NumberFormat;
import java.util.Locale;

@SuppressWarnings("FieldCanBeLocal")
public class DetailActivity extends AppCompatActivity {

    private TextView movieName, theatreName,movieDescription,movieTimings,movieCategory,movieLocation;
    private ImageView movieImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        DataItem item = getIntent().getExtras().getParcelable(DataItemAdapter.ITEM_KEY);
        if (item == null) {
            throw new AssertionError("Null data item received!");
        }

        movieName = (TextView) findViewById(R.id.movieName);
        theatreName = (TextView) findViewById(R.id.theatreName);
        movieDescription = (TextView) findViewById(R.id.movieDescription);
        movieTimings = (TextView) findViewById(R.id.movieTimings);
        movieCategory = (TextView) findViewById(R.id.movieCategory);
        movieLocation = (TextView) findViewById(R.id.movieLocation);
        movieImage = (ImageView) findViewById(R.id.movieImage);

        movieName.setText(item.getMovieName());
        movieDescription.setText(item.getDescription());
        movieTimings.setText(item.getMovieTime());
        movieCategory.setText(item.getCategory());
        movieLocation.setText(item.getTheatreLocation());
        theatreName.setText(item.getTheatreName());

//        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.getDefault());
  //      tvPrice.setText(nf.format(item.getPrice()));

        InputStream inputStream = null;
        try {
            String imageFile = item.getImage();
            inputStream = getAssets().open(imageFile);
            Drawable d = Drawable.createFromStream(inputStream, null);
            movieImage.setImageDrawable(d);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}