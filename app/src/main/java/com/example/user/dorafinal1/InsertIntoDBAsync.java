package com.example.user.dorafinal1;

import android.os.AsyncTask;

public class InsertIntoDBAsync extends AsyncTask<MentalRecord,Void,Void> {
    private AppDatabase db;
    MentalRecord mr;

    public InsertIntoDBAsync(AppDatabase db){
        this.db = db;
    }

    @Override
    protected Void doInBackground(MentalRecord... mentalRecords) {
        mr = mentalRecords[0];
        db.databaseInterface().insertAll(mr);
        System.out.println("just added time " + mr.getTime());
        System.out.println("database size " + db.databaseInterface().getAllItems().size());
        return null;
    }
}
