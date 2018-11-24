package com.example.user.dorafinal1;

import android.app.Activity;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.time.LocalDate;
import java.time.LocalTime;

import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class PsychologyQuizSummary extends AppCompatActivity {
    TextView tvanxiety;
    TextView tvmotivation;
    TextView tvemotionalStability;
    Button submit;
    AppDatabase db;
    int anxietyScore, motivationScore, emotionalStabilityScore;
    String anxietyLevel, motivationLevel, emotionalStabilityLevel;
    TextView tvanxietyDetail, tvmotivationDetail, tvemotionalStabilityDetail;
    //Intent myLocalIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_psychology_quiz_summary2);

        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, db.NAME).fallbackToDestructiveMigration().build();

        tvanxiety = (TextView) findViewById(R.id.tvanxiety);
        tvmotivation = (TextView) findViewById(R.id.tvmotivation);
        tvemotionalStability = (TextView) findViewById(R.id.tvemotionalStability);

        tvanxietyDetail = (TextView) findViewById(R.id.tvanxietyDetail);
        tvmotivationDetail = (TextView) findViewById(R.id.tvmotivationDetail);
        tvemotionalStabilityDetail = (TextView) findViewById(R.id.tvemotionalStabilityDetail);

        submit = (Button) findViewById(R.id.submit);

        //myLocalIntent = getIntent();
        Intent myLocalIntent = getIntent();
        Bundle myData = myLocalIntent.getExtras();

        anxietyScore = myData.getInt("AnxietyScore");
        motivationScore = myData.getInt("MotivationScore");
        emotionalStabilityScore = myData.getInt("EmotionalStabilityScore");

        //Anxiety score detail: more score -> more anxiety. Highest Score: 9. Lowest Score: 0.
        //        Anxiety Levels:
        //              High: 7,8,9 stressed
        //              Medium: 4,5,6
        //              Low: 0,1,2,3

        //Motivation score detial: more score -> more motivated and more intrinsically motivated: Highest Score: 9, Lowest Score: 0.
        //        Motivation Levels:
        //              High: 7,8,9 motivated
        //              Medium: 4,5,6
        //              Low: 0,1,2,3

        //Neuroticism OR Emotional Stability: more score ->  more emotional stable/less neuroticism.
        //        Emotional Stability Levels:
        //              High: 7,8,9 stable
        //              Medium: 4,5,6
        //              Low: 0,1,2,3

        //find anxiety level:
        if (anxietyScore < 4){
            anxietyLevel = "Low"; // good
        }else if(anxietyScore < 7){
            anxietyLevel = "Medium";
        }else{
            anxietyLevel = "High";
        }

        //find motivation level:
        if (motivationScore < 4){
            motivationLevel = "Low"; //
        }else if(motivationScore < 7){
            motivationLevel = "Medium";
        }else{
            motivationLevel = "High"; // good
        }

        //find emotional stability level:
        if (emotionalStabilityScore < 4){
            emotionalStabilityLevel = "Low"; //
        }else if(emotionalStabilityScore < 7){
            emotionalStabilityLevel = "Medium";
        }else{
            emotionalStabilityLevel = "High"; // good
        }


        tvanxiety.setText(anxietyLevel+ ": "+ anxietyScore);
        if (anxietyLevel == "High"){
            tvanxiety.setBackgroundColor(getResources().getColor(R.color.Crimson));
            tvanxietyDetail.setText(getString(R.string.AnxietyHigh));
        }else if(anxietyLevel == "Medium"){
            tvanxiety.setBackgroundColor(getResources().getColor(R.color.Coral));
            tvanxietyDetail.setText(getString(R.string.AnxietyMenium));
        }else{
            tvanxiety.setBackgroundColor(getResources().getColor(R.color.Aquamarine));
            tvanxietyDetail.setText(getString(R.string.AnxietyLow));
        }
        tvmotivation.setText(motivationLevel+ ": " + motivationScore);
        if (motivationLevel == "Low"){
            tvmotivation.setBackgroundColor(getResources().getColor(R.color.Crimson));
            tvmotivationDetail.setText(getString(R.string.MotivationLow));
        }else if (motivationLevel=="Medium"){
            tvmotivation.setBackgroundColor(getResources().getColor(R.color.Coral));
            tvmotivationDetail.setText(getString(R.string.MotivationMedium));
        }else{
            tvmotivation.setBackgroundColor(getResources().getColor(R.color.Aquamarine));
            tvmotivationDetail.setText(getString(R.string.MotivationHigh));
        }
        tvemotionalStability.setText(emotionalStabilityLevel+": "+emotionalStabilityScore); //TODO: elaborate on how to display the result
        if (emotionalStabilityLevel == "Low") {
            tvemotionalStability.setBackgroundColor(getResources().getColor(R.color.Crimson));
            tvemotionalStabilityDetail.setText(getString(R.string.EmotionalStabilityLow));
        }else if(emotionalStabilityLevel=="Medium"){
            tvemotionalStability.setBackgroundColor(getResources().getColor(R.color.Coral));
            tvemotionalStabilityDetail.setText(getString(R.string.EmotionalStabilityMedium));
        }else{
            tvemotionalStability.setBackgroundColor(getResources().getColor(R.color.Aquamarine));
            tvemotionalStabilityDetail.setText(getString(R.string.EmotionalStabilityHigh));
        }


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //get the date and time submitting the assessment
                Date d = new Date();
                String date = d.toString().substring(0,10);
                String time = d.toString().substring(11);

                System.out.println(d.toString());
                System.out.println("Date: "+d.toString().substring(0,10));
                System.out.println("Time: "+d.toString().substring(11));


                //Create a new Mental Record:
                MentalRecord newMentalRecord = new MentalRecord();
                newMentalRecord.setDate(date);
                newMentalRecord.setTime(time);
                newMentalRecord.setAnxietyScore(anxietyScore);
                newMentalRecord.setEmotionalStabilityScore(emotionalStabilityScore);
                newMentalRecord.setMotivationScore(motivationScore);

                //insert the newMentalRecord into the database
//                db.databaseInterface().insertAll(newMentalRecord);//TODO: null, Cannot access database on the main thread since it may potentially lock the UI for a long period of time.
//                System.out.println(db.databaseInterface().getAllItems().size());

                new InsertIntoDBAsync(db).execute(newMentalRecord);

                //Go back to the mainActivity
//                Intent toMain = new Intent(getApplicationContext(),MainActivity.class);
//                toMain.putExtra("newRecord", newMentalRecord);
//                startActivity(toMain);

                Intent intent = new Intent();
//                Bundle bundle = new Bundle();
//                bundle.putSerializable("mentalRecord", newMentalRecord);
//                intent.putExtras(bundle);
                intent.putExtra("mentalRecord", newMentalRecord);
                setResult(RESULT_OK, intent);
                finish();

            }
        });
    }

    @Override
    protected void onStop(){
        super.onStop();
        db.close();
        finish();
    }

    @Override
    protected void onPause(){
        super.onPause();
        db.close();
    }
}
