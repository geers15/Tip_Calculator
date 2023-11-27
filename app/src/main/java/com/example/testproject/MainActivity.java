package com.example.testproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);

        Button button1=findViewById(R.id.button);
        button1.setOnClickListener(view -> {
            Intent intent=new Intent(MainActivity.this,MainActivity3.class);
                    startActivity(intent);

        });
        Button button=findViewById(R.id.button2);
        button.setOnClickListener(view -> {
            Intent intent=new Intent(MainActivity.this,MainActivity2.class);
            startActivity(intent);

        });
    }
}