package com.example.movierulz.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.example.movierulz.model.DataItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by devar on 07-03-2017.
 */

public class DataSource {
    private Context mContext;
    private SQLiteDatabase mDatabase;
    SQLiteOpenHelper mDbHelper;

    public DataSource(Context Context) {
        this.mContext = Context;
        mDbHelper = new DBHelper(mContext);
        mDatabase = mDbHelper.getWritableDatabase();
    }

    public void open() {
        mDatabase = mDbHelper.getWritableDatabase();
    }

    public void close() {
        mDbHelper.close();
    }



   public DataItem createItem(DataItem item)
    {
        ContentValues values = item.toValues();
        mDatabase.insert(ItemsTable.TABLE_ITEMS,null,values);
        return item;

    }

    public long getDataItemsCount() {
        return DatabaseUtils.queryNumEntries(mDatabase, ItemsTable.TABLE_ITEMS);
    }

    public void seedDatabase(List<DataItem> dataItemList)
    {
        long numItems = getDataItemsCount();
        if(numItems == 0)
        {

            for(DataItem item:dataItemList)
            {
                try {
                    createItem(item);
                } catch (SQLiteException e) {
                    e.printStackTrace();
                }
            }
            //Toast.makeText(this, "Data inserted!", Toast.LENGTH_SHORT).show();

        } /*else {
            Toast.makeText(this, "Data already inserted!", Toast.LENGTH_SHORT).show();
        }*/
    }

    public List<DataItem> getAllItems()
    {
        List<DataItem> dataItems = new ArrayList<>();
        Cursor cursor = mDatabase.query(ItemsTable.TABLE_ITEMS,ItemsTable.ALL_COLUMNS,null,null,null,null,null);
        while(cursor.moveToNext())
        {
            DataItem item = new DataItem();
            item.setMovieId(cursor.getString(cursor.getColumnIndex(ItemsTable.COLUMN_ID)));
            item.setMovieName(cursor.getString(
                    cursor.getColumnIndex(ItemsTable.COLUMN_NAME)));
            item.setDescription(cursor.getString(
                    cursor.getColumnIndex(ItemsTable.COLUMN_DESCRIPTION)));
            item.setCategory(cursor.getString(
                    cursor.getColumnIndex(ItemsTable.COLUMN_CATEGORY)));
            item.setTheatreLocation(cursor.getString(
                    cursor.getColumnIndex(ItemsTable.COLUMN_LOCATION))) ;
            item.setTheatreName(cursor.getString(
                    cursor.getColumnIndex(ItemsTable.COLUMN_THEATRE)));
            item.setMovieTime(cursor.getString(
                    cursor.getColumnIndex(ItemsTable.COLUMN_TIME)));
            item.setImage(cursor.getString(
                    cursor.getColumnIndex(ItemsTable.COLUMN_IMAGE)));
            dataItems.add(item);
        }
        return dataItems;
    }
}
