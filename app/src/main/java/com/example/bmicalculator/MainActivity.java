package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    String hintWeightMetric = "Enter weight in kilograms";
    String hintHeightMetric = "Enter height in meters";
    String hintWeightEnglish = "Enter weight in pounds";
    String hintHeightEnglish = "enter height in inches";

    EditText weightInput;
    EditText heightInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weightInput = findViewById(R.id.weightInput);
        heightInput = findViewById(R.id.heightInput);

    }

    public void changeHintMetric(View view) {
        weightInput.setHint(hintWeightMetric);
        heightInput.setHint(hintHeightMetric);
    }

    public void changeHintEnglish(View view) {
        weightInput.setHint(hintWeightEnglish);
        heightInput.setHint(hintHeightEnglish);
    }
}
