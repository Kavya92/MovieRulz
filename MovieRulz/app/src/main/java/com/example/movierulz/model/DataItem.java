package com.example.movierulz.model;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;

import com.example.movierulz.database.ItemsTable;

import java.util.UUID;

/**
 * Created by devar on 07-03-2017.
 */

public class DataItem implements Parcelable {
    private String movieId;
    private String movieName;
    private String description;
    private String category;
    private String theatreLocation;
    private String theatreName;
    private String movieTime;
    private String image;

    public DataItem() {
    }



    public DataItem(String movieId, String movieName, String description,String category,String theatreLocation, String theatreName, String movieTime, String image) {

        if (movieId == null) {
            movieId = UUID.randomUUID().toString();
        }

        this.movieId = movieId;
        this.movieName =  movieName;
        this.description = description;
        this.category = category;
        this.theatreLocation = theatreLocation;
        this.theatreName = theatreName;
        this.movieTime = movieTime;
        this.image = image;
    }

    public String getMovieTime() {
        return movieTime;
    }

    public void setMovieTime(String movieTime) {
        this.movieTime = movieTime;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTheatreLocation() {
        return theatreLocation;
    }

    public void setTheatreLocation(String theatreLocation) {
        this.theatreLocation = theatreLocation;
    }

    public String getTheatreName() {
        return theatreName;
    }

    public void setTheatreName(String theatreName) {
        this.theatreName = theatreName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ContentValues toValues()
    {
        ContentValues values = new ContentValues(8);
        values.put(ItemsTable.COLUMN_ID,movieId);
        values.put(ItemsTable.COLUMN_NAME,movieName);
        values.put(ItemsTable.COLUMN_DESCRIPTION,description);
        values.put(ItemsTable.COLUMN_CATEGORY,category);
        values.put(ItemsTable.COLUMN_LOCATION,theatreLocation);
        values.put(ItemsTable.COLUMN_THEATRE,theatreName);
        values.put(ItemsTable.COLUMN_TIME,movieTime);
        values.put(ItemsTable.COLUMN_IMAGE,image);
        return values;
    }

    @Override
    public String toString() {
        return "DataItem{" +
                "movieId='" + movieId + '\'' +
                ", movieName='" + movieName + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", theatreLocation='" + theatreLocation + '\'' +
                ", theatreName='" + theatreName + '\'' +
                ", movieTime='" + movieTime + '\'' +
                ", image='" + image + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.movieId);
        dest.writeString(this.movieName);
        dest.writeString(this.description);
        dest.writeString(this.category);
        dest.writeString(this.theatreLocation);
        dest.writeString(this.theatreName);
        dest.writeString(this.movieTime);
        dest.writeString(this.image);
    }

    protected DataItem(Parcel in) {
        this.movieId = in.readString();
        this.movieName = in.readString();
        this.description = in.readString();
        this.category = in.readString();
        this.theatreLocation = in.readString();
        this.theatreName = in.readString();
        this.movieTime = in.readString();
        this.image = in.readString();
    }

    public static final Parcelable.Creator<DataItem> CREATOR = new Parcelable.Creator<DataItem>() {
        @Override
        public DataItem createFromParcel(Parcel source) {
            return new DataItem(source);
        }

        @Override
        public DataItem[] newArray(int size) {
            return new DataItem[size];
        }
    };
}
