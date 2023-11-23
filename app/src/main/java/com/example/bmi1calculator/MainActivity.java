package com.example.bmi1calculator;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editTextHeight;
    private EditText editTextWeight;
    private RadioGroup radioGroupGender;
    private Button buttonCalculate;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextHeight = findViewById(R.id.editTextHeight);
        editTextWeight = findViewById(R.id.editTextWeight);
        radioGroupGender = findViewById(R.id.radioGroupGender); // Reference the RadioGroup
        buttonCalculate = findViewById(R.id.buttonCalculate);
        textViewResult = findViewById(R.id.textViewResult);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    // Get selected gender from RadioButton
                    int selectedGenderId = radioGroupGender.getCheckedRadioButtonId();
                    RadioButton selectedGenderRadioButton = findViewById(selectedGenderId);
                    String gender = selectedGenderRadioButton.getText().toString();



                    double height = Double.parseDouble(editTextHeight.getText().toString());
                    double weight = Double.parseDouble(editTextWeight.getText().toString());

                    // Ensure height is in meters (convert cm to meters)
                   height /= 100.0;

                    double bmi = weight / (height * height);
                    String bmiCategory = "";




                    // Calculate BMI category as before
                    if (bmi < 18.5) {
                        bmiCategory = "Underweight";
                    } else if (bmi >= 18.5 && bmi < 24.9) {
                        bmiCategory = "Normal";
                    } else if (bmi >= 24.9) {
                        bmiCategory = "Overweight";
                    }

                    String resultMessage = "Your BMI is " + bmi + "\nCategory: " + bmiCategory;
                    textViewResult.setText(resultMessage);
                } catch (NumberFormatException e) {
                    // Handle invalid input
                    textViewResult.setText("Invalid input. Please enter valid height and weight.");
                }
            }
        });
    }
}
