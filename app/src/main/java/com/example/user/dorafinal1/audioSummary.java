package com.example.user.dorafinal1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class audioSummary extends AppCompatActivity {

    Button btnOne, btnTwo, btnThree;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_summary);

        btnOne = (Button) findViewById(R.id.btnOne);
        btnTwo = (Button) findViewById(R.id.btnTwo);
        btnThree = (Button) findViewById(R.id.btnThree);

        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toaudioOne;
                toaudioOne = new Intent(getApplicationContext(), audioOne.class);
                startActivity(toaudioOne);
            }
        });

        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toaudioTwo;
                toaudioTwo = new Intent(getApplicationContext(), audioTwo.class);
                startActivity(toaudioTwo);
            }
        });

        btnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toaudioThree;
                toaudioThree = new Intent(getApplicationContext(), audioThree.class);
                startActivity(toaudioThree);
            }
        });
    }
}
