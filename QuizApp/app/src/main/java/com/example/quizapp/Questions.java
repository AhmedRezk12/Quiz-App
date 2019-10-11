package com.example.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.quizapp.R.drawable.correct_answer;
import static com.example.quizapp.R.drawable.wrong_answer;

public class Questions extends AppCompatActivity {

    public ArrayList<Question> questions = new ArrayList<>();
    public TextView Question_Content ;
    public RadioGroup Answers ;
    public RadioButton Answer1 ;
    public RadioButton Answer2 ;
    public RadioButton Answer3 ;
    public RadioButton Answer4 ;
    public Button Submit_Answer ;
    public int question_number = 0 ;
    public int question_number_view = 1 ;
    public String QuestionContent ;
    public int NumberOfCorrectAnswer = 0;
    public int NumberOfWrongAnswer = 0;
    public boolean question_resolved = false ;
    public String StudentName ;
    public int selectedId ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        questions.add(new Question("int x = 5 ; \nSelect The Right Answer To Print x  : " , "cout<< \"x\" ;","cout<< 5 ;" , "cout<< x ;","None ", "cout<< x ;"));
        questions.add(new Question("What is the output of the following code? \nint x ;\nfor (int i = 1 ; i <= 5 ; i++){\n\t\tx = i ;\n\t}\ncout<< x ;" , "6","5" , "1","Runtime error", "6"));
        questions.add(new Question("What is the output of the following code? \nchar *s = \"C++\";\ncout<<s<<\" \";\ns++;\ncout<<s<<\" \";" , "C++ C++","C++ ++" , "++ ++","Compile error", "C++ ++"));
        questions.add(new Question("Choose the operator which cannot be overloaded." , "/","()" , "::","%", "::"));
        questions.add(new Question(" Special symbol permitted with in the identifier name." , "$","@" , ".","_", "_"));
        Question_Content = findViewById(R.id.question_content);
        Bundle extras = getIntent().getExtras();
        StudentName = extras.getString("StudentName");
        Answers = findViewById(R.id.answers);
        Answer1 = findViewById(R.id.answer1);
        Answer2 = findViewById(R.id.answer2);
        Answer3 = findViewById(R.id.answer3);
        Answer4 = findViewById(R.id.answer4);
        Submit_Answer = findViewById(R.id.SubmitAnswer);
        QuestionContent = "Q"+ question_number_view +"."+ questions.get(question_number).question_content;
        Question_Content.setText(QuestionContent);
        Answer1.setText(questions.get(question_number).answer1);
        Answer2.setText(questions.get(question_number).answer2);
        Answer3.setText(questions.get(question_number).answer3);
        Answer4.setText(questions.get(question_number).answer4);
    }

    public void SubmitAnswer(View view) {


        selectedId = Answers.getCheckedRadioButtonId();
        RadioButton selected = findViewById(selectedId) ;
        if (selectedId == -1)
        {
            Toast.makeText(this, "Please Select  Your Answer", Toast.LENGTH_SHORT).show();
        }
        else {
            question_resolved = true ;
            Submit_Answer.setEnabled(false);
            if (selected.getText().toString() == questions.get(question_number).right_answer){
                selected.setBackgroundResource(correct_answer);
                Toast.makeText(this, "Correct Answer", Toast.LENGTH_SHORT).show();
                NumberOfCorrectAnswer +=  1 ;
                Answer1.setEnabled(false);
                Answer2.setEnabled(false);
                Answer3.setEnabled(false);
                Answer4.setEnabled(false);
                question_number = question_number + 1 ;
                question_number_view = question_number_view + 1 ;
            }
            else {
                selected.setBackgroundResource(wrong_answer);
                NumberOfWrongAnswer = NumberOfWrongAnswer + 1 ;

                Answer1.setEnabled(false);
                Answer2.setEnabled(false);
                Answer3.setEnabled(false);
                Answer4.setEnabled(false);
                if(Answer1.getText().toString() == questions.get(question_number).right_answer){
                    Answer1.setBackgroundResource(correct_answer);
                    Toast.makeText(this, "Wrong Answer\nCorrect Answer is "+Answer1.getText().toString(), Toast.LENGTH_SHORT).show();
                    question_number = question_number + 1 ;
                    question_number_view = question_number_view + 1 ;
                }
                else if (Answer2.getText().toString() == questions.get(question_number).right_answer){
                    Answer2.setBackgroundResource(correct_answer);
                    Toast.makeText(this, "Wrong Answer\nCorrect Answer is "+Answer2.getText().toString(), Toast.LENGTH_SHORT).show();
                    question_number = question_number + 1 ;
                    question_number_view = question_number_view + 1 ;
                }
                else if (Answer3.getText().toString() == questions.get(question_number).right_answer){
                    Answer3.setBackgroundResource(correct_answer);
                    Toast.makeText(this, "Wrong Answer\nCorrect Answer is "+Answer3.getText().toString(), Toast.LENGTH_SHORT).show();
                    question_number = question_number + 1 ;
                    question_number_view = question_number_view + 1 ;
                }

                else if (Answer4.getText().toString() == questions.get(question_number).right_answer){
                    Answer4.setBackgroundResource(correct_answer);
                    Toast.makeText(this, "Wrong Answer\nCorrect Answer is "+Answer4.getText().toString(), Toast.LENGTH_SHORT).show();
                    question_number = question_number + 1 ;
                    question_number_view = question_number_view + 1 ;
                }
                else {
                    Toast.makeText(this, "No Correct Answer", Toast.LENGTH_SHORT).show();
                    question_number = question_number + 1 ;
                    question_number_view = question_number_view + 1 ;
                }


            }
        }

    }

    public void Answer1Selected(View view) {
    }

    public void Answer2Selected(View view) {
    }

    public void Answer3Selected(View view) {
    }

    public void Answer4Selected(View view) {
    }

    public void NextQuestion(View view) {
        if(question_number == questions.size())
        {
            Intent intent = new Intent(Questions.this,QuestionEditTextAnswerView.class);
            intent.putExtra("Student_Name",StudentName);
            intent.putExtra("Correct_answers",Integer.toString(NumberOfCorrectAnswer));
            intent.putExtra("Wrong_answers",Integer.toString(NumberOfWrongAnswer));
            intent.putExtra("QuestionNumber",Integer.toString(question_number_view));
            startActivity(intent);
        }
        else {
            if(question_resolved == true){
                Submit_Answer.setEnabled(true);
                QuestionContent = "Q"+ question_number_view +"."+ questions.get(question_number).question_content;
                Question_Content.setText(QuestionContent);
                Answer1.setText(questions.get(question_number).answer1);
                Answer2.setText(questions.get(question_number).answer2);
                Answer3.setText(questions.get(question_number).answer3);
                Answer4.setText(questions.get(question_number).answer4);
                Answer1.setEnabled(true);
                Answer2.setEnabled(true);
                Answer3.setEnabled(true);
                Answer4.setEnabled(true);
                Answer1.setBackgroundResource(0);
                Answer2.setBackgroundResource(0);
                Answer3.setBackgroundResource(0);
                Answer4.setBackgroundResource(0);
                question_resolved = false;
                Answers.clearCheck();
            }
            else {
                Toast.makeText(this, "Answer This Question Frist", Toast.LENGTH_SHORT).show();
            }
        }



    }

    public void ViewGrade(View view) {
        Toast.makeText(this, "Your Score : "+Integer.toString(NumberOfCorrectAnswer) + "\nWrong Answer : " + Integer.toString(NumberOfWrongAnswer), Toast.LENGTH_SHORT).show();
    }
}
