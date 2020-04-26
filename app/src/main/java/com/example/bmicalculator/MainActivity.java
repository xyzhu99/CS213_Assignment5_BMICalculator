package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String hintWeightMetric = "Enter weight in kilograms";
    String hintHeightMetric = "Enter height in meters";
    String hintWeightEnglish = "Enter weight in pounds";
    String hintHeightEnglish = "Enter height in inches";

    EditText weightInput;
    EditText heightInput;
    TextView bmiResult;
    RadioButton metricButton;
    RadioButton englishButton;
    Button calculateButton;
    Button adviceButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weightInput = findViewById(R.id.weightInput);
        heightInput = findViewById(R.id.heightInput);
        bmiResult = findViewById(R.id.bmiResult);
        metricButton = findViewById(R.id.metricButton);
        englishButton = findViewById(R.id.englishButton);
        calculateButton = findViewById(R.id.calculateButton);
        adviceButton = findViewById(R.id.adviceButton);

        return;

    }

    public void changeHintMetric(View view) {
        weightInput.setHint(hintWeightMetric);
        heightInput.setHint(hintHeightMetric);
        return;
    }

    public void changeHintEnglish(View view) {
        weightInput.setHint(hintWeightEnglish);
        heightInput.setHint(hintHeightEnglish);
        return;
    }

    public double getBmiMetric(double weight, double height){
        double temp;
        temp = weight/(height*height);
        temp *= 100;
        temp = Math.round(temp);
        double result = temp/100;
        return result;
    }

    public double getBmiEnglish(double weight, double height){
        double temp;
        temp = (weight*703)/(height*height);
        temp *= 100;
        temp = Math.round(temp);
        double result = temp/100;
        return result;
    }

    public void displayBMI(View view) {
        String result = "hey";
        bmiResult.setText(result);
        return;
    }
}
