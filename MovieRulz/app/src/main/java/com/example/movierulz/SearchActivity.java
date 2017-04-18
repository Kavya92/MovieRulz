

package com.example.movierulz;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ListView;

import com.example.movierulz.model.DataItem;
import com.example.movierulz.sample.DataProvider;

import java.util.List;

/**
 * Created by devar on 14-04-2017.
 */
/*
public class SearchActivity extends ListActivity {
    List<DataItem> dataItemList = DataProvider.dataItemList;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        handleIntent(getIntent());
    }

    public void onNewIntent(Intent intent) {
        setIntent(intent);
        handleIntent(intent);
    }

    public void onListItemClick(ListView l,
                                View v, int position, long id) {
        // call detail activity for clicked entry
    }

    private void handleIntent(Intent intent) {
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query =
                    intent.getStringExtra(SearchManager.QUERY);
            doSearch(query);
        }
    }

    private void doSearch(String queryStr) {
        // get a Cursor, prepare the ListAdapter
        // and set it

        DataItemAdapter adapter = new DataItemAdapter(this, dataItemList);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvItems);

        recyclerView.setAdapter(adapter);
    }

}

*/

public class SearchActivity extends ListActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.layout.search_menu, menu);

        SearchManager searchManager = (SearchManager)
                getSystemService(Context.SEARCH_SERVICE);
        searchMenuItem = menu.findItem(R.id.search);
        searchView = (SearchView) searchMenuItem.getActionView();

        searchView.setSearchableInfo(searchManager.
                getSearchableInfo(getComponentName()));
        searchView.setSubmitButtonEnabled(true);
        searchView.setOnQueryTextListener(this);

        return true;
    }
}