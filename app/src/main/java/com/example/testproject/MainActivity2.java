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
public class MainActivity2 extends AppCompatActivity {

    private EditText editBill;
    private EditText editNumber1;
    private TextView resultTextView;
    private TextView totalTextView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.split_bill_default);

        Toolbar toolbar = findViewById(R.id.toolbar3);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("");
        }
        editBill = findViewById(R.id.editTextNumber);
        editNumber1 = findViewById(R.id.editTextNumber2);
        resultTextView = findViewById(R.id.textView4);
        totalTextView = findViewById(R.id.textView5);


        Button button=findViewById(R.id.button5);
        button.setOnClickListener(view -> {
            Intent intent=new Intent(MainActivity2.this, MainActivity5.class);
            startActivity(intent);

        });

        Button calculateButton = findViewById(R.id.button4);
        calculateButton.setOnClickListener(view -> calculatePercentage());
    }

    @SuppressLint("SetTextI18n")
    private void calculatePercentage() {
        String inputValue = editBill.getText().toString();
        String inputPerson = editNumber1.getText().toString();

        if (!inputValue.isEmpty() && !inputPerson.isEmpty()) {
            double inputNumber = Double.parseDouble(inputValue);
            int person = Integer.parseInt(inputPerson);
            double percentage = 0.20;

            double result = inputNumber * percentage;
            double result2 = result / person;

            double total = (inputNumber + result) / person;


            String formattedResult = String.format(Locale.US, "%.2f", result2);
            String formattedResult1 = String.format(Locale.US, "%.2f", total);


            // Display the result in the TextView
            resultTextView.setText("$ " + formattedResult + " Tip Per Person");
            totalTextView.setText("$ " + formattedResult1 + " Total Per Person");

        }
    }

}
