package com.example.testproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity3 extends AppCompatActivity {

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

        Button button=findViewById(R.id.button7);
        button.setOnClickListener(view -> {
            Intent intent=new Intent(MainActivity3.this,MainActivity4.class);
            startActivity(intent);

        });

    }
}