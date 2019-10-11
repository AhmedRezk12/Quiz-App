package com.example.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class QuestionEditTextAnswerView extends AppCompatActivity {

    public ArrayList<Question> questions = new ArrayList<>();
    public TextView QuestionContentView ;
    public EditText Answer ;
    public Button SubmitAnswer ;
    public int question_number ;
    public String QuestionContent ;
    public int NumberOfCorrectAnswer ;
    public int NumberOfWrongAnswer ;
    public boolean question_resolved = false ;
    public String StudentName ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_edit_text_answer_view);
        questions.add(new Question("The programs machine instructions are store in __ memory segment.","Code"));
        Bundle extras = getIntent().getExtras();
        StudentName = extras.getString("Student_Name");
        NumberOfCorrectAnswer = Integer.parseInt(extras.getString("Correct_answers"));
        NumberOfWrongAnswer =Integer.parseInt(extras.getString("Wrong_answers"));
        question_number = Integer.parseInt(extras.getString("QuestionNumber"));
        QuestionContentView = findViewById(R.id.question_content_edit_text_view);
        QuestionContent = "Q"+ question_number +"."+ questions.get(0).question_content;
        QuestionContentView.setText(QuestionContent);
        Answer = findViewById(R.id.ET_Answer);
        SubmitAnswer = findViewById(R.id.ET_SubmitAnswer);
    }

    public void SubmitAnswer(View view) {
        String get_answer = Answer.getText().toString();
        if (get_answer.isEmpty()){
            Toast.makeText(this, "Please Enter Your Answer To Submit Answer", Toast.LENGTH_SHORT).show();
        }
        else {
            question_resolved = true ;
            Answer.setEnabled(false);
            Answer.setFocusable(false);
            SubmitAnswer.setEnabled(false);
            question_number += 1 ;
            if (get_answer.equals(questions.get(0).right_answer)){
                Toast.makeText(this, "Correct Answer", Toast.LENGTH_SHORT).show();
                Answer.setBackgroundResource(R.drawable.correct_answer);
                NumberOfCorrectAnswer += 1 ;
            }
            else {
                Toast.makeText(this, "Wrong Answer\nCorrect Answer is " + questions.get(0).right_answer, Toast.LENGTH_SHORT).show();
                Answer.setBackgroundResource(R.drawable.wrong_answer);
                NumberOfWrongAnswer += 1 ;
            }
        }
    }

    public void NextQuestion(View view) {
        if (question_resolved == false){
            Toast.makeText(this, "Answer This Question First", Toast.LENGTH_SHORT).show();
        }
        else {
            Intent intent = new Intent (QuestionEditTextAnswerView.this,QuestionCheckboxAnswerView.class);
            intent.putExtra("Student_Name",StudentName);
            intent.putExtra("Correct_answers",Integer.toString(NumberOfCorrectAnswer));
            intent.putExtra("Wrong_answers",Integer.toString(NumberOfWrongAnswer));
            intent.putExtra("QuestionNumber",Integer.toString(question_number));
            startActivity(intent);
        }
    }

    public void ViewGrade(View view) {
        Toast.makeText(this, "Your Score : "+Integer.toString(NumberOfCorrectAnswer) + "\nWrong Answer : " + Integer.toString(NumberOfWrongAnswer), Toast.LENGTH_SHORT).show();
    }
}
