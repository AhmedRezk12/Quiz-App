package com.example.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class QuestionCheckboxAnswerView extends AppCompatActivity {

    public ArrayList<Question> questions = new ArrayList<>();
    public TextView QuestionContentView ;
    public CheckBox Answer1;
    public CheckBox Answer2;
    public CheckBox Answer3;
    public CheckBox Answer4;
    public Button SubmitAnswer ;
    public int question_number ;
    public String QuestionContent ;
    public int NumberOfCorrectAnswer ;
    public int NumberOfWrongAnswer ;
    public boolean question_resolved = false ;
    public String StudentName ;
    ArrayList<String> multi_answers_correct = new ArrayList<String>();;
    public int NumberCheckedAnswer = 0 ;
    public int NumberCheckedAnswerCorrect = 0 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_checkbox_answer_view);
        multi_answers_correct.add("x = x +1 ;");
        multi_answers_correct.add("x += 1 ;");
        questions.add(new Question("Chose code that will make increment variable x 1 : (hint you can select more than one answer)","+1 ;","x = x +1 ;" ,"x += 1 ;","None"));
        Bundle extras = getIntent().getExtras();
        StudentName = extras.getString("Student_Name");
        NumberOfCorrectAnswer = Integer.parseInt(extras.getString("Correct_answers"));
        NumberOfWrongAnswer =Integer.parseInt(extras.getString("Wrong_answers"));
        question_number = Integer.parseInt(extras.getString("QuestionNumber"));
        QuestionContentView = findViewById(R.id.question_content_checkbox_view);
        QuestionContent = "Q"+ question_number +"."+ questions.get(0).question_content;
        QuestionContentView.setText(QuestionContent);
        Answer1 = findViewById(R.id.checkboxAnswer1);
        Answer2 = findViewById(R.id.checkboxAnswer2);
        Answer3 = findViewById(R.id.checkboxAnswer3);
        Answer4 = findViewById(R.id.checkboxAnswer4);
        Answer1.setText(questions.get(0).answer1);
        Answer2.setText(questions.get(0).answer2);
        Answer3.setText(questions.get(0).answer3);
        Answer4.setText(questions.get(0).answer4);
        SubmitAnswer = findViewById(R.id.SubmitAnswer);
    }

    public void SubmitAnswer(View view) {
        if (!Answer1.isChecked() && !Answer2.isChecked() && !Answer3.isChecked() && !Answer4.isChecked())
        {
            Toast.makeText(this, "Please select at lest one answer", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Answer1.setEnabled(false);
            Answer2.setEnabled(false);
            Answer3.setEnabled(false);
            Answer4.setEnabled(false);
//            SubmitAnswer.setEnabled(false);
            question_resolved = true ;
            if (Answer1.isChecked()){
                NumberCheckedAnswer += 1 ;
                int select_flag = 0 ;
                for (int i = 0 ; i < multi_answers_correct.size() ; i++){
                    if (Answer1.getText().equals(multi_answers_correct.get(i)))
                    {
                        NumberCheckedAnswerCorrect += 1 ;
                        select_flag = 1 ;
                        Answer1.setBackgroundResource(R.drawable.correct_answer);
                        break;
                    }
                }
                if (select_flag == 0){
                    Answer1.setBackgroundResource(R.drawable.wrong_answer);
                }
            }
             if (Answer2.isChecked()){
                NumberCheckedAnswer += 1 ;
                int select_flag = 0 ;
                for (int i = 0 ; i < multi_answers_correct.size() ; i++){
                    if (Answer2.getText().equals(multi_answers_correct.get(i)))
                    {
                        NumberCheckedAnswerCorrect += 1 ;
                        select_flag = 1 ;
                        Answer2.setBackgroundResource(R.drawable.correct_answer);
                        break;
                    }
                }
                if (select_flag == 0){
                    Answer2.setBackgroundResource(R.drawable.wrong_answer);
                }
            }
            if (Answer3.isChecked()){
                NumberCheckedAnswer += 1 ;
                int select_flag = 0 ;
                for (int i = 0 ; i < multi_answers_correct.size() ; i++){
                    if (Answer3.getText().equals(multi_answers_correct.get(i)))
                    {
                        NumberCheckedAnswerCorrect += 1 ;
                        select_flag = 1 ;
                        Answer3.setBackgroundResource(R.drawable.correct_answer);
                        break;
                    }
                }
                if (select_flag == 0){
                    Answer3.setBackgroundResource(R.drawable.wrong_answer);
                }
            }
             if (Answer4.isChecked()){
                NumberCheckedAnswer += 1 ;
                int select_flag = 0 ;
                for (int i = 0 ; i < multi_answers_correct.size() ; i++){
                    if (Answer4.getText().equals(multi_answers_correct.get(i)))
                    {
                        NumberCheckedAnswerCorrect += 1 ;
                        select_flag = 1 ;
                        Answer4.setBackgroundResource(R.drawable.correct_answer);
                        break;
                    }
                }
                if (select_flag == 0){
                    Answer4.setBackgroundResource(R.drawable.wrong_answer);
                }
            }

            if (NumberCheckedAnswerCorrect == NumberCheckedAnswer && NumberCheckedAnswerCorrect == multi_answers_correct.size())
            {
                Toast.makeText(this, "Correct Answer", Toast.LENGTH_SHORT).show();
                NumberOfCorrectAnswer += 1 ;
            }
            else
            {
                NumberOfWrongAnswer += 1 ;
                if (!Answer1.isChecked()){
                    for (int i = 0 ; i < multi_answers_correct.size() ; i++){
                        if (Answer1.getText().equals(multi_answers_correct.get(i)))
                        {
                            Answer1.setBackgroundResource(R.drawable.correct_answer);
                            break;
                        }
                    }
                }
                if (!Answer2.isChecked()){
                    for (int i = 0 ; i < multi_answers_correct.size() ; i++){
                        if (Answer2.getText().equals(multi_answers_correct.get(i)))
                        {
                            Answer2.setBackgroundResource(R.drawable.correct_answer);
                            break;
                        }
                    }
                }
                if (!Answer3.isChecked()){
                    for (int i = 0 ; i < multi_answers_correct.size() ; i++){
                        if (Answer3.getText().equals(multi_answers_correct.get(i)))
                        {
                            Answer3.setBackgroundResource(R.drawable.correct_answer);
                            break;
                        }
                    }
                }
                if (!Answer4.isChecked()){
                    for (int i = 0 ; i < multi_answers_correct.size() ; i++){
                        if (Answer4.getText().equals(multi_answers_correct.get(i)))
                        {
                            Answer4.setBackgroundResource(R.drawable.correct_answer);
                            break;
                        }
                    }
                }
                Toast.makeText(this, "Wrong Answer\nCorrect Answer is \n" + multi_answers_correct.get(0) + " & " + multi_answers_correct.get(1), Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void NextQuestion(View view) {
        if (question_resolved == false){
            Toast.makeText(this, "Answer This Question First", Toast.LENGTH_SHORT).show();
        }
        else {
            Intent intent = new Intent(QuestionCheckboxAnswerView.this,Score_View.class);
            intent.putExtra("Student_Name",StudentName);
            intent.putExtra("Correct_answers",Integer.toString(NumberOfCorrectAnswer));
            intent.putExtra("Wrong_answers",Integer.toString(NumberOfWrongAnswer));
            startActivity(intent);
        }
    }

    public void ViewGrade(View view) {
        Toast.makeText(this, "Your Score : "+Integer.toString(NumberOfCorrectAnswer) + "\nWrong Answer : " + Integer.toString(NumberOfWrongAnswer), Toast.LENGTH_SHORT).show();
    }
}
