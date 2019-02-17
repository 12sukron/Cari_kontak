package com.website.sukronjazuli.cari_kontak;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

public class Cari_kontak_MainActivity extends AppCompatActivity {

    ListView listView;
    Cari_kontak_ListViewAdapter adapter;
    String[] title;
    String[] description;
    int[] icon;
    ArrayList<Cari_kontak_Model> arrayList = new ArrayList<Cari_kontak_Model>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cari_kontak_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Cari Kontak");

        title = new String[]{"nomor 1", "nomor 2", "nomor 3", "nomor 4", "nomor 5","nomor 6","nomor 7"};
        description = new String[]{"deskripsi no 1", "deskripsi no 2", "deskripsi no 3", "deskripsi no 4", "deskripsi no 5", "deskripsi no 6", "deskripsi no 7"};
        icon = new int[]{R.drawable.no1, R.drawable.no2, R.drawable.no3, R.drawable.no4, R.drawable.no5, R.drawable.no6, R.drawable.no7};

        listView = (ListView) findViewById(R.id.listView);

        for (int i =0; i<title.length; i++){
            Cari_kontak_Model model = new Cari_kontak_Model(title[i], description[i], icon[i]);
            //bind all strings in an array
            arrayList.add(model);
        }

        //pass results to listViewAdapter class
        adapter = new Cari_kontak_ListViewAdapter(this, arrayList);

        //bind the adapter to the listview
        listView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        MenuItem myActionMenuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView)myActionMenuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                if (TextUtils.isEmpty(s)){
                    adapter.filter("");
                    listView.clearTextFilter();
                }
                else {
                    adapter.filter(s);
                }
                return true;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id== R.id.action_settings){
            //do your functionality here
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}