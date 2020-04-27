package com.example.bmicalculator;

import android.graphics.drawable.Drawable;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class AdviceActivity extends AppCompatActivity {

    // list out and initialize all the constants and strings
    int bmi;

    // list out all components such as buttons and text inputs in the AdviceActivity
    TextView adviceText;
    ImageView adviceImage;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advice);
        adviceText = findViewById(R.id.adviceText);
        adviceImage = findViewById(R.id.adviceImage);
        back = findViewById(R.id.back);
    }

    /**
     * Changes the displayed picture and BMI classification based on the given BMI.
     */
    public void displayAdvice(){
        if(bmi < 18.5){
            adviceText.setText("Underweight");
            adviceImage.setImageDrawable(getApplicationContext().getDrawable(R.drawable.Underweight));
        }
        else if(bmi < 25){
            adviceText.setText("Normal");
            adviceImage.setImageDrawable(getApplicationContext().getDrawable(R.drawable.Normal));
        }
        else if(bmi < 30){
            adviceText.setText("Overweight");
            adviceImage.setImageDrawable(getApplicationContext().getDrawable(R.drawable.Overweight));
        }
        else{
            adviceText.setText("Obese");
            adviceImage.setImageDrawable(getApplicationContext().getDrawable(R.drawable.Obese));
        }
    }

}
