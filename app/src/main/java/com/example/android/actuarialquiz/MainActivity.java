package com.example.android.actuarialquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    public static String USERNAME_KEY = "username";

    private EditText username;
    private View playButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Storing Username stated by the User
        username = findViewById(R.id.username);

        // PLAY Button set to be disabled (we want Username to be given).
        playButton = findViewById(R.id.play);
        playButton.setEnabled(false);

        username.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // Not used
            }

            // Activates PLAY Button while username is not empty. Additionally, in case someone
            // starts to set Username but deletes it in the end, PLAY Button is disabled.

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() > 0) {
                    playButton.setEnabled(true);
                } else {
                    playButton.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // Not used
            }
        });

        // Clicking PLAY Button is triggering the next activity - QuizActivity
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, QuizActivity.class)
                        .putExtra("username", username.getText().toString()));
            }
        });
    }
}
