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
        Toast.makeText(this, "Your score is " + score + " out of 5!", Toast.LENGTH_LONG).show();
    }

    private int calculateScore() {
        int score = 0;

        // Question 1 inputs; false is correct
        RadioButton trueRadioButton = (RadioButton) findViewById(R.id.true_radio_button);
        RadioButton falseRadioButton = (RadioButton) findViewById(R.id.false_radio_button);

        // Question 2 input; Deutsch is correct
        EditText wordForGermanEditText = (EditText) findViewById(R.id.word_for_german_edit_text);

        // Question 3 input; das and die are correct
        CheckBox dasCheckBox = (CheckBox) findViewById(R.id.das_checkbox);
        CheckBox dieCheckBox = (CheckBox) findViewById(R.id.die_checkbox);
        CheckBox delCheckBox = (CheckBox) findViewById(R.id.del_checkbox);

        // Question 4 input; Frau is correct
        RadioButton pferdRadioButton = (RadioButton) findViewById(R.id.pferd_radio_button);
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
