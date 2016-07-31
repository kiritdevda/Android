package com.digits.quizapp.quizapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kiritdevda on 31/07/16.
 */
public class TrueFalse {
    private  List<String> Question;
    private  List<String> Answer;
    private  static int counter=0;

    public TrueFalse(){
        Question =new ArrayList<String>();
        Question.add("Asia is largest Contient");
        Question.add("Ostrich is fatest bird");
        Question.add("China has Democracy");
        Question.add("Tower of Pisa is a seven wonder of world");

        Answer =new ArrayList<String>();
        Answer.add("True");
        Answer.add("True");
        Answer.add("False");
        Answer.add("False");
    }

    public void NextQuestion(){
        counter = (counter +1)%4 ;
    }
    public String getQuestion(){
        return Question.get(counter);
    }
    public String getAnswer(){
        return Answer.get(counter);
    }

}
