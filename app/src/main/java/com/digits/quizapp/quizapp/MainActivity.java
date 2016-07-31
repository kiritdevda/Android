package com.digits.quizapp.quizapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private TextView Qusetion;
    private Button TrueButton;
    private Button FalseButton;
    private Button NextButton;

    private String Answer;
    private TrueFalse tf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

}
