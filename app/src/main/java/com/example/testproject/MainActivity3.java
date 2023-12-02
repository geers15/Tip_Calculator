package com.example.testproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.Locale;

public class MainActivity3 extends AppCompatActivity {

    private EditText editTextNumber;
    private TextView resultTextView;
    private TextView totalTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_bill_default);

        Toolbar toolbar = findViewById(R.id.toolbar5);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("");
        }

        // Initialize EditText and TextView with your specific IDs
        editTextNumber = findViewById(R.id.input_bill_single_default);
        resultTextView = findViewById(R.id.display_tip_single_default);
        totalTextView = findViewById(R.id.display_total_single_default);

        Button button=findViewById(R.id.button7);
        button.setOnClickListener(view -> {
            Intent intent=new Intent(MainActivity3.this,MainActivity4.class);
            startActivity(intent);
        });

        // Add onClickListener for the "Calculate" button (assuming it's named button6)
        Button calculateButton = findViewById(R.id.button6);
        calculateButton.setOnClickListener(view -> calculatePercentage());
    }

    @SuppressLint("SetTextI18n")
    private void calculatePercentage() {
        String inputValue = editTextNumber.getText().toString();

        if (!inputValue.isEmpty()) {
            double inputNumber = Double.parseDouble(inputValue);
            double percentage = 0.20; // 20%

            double result = inputNumber * percentage;
            double total = inputNumber + result;


            String formattedResult = String.format(Locale.US,"%.2f", result);
            String formattedResult1 = String.format(Locale.US,"%.2f", total);

            // Display the result in the TextView
            resultTextView.setText ("$ " + formattedResult + " " +  " Tip");
            totalTextView.setText("$ " + formattedResult1 + "  " + "New Total Bill");
        }
    }
}