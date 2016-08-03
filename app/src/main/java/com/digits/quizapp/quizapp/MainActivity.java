package com.digits.quizapp.quizapp;

import android.content.Intent;
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
    private Button CheatButton;
    //private static final String KEY_INDEX="index";
    //private static final String KEY_ANSWER = "com.digits.quizapp.quizapp.Answer";
    private static final String TAG="QuizApp";

    private int Toast_Message_ID;
    private Boolean Is_Cheater=Boolean.FALSE;
    private String Answer;
    private TrueFalse tf;

    private void CheckAnswer(String Answer){

        if(Is_Cheater){
            Toast_Message_ID=R.string.Cheating_toast;
        }
        else {
            if (this.Answer.equals(Answer)) {
                Qusetion.setTextColor(Color.parseColor("#009900"));
                Toast_Message_ID = R.string.correct_toast;
            } else {
                Qusetion.setTextColor(Color.parseColor("#CC3300"));
                Toast_Message_ID = R.string.incorrect_toast;
            }
        }
        Toast.makeText(MainActivity.this,
                Toast_Message_ID,
                Toast.LENGTH_SHORT).show();

    }
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
        CheatButton = (Button)findViewById(R.id.Cheat);

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
                CheckAnswer("True");
            }
        });//End of TrueButton listener

        FalseButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                CheckAnswer("False");
            }
        }); //End of FalseButton Listener

        NextButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                tf.NextQuestion();
                Qusetion.setText(tf.getQuestion());
                Qusetion.setTextColor(Color.BLACK);
                Answer = tf.getAnswer();
                Is_Cheater = Boolean.FALSE;
            }
        }); // End of NextButton Listener

        CheatButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                /*
                An intent is an object that a component can use to communicate with the OS.
                The only components you have seen so far are activities, but there are also services, broadcast receivers,
                and content providers.
                Intents are multi-purpose communication tools, and the Intent class provides different constructors depending
                on what you are using the intent to do.
                In this case, you are using an intent to tell the ActivityManager which activity to start,
                so you will use this constructor:

                    public Intent(Context packageContext, Class<?> cls)

                The Class object specifies the activity that the ActivityManager should start.
                The Context object tells the ActivityManager which package the Class object can be found in.*/

                Intent intent = new Intent(MainActivity.this,CheatActivity.class);
                intent.putExtra(CheatActivity.KEY_ANSWER,Answer);

             /*  We could have used startActivity(Intent intent) method however it would have created the new
                 new Activity , but when the Child Activity closes off the onActivityResult(int reuestCode, int ResultCode,
                 Intent intent) is not called so we have called using following function

                //startActivity(Intent)*/

                startActivityForResult(intent,0);
            }
        }
        );
    }

        /*onActivityResult() is been called when the child Activity is called using startActivityForResult(Intent intent,int requestCode)
        The Child Activity can pass on key-value pair in Intent to parent Activity
        We can use this method to set the variables when child returns some data or make some decision's based on returned data
        The entire Parent Activity when returned is not created from scratch it uses savedBundleState to restore things(Might Be)
        The ResquestCode can be used when Parent Activity calls multiple Child Activity, Hence Parent Activity can distinguish
        between Child Activities by using this request code
        */

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d(TAG, "OnActivityResult() method has been called");
        Log.d(TAG,"Value for requestCode is :"+requestCode);
        Log.d(TAG, "Value for resultCode is : " + resultCode);

        if(data == null){
            return;
        }
        Is_Cheater = data.getBooleanExtra(CheatActivity.KEY_CHEAT_DONE, Boolean.FALSE);
    }

        /*The Method below is used to save variable when the actvity is been destroyed and onCreate intializes new
        Activity .This method is normally called by the system before  onPause(), onStop(), and onDestroy().
        When you override onCreate(...), you call onCreate(...) on the activity’s superclass and pass
        in the bundle you just received. In the superclass implementation, the saved state of the views is
        retrieved and used to recreate the activity’s view hierarchy.

        Note that your activity can pass into the stashed state without onDestroy() being called.
        However, you can always rely on onPause() and onSaveInstanceState(...) to be called.
        Typically, you override onSaveInstanceState(...) to stash data in your Bundle

          @Override
          public void onSaveInstanceState(Bundle savedInstanceState) {
            super.onSaveInstanceState(savedInstanceState);
            Log.i(TAG, "onSaveInstanceState");
            savedInstanceState.putInt(KEY_INDEX, mCurrentIndex);

        }

    //Please add follwoing in oncreate to use the above Bundle savedInstanceState
        if (savedInstanceState != null) {
                mCurrentIndex = savedInstanceState.getInt(KEY_INDEX, 0)
        }
    */

    //Below are Lifecycle Method to learn the flow in android app

    //Called When actvity in background but visible
    @Override
    public void onPause(){
        super.onPause();
        /*
        The log class has four method for logging log.d(), log.e(), log.i(),log.w(),log.v()
        This four method represent different level of logging like
          */
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


    /*Actvity is destroyed when Android kills it when it require memory for  other process
    Android never kills a running actvity or activity that is in foreground
    there is a option in Developer Oprions called "Don't Keep Activities"
    this option enables android to destroy the activity as soon as the user presses home button
    or in other words activity goes in background
    When user presess back button the activity is killed if user is in Launcher Activity
    */
    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d(TAG,"Called onDestroy()");
    }
}
