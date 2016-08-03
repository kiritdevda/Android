package com.digits.quizapp.quizapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by kiritdevda on 03/08/16.
 */
public class CheatActivity extends AppCompatActivity{

    private Button CheatButton;
    private TextView Answer;
    private TextView Confirmation;
    public static final String KEY_ANSWER="com.digits.quizapp.quizapp.Answer";
    public static final String KEY_CHEAT_DONE = "com.digits.quizapp.quizapp.CheatActvity.Answer_Showm";

    private void respond_back(Boolean Cheat_Done){
        Intent i = new Intent();
        i.putExtra(KEY_CHEAT_DONE,Cheat_Done);
        setResult(RESULT_OK,i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        final String Answer_MainActivity = getIntent().getStringExtra(KEY_ANSWER);
        CheatButton = (Button) findViewById(R.id.answer_button);
        Answer = (TextView) findViewById(R.id.answer);
        Confirmation = (TextView) findViewById(R.id.warning_text);

        CheatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean Cheat_Done = Boolean.TRUE;
                Confirmation.setText("");
                Answer.setTextColor(Color.RED);
                Answer.setText("Answer is : "+Answer_MainActivity);
                respond_back(Cheat_Done);
            }
        });
    }}