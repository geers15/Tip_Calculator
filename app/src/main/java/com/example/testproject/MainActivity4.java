package com.example.testproject;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.Locale;

public class MainActivity4 extends AppCompatActivity {
    private EditText editTextNumber;
    private EditText editTextPercentage;
    private TextView resultTextView;
    private TextView totalTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_bill_custom);

        Toolbar toolbar = findViewById(R.id.toolbar8);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("");
        }

        editTextNumber = findViewById(R.id.input_bill_single_custom);
        editTextPercentage = findViewById(R.id.input_tip_single_custom);  // Added EditText for percentage input
        totalTextView = findViewById(R.id.display_total_single_custom);
        resultTextView = findViewById(R.id.display_tip_single_custom);  // Changed the ID based on your layout

        // Add onClickListener for the "Calculate" button (assuming it's named button8)
        Button calculateButton = findViewById(R.id.button8);  // Corrected the ID
        calculateButton.setOnClickListener(view -> calculatePercentage());
    }

    @SuppressLint("SetTextI18n")
    private void calculatePercentage() {
        String inputValue = editTextNumber.getText().toString();
        String inputPercentage = editTextPercentage.getText().toString();

        if (!inputValue.isEmpty() && !inputPercentage.isEmpty()) {
            double inputNumber = Double.parseDouble(inputValue);
            double percentage = Double.parseDouble(inputPercentage) / 100.0;  // Convert percentage to a decimal

            double result = inputNumber * percentage;
            double total = inputNumber + result;

            String formattedResult = String.format(Locale.US, "%.2f", result);
            String formattedResult1 = String.format(Locale.US, "%.2f", total);

            // Display the result in the TextView
            resultTextView.setText("$ " + formattedResult + " Tip");
            totalTextView.setText("$ " + formattedResult1 + " New Total Bill");
        }
    }

}