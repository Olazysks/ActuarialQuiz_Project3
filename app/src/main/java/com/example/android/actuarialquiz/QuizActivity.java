package com.example.android.actuarialquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    public static String SCORE = "score";

    private String username;

    private RadioButton question1ans1;
    private CheckBox question2ans1;
    private CheckBox question2ans2;
    private CheckBox question2ans3;
    private CheckBox question2ans4;
    private RadioButton question3ans3;
    private EditText question4ans;
    private CheckBox question5ans1;
    private CheckBox question5ans2;
    private CheckBox question5ans3;
    private CheckBox question5ans4;
    private CheckBox question5ans5;
    private CheckBox question5ans6;
    private CheckBox question5ans7;
    private RadioButton question6ans4;
    private RadioButton question7ans3;
    private View submitButton;

    /**
     * This method was updated to check correctness of answers to all quiz question.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        // Taking username from previous activity - MainActivity
        username = getIntent().getStringExtra(MainActivity.USERNAME_KEY);

        // Finding appropriate answers to check their correctness
        question1ans1 = findViewById(R.id.question1_ans1);
        question2ans1 = findViewById(R.id.question2_ans1);
        question2ans2 = findViewById(R.id.question2_ans2);
        question2ans2.setText(Html.fromHtml(getString(R.string.question2_ans2)));
        question2ans3 = findViewById(R.id.question2_ans3);
        question2ans3.setText(Html.fromHtml(getString(R.string.question2_ans3)));
        question2ans4 = findViewById(R.id.question2_ans4);
        question2ans4.setText(Html.fromHtml(getString(R.string.question2_ans4)));
        question3ans3 = findViewById(R.id.question3_ans3);
        question4ans = findViewById(R.id.question4_ans);
        question5ans1 = findViewById(R.id.question5_ans1);
        question5ans2 = findViewById(R.id.question5_ans2);
        question5ans3 = findViewById(R.id.question5_ans3);
        question5ans4 = findViewById(R.id.question5_ans4);
        question5ans5 = findViewById(R.id.question5_ans5);
        question5ans6 = findViewById(R.id.question5_ans6);
        question5ans7 = findViewById(R.id.question5_ans7);
        question6ans4 = findViewById(R.id.question6_ans4);
        question7ans3 = findViewById(R.id.question7_ans3);

        // Action assignment to submitButton - current score is stored in int score variable
        submitButton = findViewById(R.id.submit);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int score = 0;
                if (question1ans1.isChecked()) {
                    score += 1;
                }
                if (question2ans1.isChecked() && question2ans2.isChecked() &&
                        question2ans3.isChecked() && question2ans4.isChecked()) {
                    score += 1;
                }
                if (question3ans3.isChecked()) {
                    score += 1;
                }
                if (question4ans.getText().toString().equalsIgnoreCase(getString(R.string.question4_correct_ans))) {
                    score += 1;
                }
                if (question5ans1.isChecked() && question5ans2.isChecked() &&
                        !question5ans3.isChecked() && question5ans4.isChecked() &&
                        question5ans5.isChecked() && question5ans6.isChecked() &&
                        question5ans7.isChecked()) {
                    score += 1;
                }
                if (question6ans4.isChecked()) {
                    score += 1;
                }
                if (question7ans3.isChecked()) {
                    score += 1;
                }

                //Displays toast message with score.
                Toast.makeText(QuizActivity.this, quizSummary(score), Toast.LENGTH_LONG).show();
            }
        });
    }

    /**
     * Creates summary of the quiz.
     */
    private String quizSummary(int score) {
        String message = username + ",";
        message += "\n" + getString(R.string.congrats);
        message += "\n" + getString(R.string.score_message) + " " + score;
        message += "\n" + "\n" + getString(R.string.thx) + "  " + "😀";
        return message;
    }
}
