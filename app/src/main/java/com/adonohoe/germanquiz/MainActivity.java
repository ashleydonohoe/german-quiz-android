package com.adonohoe.germanquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitQuiz(View view) {
        int score = calculateScore();

        String message = getMessage(score);
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    private String getMessage(int score) {
        // Pass is 3+ questions passed, else the user fails
        if(score >= 3) {
            return "Congrats! You passed with a score of " + score + " out of 5!";
        } else {
            return "Bummer! You failed with a score of " + score + " out of 5!";
        }
    }

    private int calculateScore() {
        int score = 0;

        // Question 1;false is correct
        RadioButton falseRadioButton = (RadioButton) findViewById(R.id.false_radio_button);

        // Question 2 input; Deutsch is correct
        EditText wordForGermanEditText = (EditText) findViewById(R.id.word_for_german_edit_text);

        // Question 3 input; das and die are correct
        CheckBox dasCheckBox = (CheckBox) findViewById(R.id.das_checkbox);
        CheckBox dieCheckBox = (CheckBox) findViewById(R.id.die_checkbox);

        // Question 4 input; Frau is correct
        RadioButton frauRadioButton = (RadioButton) findViewById(R.id.frau_radio_button);

        // Question 5 input; Himmel is correct
        EditText wordForSkyEditText = (EditText) findViewById(R.id.word_for_sky_edit_text);

        if(falseRadioButton.isChecked()) {
            score += 1;
        }

        if(wordForGermanEditText.getText().toString().equals("Deutsch")) {
            score += 1;
        }

        if(dasCheckBox.isChecked() && dieCheckBox.isChecked()) {
            score += 1;
        }

        if(frauRadioButton.isChecked()) {
            score += 1;
        }

        if(wordForSkyEditText.getText().toString().equals("Himmel")) {
            score += 1;
        }

        return score;
    }
}
