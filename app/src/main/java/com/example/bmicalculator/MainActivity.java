package com.example.bmicalculator;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // list out and initialize all the constants and strings
    String hintWeightMetric = "Enter weight in kilograms";
    String hintHeightMetric = "Enter height in meters";
    String hintWeightEnglish = "Enter weight in pounds";
    String hintHeightEnglish = "Enter height in inches";

    // list out all components such as buttons and text inputs in the MainActivity
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

        // find corresponding variable for each component
        weightInput = findViewById(R.id.weightInput);
        heightInput = findViewById(R.id.heightInput);
        bmiResult = findViewById(R.id.bmiResult);
        metricButton = findViewById(R.id.metricButton);
        englishButton = findViewById(R.id.englishButton);
        calculateButton = findViewById(R.id.calculateButton);
        adviceButton = findViewById(R.id.adviceButton);

        return;

    }

    // change hint of input boxes when chose metric
    public void changeHintMetric(View view) {
        weightInput.setHint(hintWeightMetric);
        heightInput.setHint(hintHeightMetric);
        return;
    }

    // change hint of input boxes when chose english
    public void changeHintEnglish(View view) {
        weightInput.setHint(hintWeightEnglish);
        heightInput.setHint(hintHeightEnglish);
        return;
    }

    // calculate bmi in metric units, returns a double
    public double getBmiMetric(double weight, double height){
        double temp;
        temp = weight/(height*height);
        temp *= 100;
        temp = Math.round(temp);
        double result = temp/100;
        return result;
    }

    // calculate bmi in english units, returns a double
    public double getBmiEnglish(double weight, double height){
        double temp;
        temp = (weight*703)/(height*height);
        temp *= 100;
        temp = Math.round(temp);
        double result = temp/100;
        return result;
    }

    // display BMI value on screen when calculate button is clicked
    public void displayBMI(View view) {

        double weight = Double.parseDouble(weightInput.getText().toString());
        double height = Double.parseDouble(heightInput.getText().toString());

        double bmi;
        if ( metricButton.isChecked() ){
            bmi = getBmiMetric(weight, height);
        } else if ( englishButton.isChecked() ){
            bmi = getBmiEnglish(weight, height);
        } else {
            // *display error message here*
            return;
        }

        String result = String.format("%.2f", bmi);
        bmiResult.setText(result);
        return;
    }

    public void getAdvice(View view){
        Intent adviceIntent = new Intent(this, AdviceActivity.class);
        adviceIntent.putExtra("BMI", bmiResult.getText().toString());
        startActivity(adviceIntent);
    }
}
