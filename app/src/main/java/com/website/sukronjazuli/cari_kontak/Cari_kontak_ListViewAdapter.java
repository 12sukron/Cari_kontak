package com.website.sukronjazuli.cari_kontak;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Cari_kontak_ListViewAdapter extends BaseAdapter{

    //variables
    Context mContext;
    LayoutInflater inflater;
    List<Cari_kontak_Model> modellist;
    ArrayList<Cari_kontak_Model> arrayList;

    //constructor
    public Cari_kontak_ListViewAdapter(Context context, List<Cari_kontak_Model> modellist) {
        mContext = context;
        this.modellist = modellist;
        inflater = LayoutInflater.from(mContext);
        this.arrayList = new ArrayList<Cari_kontak_Model>();
        this.arrayList.addAll(modellist);
    }

    public class ViewHolder{
        TextView mTitleTv, mDescTv;
        ImageView mIconIv;
    }

    @Override
    public int getCount() {
        return modellist.size();
    }

    @Override
    public Object getItem(int i) {
        return modellist.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int postition, View view, ViewGroup parent) {
        ViewHolder holder;
        if (view==null){
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.cari_kontak_row, null);

            //locate the views in cari_rowi_row.xml
            holder.mTitleTv = view.findViewById(R.id.mainTitle);
            holder.mDescTv = view.findViewById(R.id.mainDesc);
            holder.mIconIv = view.findViewById(R.id.mainIcon);

            view.setTag(holder);

        }
        else {
            holder = (ViewHolder)view.getTag();
        }
        //set the results into textviews
        holder.mTitleTv.setText(modellist.get(postition).getTitle());
        holder.mDescTv.setText(modellist.get(postition).getDesc());
        //set the result in imageview
        holder.mIconIv.setImageResource(modellist.get(postition).getIcon());

        //listview item clicks
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //code later
                if (modellist.get(postition).getTitle().equals("nomor 1")){
                    //start Cari_kontak_NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, Cari_kontak_NewActivity.class);
                    intent.putExtra("contentTv", "deskripsi no 1");
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("nomor 2")){
                    //start Cari_kontak_NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, Cari_kontak_NewActivity.class);
                    intent.putExtra("contentTv", "deskripsi no 2");
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("nomor 3")){
                    //start Cari_kontak_NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, Cari_kontak_NewActivity.class);
                    intent.putExtra("contentTv", "deskripsi no 3");
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("nomor 4")){
                    //start Cari_kontak_NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, Cari_kontak_NewActivity.class);
                    intent.putExtra("contentTv", "deskripsi no 4");
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("nomor 5")){
                    //start Cari_kontak_NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, Cari_kontak_NewActivity.class);
                    intent.putExtra("contentTv", "deskripsi no 5");
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("nomor 6")){
                    //start Cari_kontak_NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, Cari_kontak_NewActivity.class);
                    intent.putExtra("contentTv", "deskripsi no 6");
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("nomor 7")){
                    //start Cari_kontak_NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, Cari_kontak_NewActivity.class);
                    intent.putExtra("contentTv", "deskripsi no 7");
                    mContext.startActivity(intent);
                }
            }
        });


        return view;
    }

    //filter
    public void filter(String charText){
        charText = charText.toLowerCase(Locale.getDefault());
        modellist.clear();
        if (charText.length()==0){
            modellist.addAll(arrayList);
        }
        else {
            for (Cari_kontak_Model model : arrayList){
                if (model.getTitle().toLowerCase(Locale.getDefault())
                        .contains(charText)){
                    modellist.add(model);
                }
            }
        }
        notifyDataSetChanged();
    }

}