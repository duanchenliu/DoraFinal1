package com.example.user.dorafinal1;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class displayAllAsync extends AsyncTask<Void, Void, List<MentalRecord>>{
    private AppDatabase db;
    public RecyclerView recyclerView;
    public RecyclerView.Adapter adapter;

    public Context context;

    List<MentalRecord> items; //TODO: list

    public displayAllAsync(AppDatabase db, RecyclerView recyclerView, RecyclerView.Adapter adapter, Context context ){
        this.db = db;
        this.recyclerView = recyclerView;
        this.adapter = adapter;
        this.context = context;
    }

    @Override
    protected List<MentalRecord> doInBackground(Void... voids) {
        items = db.databaseInterface().getAllItems();
        System.out.println("item size displayAll doinbackgroud: " + items.size() );
        return items;
    }

    @Override
    protected void onPostExecute(List<MentalRecord> s) {
        super.onPostExecute(s);
        adapter= new UserAdapter(items);
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);
        System.out.println("item size displayAll doinbackgroud: " + items.size() );
        MentalStateSummary.items = (ArrayList<MentalRecord>) items;
    }


}

