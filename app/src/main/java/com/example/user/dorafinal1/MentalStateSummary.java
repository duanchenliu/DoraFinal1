package com.example.user.dorafinal1;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MentalStateSummary extends AppCompatActivity {

    public static RecyclerView recyclerView;
    public static RecyclerView.Adapter adapter;

    public static ArrayList<MentalRecord> items;
    public static Context context;

    public AppDatabase db;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mental_state_summary);

        items = new ArrayList<MentalRecord>();

        recyclerView= (RecyclerView)findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplication()));

        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, db.NAME).fallbackToDestructiveMigration().build();
        new displayAllAsync(db, recyclerView, adapter, context).execute();
    }
}
