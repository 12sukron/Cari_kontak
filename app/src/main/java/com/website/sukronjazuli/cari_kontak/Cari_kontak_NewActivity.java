package com.website.sukronjazuli.cari_kontak;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Cari_kontak_NewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cari_kontak_new);

        ActionBar actionBar = getSupportActionBar();
        TextView mDetailTv = (TextView) findViewById(R.id.textView);

        //get data from previous activity when item of listview is clicked using intent
        Intent intent = getIntent();

//        String mActionBarTitle = intent.getStringExtra("actionBarTitle");   // UNTUK JUDUL LANGIT" ATAS
        String mContent = intent.getStringExtra("contentTv");

        //set actionbar title
//        actionBar.setTitle(mActionBarTitle);          // UNTUK JUDUL LANGIT ATAS
        //set text in textview
        mDetailTv.setText(mContent);



    }
}