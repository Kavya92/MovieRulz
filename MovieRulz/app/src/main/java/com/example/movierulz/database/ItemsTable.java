package com.example.movierulz.database;

/**
 * Created by devar on 07-03-2017.
 */

public class ItemsTable {



    public static final String TABLE_ITEMS = "movies";
    public static final String COLUMN_ID = "movieId";
    public static final String COLUMN_NAME = "movieName";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_CATEGORY = "category";
    public static final String COLUMN_LOCATION = "theatreLocation";
    public static final String COLUMN_THEATRE = "theatreName";
    public static final String COLUMN_TIME = "movieTime";
    public static final String COLUMN_IMAGE = "image";

    public static final String[] ALL_COLUMNS =
            {
                    COLUMN_ID,COLUMN_NAME,COLUMN_DESCRIPTION,COLUMN_CATEGORY,COLUMN_LOCATION,COLUMN_THEATRE,
                    COLUMN_TIME,COLUMN_IMAGE
            };


    public static final String SQL_CREATE =
            "CREATE TABLE " + TABLE_ITEMS + "(" +
                    COLUMN_ID + " TEXT PRIMARY KEY," +
                    COLUMN_NAME + " TEXT," +
                    COLUMN_DESCRIPTION + " TEXT," +
                    COLUMN_CATEGORY + " TEXT," +
                    COLUMN_LOCATION + " TEXT," +
                    COLUMN_THEATRE + " REAL," +
                    COLUMN_TIME + " TEXT," +
                    COLUMN_IMAGE + " TEXT" + ");";

    public static final String SQL_DELETE =
            "DROP TABLE " + TABLE_ITEMS;
}
