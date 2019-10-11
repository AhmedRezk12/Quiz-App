package com.example.quizapp;

import java.util.ArrayList;

public class Question {
    public String question_content ;
    public String answer1;
    public String answer2;
    public String answer3;
    public String answer4;
    public String right_answer;


    public Question(String Q_C , String An1 , String An2 , String An3 , String An4 , String R_An){
        this.question_content = Q_C ;
        this.answer1 = An1 ;
        this.answer2 = An2 ;
        this.answer3 = An3 ;
        this.answer4 = An4 ;
        this.right_answer = R_An ;
    }
    public Question(String Q_C , String An1 , String An2 , String An3 , String An4 ){
        this.question_content = Q_C ;
        this.answer1 = An1 ;
        this.answer2 = An2 ;
        this.answer3 = An3 ;
        this.answer4 = An4 ;
    }
    public Question(String Q_C , String R_An){
        this.question_content = Q_C ;
        this.right_answer = R_An ;
    }
}
