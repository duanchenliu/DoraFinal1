package com.example.user.dorafinal1;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class PsychologyQuiz extends AppCompatActivity {

    Button answer1, answer2, answer3,answer4;
    TextView question;

    private Questions mQuestions = new Questions();

    private String mThreePointAnswer, mTwoPointAnswer, mOnePointAnswer, mZeroPointAnswer;
    private int anxiety, motivation, emotionalStability = 0;
    private int mQuestionsLength = mQuestions.mQuestions.length;

    int r;

    //Intent myLocalIntent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_psychology_quiz);
        //myLocalIntent = getIntent();

        r = 0;

        answer1 = (Button) findViewById(R.id.answer1);
        answer2 = (Button) findViewById(R.id.answer2);
        answer3 = (Button) findViewById(R.id.answer3);
        answer4 = (Button) findViewById(R.id.answer4);

        question = (TextView) findViewById(R.id.question);


        updateQuestion(r);


        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (answer1.getText() == mThreePointAnswer){
                    if (r<=2){
                        anxiety = anxiety + 3;
                    }else if (r<=5){
                        motivation = motivation + 3;
                    }else{
                        emotionalStability = emotionalStability + 3;
                    }
                }else if(answer1.getText() == mTwoPointAnswer){
                    if (r<=2){
                        anxiety = anxiety + 2;
                    }else if(r<=5){
                        motivation = motivation + 2;
                    }else{
                        emotionalStability = emotionalStability + 2;
                    }
                }else if(answer1.getText() == mOnePointAnswer){
                    if (r<=2){
                        anxiety = anxiety + 1;
                    }else if(r<=5){
                        motivation = motivation + 1;
                    }else{
                        emotionalStability = emotionalStability + 1;
                    }
                }else{
                    if (r<=2){
                        anxiety = anxiety + 0;
                    }else if(r<=5){
                        motivation = motivation + 0;
                    }else{
                        emotionalStability = emotionalStability + 0;
                    }
                }
                if (r < mQuestionsLength-1){
                    r++;
                    updateQuestion(r);
                }else{
                    Intent toSummary = new Intent(getApplicationContext(), PsychologyQuizSummary.class);
                    toSummary.setFlags(Intent.FLAG_ACTIVITY_FORWARD_RESULT);
                    toSummary.putExtra("AnxietyScore", anxiety);
                    System.out.println("final anxiety score: " + anxiety);
                    toSummary.putExtra("MotivationScore", motivation);
                    System.out.println("final motivation score: " + motivation);
                    toSummary.putExtra("EmotionalStabilityScore", emotionalStability);
                    System.out.println("final emotional score: " + emotionalStability);
                    //toSummary.putExtras(myLocalIntent);
                    startActivity(toSummary);
                    finish();
                    //startActivityForResult(toSummary, 101);
                }

            }
        });

        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (answer2.getText() == mThreePointAnswer){
                    if (r<=2){
                        anxiety = anxiety + 3;
                    }else if (r<=5){
                        motivation = motivation + 3;
                    }else{
                        emotionalStability = emotionalStability + 3;
                    }
                }else if(answer2.getText() == mTwoPointAnswer){
                    if (r<=2){
                        anxiety = anxiety + 2;
                    }else if(r<=5){
                        motivation = motivation + 2;
                    }else{
                        emotionalStability = emotionalStability + 2;
                    }
                }else if(answer2.getText() == mOnePointAnswer){
                    if (r<=2){
                        anxiety = anxiety + 1;
                    }else if(r<=5){
                        motivation = motivation + 1;
                    }else{
                        emotionalStability = emotionalStability + 1;
                    }
                }else{
                    if (r<=2){
                        anxiety = anxiety + 0;
                    }else if(r<=5){
                        motivation = motivation + 0;
                    }else{
                        emotionalStability = emotionalStability + 0;
                    }
                }
                if (r < mQuestionsLength-1){
                    r++;
                    updateQuestion(r);
                }else{
                    Intent toSummary = new Intent(getApplicationContext(), PsychologyQuizSummary.class);
                    toSummary.setFlags(Intent.FLAG_ACTIVITY_FORWARD_RESULT);
                    toSummary.putExtra("AnxietyScore", anxiety);
                    toSummary.putExtra("MotivationScore", motivation);
                    toSummary.putExtra("EmotionalStabilityScore", emotionalStability);
                    //toSummary.putExtras(myLocalIntent);
                    startActivity(toSummary);
                    finish();
                    //startActivityForResult(toSummary, 101);
                }
            }
        });

        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (answer3.getText() == mThreePointAnswer){
                    if (r<=2){
                        anxiety = anxiety + 3;
                    }else if (r<=5){
                        motivation = motivation + 3;
                    }else{
                        emotionalStability = emotionalStability + 3;
                    }
                }else if(answer3.getText() == mTwoPointAnswer){
                    if (r<=2){
                        anxiety = anxiety + 2;
                    }else if(r<=5){
                        motivation = motivation + 2;
                    }else{
                        emotionalStability = emotionalStability + 2;
                    }
                }else if(answer3.getText() == mOnePointAnswer){
                    if (r<=2){
                        anxiety = anxiety + 1;
                    }else if(r<=5){
                        motivation = motivation + 1;
                    }else{
                        emotionalStability = emotionalStability + 1;
                    }
                }else{
                    if (r<=2){
                        anxiety = anxiety + 0;
                    }else if(r<=5){
                        motivation = motivation + 0;
                    }else{
                        emotionalStability = emotionalStability + 0;
                    }
                }
                if (r < mQuestionsLength-1){
                    r++;
                    updateQuestion(r);
                }else{
                    Intent toSummary = new Intent(getApplicationContext(), PsychologyQuizSummary.class);
                    toSummary.setFlags(Intent.FLAG_ACTIVITY_FORWARD_RESULT);
                    toSummary.putExtra("AnxietyScore", anxiety);
                    toSummary.putExtra("MotivationScore", motivation);
                    toSummary.putExtra("EmotionalStabilityScore", emotionalStability);
                    //toSummary.putExtras(myLocalIntent);
                    startActivity(toSummary);
                    finish();
                    //startActivityForResult(toSummary, 101);
                }
            }
        });

        answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (answer4.getText() == mThreePointAnswer){
                    if (r<=2){
                        anxiety = anxiety + 3;
                    }else if (r<=5){
                        motivation = motivation + 3;
                    }else{
                        emotionalStability = emotionalStability + 3;
                    }
                }else if(answer4.getText() == mTwoPointAnswer){
                    if (r<=2){
                        anxiety = anxiety + 2;
                    }else if(r<=5){
                        motivation = motivation + 2;
                    }else{
                        emotionalStability = emotionalStability + 2;
                    }
                }else if(answer4.getText() == mOnePointAnswer){
                    if (r<=2){
                        anxiety = anxiety + 1;
                    }else if(r<=5){
                        motivation = motivation + 1;
                    }else{
                        emotionalStability = emotionalStability + 1;
                    }
                }else{
                    if (r<=2){
                        anxiety = anxiety + 0;
                    }else if(r<=5){
                        motivation = motivation + 0;
                    }else{
                        emotionalStability = emotionalStability + 0;
                    }
                }
                if (r < mQuestionsLength-1){
                    r++;
                    updateQuestion(r);
                }else{
                    Intent toSummary = new Intent(getApplicationContext(), PsychologyQuizSummary.class);
                    toSummary.setFlags(Intent.FLAG_ACTIVITY_FORWARD_RESULT);
                    toSummary.putExtra("AnxietyScore", anxiety);
                    toSummary.putExtra("MotivationScore", motivation);
                    toSummary.putExtra("EmotionalStabilityScore", emotionalStability);
                    //toSummary.putExtras(myLocalIntent);
                    startActivity(toSummary);
                    finish();
                    //startActivityForResult(toSummary, 101);
                }
            }
        });
    }

    private void updateQuestion(int num){
        question.setText(mQuestions.getQuestion(num));
        answer1.setText(mQuestions.getChoice1(num));
        answer2.setText(mQuestions.getChoice2(num));
        answer3.setText(mQuestions.getChoice3(num));
        answer4.setText(mQuestions.getChoice4(num));

        mZeroPointAnswer = mQuestions.getZeroPointAnswer(num);
        mOnePointAnswer = mQuestions.getOnePointAnswer(num);
        mTwoPointAnswer = mQuestions.getTwoPointAnswer(num);
        mThreePointAnswer = mQuestions.getThreePointAnswer(num);

    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data){
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if ((requestCode == 101 ) && (resultCode == Activity.RESULT_OK)){
//            if (resultCode == RESULT_OK){
//
//                Bundle bundle = data.getExtras();
//                MentalRecord mentalRecord = null;
//
//                try{
//                    mentalRecord = (MentalRecord) bundle.getSerializable("mentalRecord");
//                } catch (Exception e){
//                    e.printStackTrace();
//                }
//
//                if (mentalRecord != null){
//                    Intent intent = new Intent();
//                    intent.setFlags(Intent.FLAG_ACTIVITY_FORWARD_RESULT);
//                    Bundle nextbundle = new Bundle();
//                    bundle.putSerializable("mentalRecord", mentalRecord);
//                    intent.putExtras(nextbundle);
//                    setResult(RESULT_OK, intent);
//                    finish();
//                }
//
//            }
//        }
//    }
}
