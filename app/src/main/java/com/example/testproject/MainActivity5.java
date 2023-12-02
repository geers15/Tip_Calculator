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

public class MainActivity5 extends AppCompatActivity {

    private EditText editBill;
    private EditText editPeople;
    private EditText editTextPercentage;
    private TextView resultTextView;
    private TextView totalTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.split_bill_custom);
        Toolbar toolbar = findViewById(R.id.toolbar10);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("");
        }

        editBill = findViewById(R.id.input_bill_split_custom);
        editPeople = findViewById(R.id.input_numOfPeople_split_custom);
        editTextPercentage = findViewById(R.id.input_tip_split_custom);
        totalTextView = findViewById(R.id.display_bill_split_custom);
        resultTextView = findViewById(R.id.display_tipPerPerson_split_custom);

        Button calculateButton = findViewById(R.id.button12);
        calculateButton.setOnClickListener(view -> calculatePercentage());
    }

    @SuppressLint("SetTextI18n")
    private void calculatePercentage() {
        String inputValue = editBill.getText().toString();
        String inputPercentage = editTextPercentage.getText().toString();
        String inputPerson = editPeople.getText().toString();

        if (!inputValue.isEmpty() && !inputPercentage.isEmpty() && !inputPerson.isEmpty()) {
            double inputNumber = Double.parseDouble(inputValue);
            double percentage = Double.parseDouble(inputPercentage) / 100.0;
            int person = Integer.parseInt(inputPerson);

            double result = inputNumber * percentage;
            double resultPerPerson = result / person;
            double totalPerPerson = (inputNumber + result) / person;

            String formattedResult = String.format(Locale.US, "%.2f", resultPerPerson);
            String formattedResult1 = String.format(Locale.US, "%.2f", totalPerPerson);

            // Display the result in the TextView
            resultTextView.setText("$ " + formattedResult + " Tip per person");
            totalTextView.setText("$ " + formattedResult1 + " per person");
        }
    }
}