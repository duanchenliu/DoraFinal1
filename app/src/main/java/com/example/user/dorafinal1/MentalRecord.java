package com.example.user.dorafinal1;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

@Entity
public class MentalRecord implements Serializable {
    @PrimaryKey(autoGenerate=true)
    public int id;

    @ColumnInfo
    public String date;

    @ColumnInfo
    public String time;

    @ColumnInfo
    public int anxietyScore;

    @ColumnInfo
    public int motivationScore;

    @ColumnInfo
    public int emotionalStabilityScore;

    public MentalRecord(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getAnxietyScore() {
        return anxietyScore;
    }

    public void setAnxietyScore(int anxietyScore) {
        this.anxietyScore = anxietyScore;
    }

    public int getEmotionalStabilityScore() {
        return emotionalStabilityScore;
    }

    public void setEmotionalStabilityScore(int emotionalStabilityScore) {
        this.emotionalStabilityScore = emotionalStabilityScore;
    }

    public int getMotivationScore() {
        return motivationScore;
    }

    public void setMotivationScore(int motivationScore) {
        this.motivationScore = motivationScore;
    }
}
