package com.example.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private EditText Student_Name ;
    private Button Start_Quiz ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Student_Name = findViewById(R.id.student_name);
        Start_Quiz = findViewById(R.id.start_quiz);
        Student_Name.addTextChangedListener(CheckStudentName);

    }

    private TextWatcher CheckStudentName = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String StudentName = Student_Name.getText().toString().trim();
            Start_Quiz.setEnabled(!StudentName.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    public void StartQuiz(View view) {
        Intent intent = new Intent(MainActivity.this,Questions.class);
        intent.putExtra("StudentName",Student_Name.getText().toString());
        startActivity(intent);
    }
}
