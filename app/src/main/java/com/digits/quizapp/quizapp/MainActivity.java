package com.digits.quizapp.quizapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button TrueButton;
    private Button FalseButton;
    private TextView Qusetion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Qusetion = (TextView)findViewById(R.id.question);
        Qusetion.setText(R.string.question1);

        TrueButton = (Button) findViewById(R.id.True);
        FalseButton = (Button)findViewById(R.id.False);


        TrueButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Qusetion.setTextColor(Color.parseColor("#009900"));
                Toast.makeText(MainActivity.this,
                        R.string.correct_toast,
                        Toast.LENGTH_SHORT).show();
            }
        });

        FalseButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Qusetion.setTextColor(Color.parseColor("#CC3300"));
                Toast.makeText(MainActivity.this,
                        R.string.incorrect_toast,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

}
