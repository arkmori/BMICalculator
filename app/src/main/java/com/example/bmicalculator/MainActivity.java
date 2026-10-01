package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast; // Added Toast import
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText heightText = findViewById(R.id.heightInput);
                String heightStr = heightText.getText().toString().trim();

                EditText weightText = findViewById(R.id.weightInput);
                String weightStr = weightText.getText().toString().trim();

                if (heightStr.isEmpty() || weightStr.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter both height and weight", Toast.LENGTH_SHORT).show();
                    return;
                }

                try {
                    double height = Double.parseDouble(heightStr);
                    double weight = Double.parseDouble(weightStr);

                    if (height == 0) {
                        Toast.makeText(MainActivity.this, "Height cannot be zero", Toast.LENGTH_SHORT).show();

                        }
                    if (height >= 1000 || weight >= 1000) {
                        Toast.makeText(MainActivity.this, "Values must be 3 digits or less", Toast.LENGTH_SHORT).show();
                        return;
                        
                    }

                    double BMI = weight / (height * height);

                    DecimalFormat df = new DecimalFormat("#.#");
                    String formattedBmi = df.format(BMI);

                    EditText BMIResult = findViewById(R.id.BMIResult);
                    BMIResult.setText(formattedBmi);

                    String BMI_Cat;

                    if (BMI < 15)
                        BMI_Cat = "Very severely underweight";
                    else if (BMI < 16)
                        BMI_Cat = "Severely underweight";
                    else if (BMI < 18.5)
                        BMI_Cat = "Underweight";
                    else if (BMI < 25)
                        BMI_Cat = "Normal";
                    else if (BMI < 30)
                        BMI_Cat = "Overweight";
                    else if (BMI < 35)
                        BMI_Cat = "Obese Class 1 - Moderately Obese";
                    else if (BMI < 40)
                        BMI_Cat = "Obese Class 2 - Severely Obese";
                    else
                        BMI_Cat = "Obese Class 3 - Very Severely Obese";

                    TextView BMICategory = findViewById(R.id.BMICategory);
                    BMICategory.setText(BMI_Cat);

                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Please enter valid numbers", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}