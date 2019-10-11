package com.example.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ScoreView extends AppCompatActivity {

    public TextView StudentName;
    public TextView No_Correct;
    public TextView No_Wrong;
    public TextView Score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_view);
        StudentName = findViewById(R.id.St_name);
        No_Correct = findViewById(R.id.right_answers);
        No_Wrong = findViewById(R.id.wrong_answers);
        Score = findViewById(R.id.score);
        Bundle extras = getIntent().getExtras();
        StudentName.setText(extras.getString("Student_Name"));
        No_Correct.setText(extras.getString("Correct_answers"));
        No_Wrong.setText(extras.getString("Wrong_answers"));
        Score.setText(extras.getString("Correct_answers") + " / 5");
    }

    public void AppExit(View view) {
        Intent intent = new Intent(ScoreView.this , MainActivity.class);
        startActivity(intent);
    }
}
