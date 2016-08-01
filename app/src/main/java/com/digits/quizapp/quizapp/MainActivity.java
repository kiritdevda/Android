package com.digits.quizapp.quizapp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView Qusetion;
    private Button TrueButton;
    private Button FalseButton;
    private Button NextButton;

    private static final String TAG="QuizApp";


    private String Answer;
    private TrueFalse tf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG,"OnCreate Bulde called");

        tf = new TrueFalse();

        //Get questions and thier answers
        Qusetion = (TextView)findViewById(R.id.question);
        Qusetion.setText(tf.getQuestion());
        Answer = tf.getAnswer();

        //Intailze all buttons
        TrueButton = (Button) findViewById(R.id.True);
        FalseButton = (Button)findViewById(R.id.False);
        NextButton = (Button)findViewById(R.id.Next);

        Qusetion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tf.NextQuestion();
                Qusetion.setText(tf.getQuestion());
                Qusetion.setTextColor(Color.BLACK);
                Answer = tf.getAnswer();
            }
        });

        TrueButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(Answer.equals("True")){
                Qusetion.setTextColor(Color.parseColor("#009900"));
                Toast.makeText(MainActivity.this,
                        R.string.correct_toast,
                        Toast.LENGTH_SHORT).show();}
                else{
                    Qusetion.setTextColor(Color.parseColor("#CC3300"));
                    Toast.makeText(MainActivity.this,
                            R.string.incorrect_toast,
                            Toast.LENGTH_SHORT).show();
                }

            }
        });//End of TrueButton listener

        FalseButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(Answer.equals("False")){
                    Qusetion.setTextColor(Color.parseColor("#009900"));
                    Toast.makeText(MainActivity.this,
                            R.string.correct_toast,
                            Toast.LENGTH_SHORT).show();}
                else{
                    Qusetion.setTextColor(Color.parseColor("#CC3300"));
                    Toast.makeText(MainActivity.this,
                            R.string.incorrect_toast,
                            Toast.LENGTH_SHORT).show();
                }
            }
        }); //End of FalseButton Listener

        NextButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                tf.NextQuestion();
                Qusetion.setText(tf.getQuestion());
                Qusetion.setTextColor(Color.BLACK);
                Answer = tf.getAnswer();

            }
        }); // End of NextButton Listener
    }

    //Below are Lifecycle Method to learn the flow in android app

    //Called When actvity in background but visible
    @Override
    public void onPause(){
        super.onPause();
        Log.d(TAG,"Called onPause()");
    }

    //Called when activity is in not visible
    @Override
    public void onStop(){
        super.onStop();
        Log.d(TAG,"Called onStop()");
    }

    //Called when Actvivity is in foreground transitioned from paused state
    @Override
    public void onResume(){
        super.onResume();
        Log.d(TAG,"Called onResume()");
    }

    //Called when Actvivity is in foreground transitioned from stop state
    @Override
    public void onStart(){
        super.onStart();
        Log.d(TAG,"Called onStart()");
    }

    //Called whrn actvity is completely removed i.e when orientation changes activity is removed and new actvity is created
    //with desired orientation

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d(TAG,"Called onDestroy()");
    }
}
