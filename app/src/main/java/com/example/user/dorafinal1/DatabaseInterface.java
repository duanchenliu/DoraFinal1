package com.example.user.dorafinal1;

import android.arch.persistence.db.SupportSQLiteQuery;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.RawQuery;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface DatabaseInterface {

    @Query("SELECT * FROM MentalRecord")
    List<MentalRecord> getAllItems();

    @Query("SELECT * FROM MentalRecord Where id == :id")
    MentalRecord getIdZero(int id);

    @Insert
    void insertAll(MentalRecord... mentalRecords);

    //TODO: delete in database
//    //@Delete
//    @Query("DELETE FROM MentalRecord where eqid == :eqid")
//    public void deleteItems(String eqid);

    @Update
    public void updateItems(MentalRecord... mentalRecords);

    @Query("DELETE FROM MentalRecord")
    public void dropTheTable();

    @RawQuery
    int vacuumDb(SupportSQLiteQuery supportSQLiteQuery);
}
