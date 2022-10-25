package com.example.apiapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity
{

    Button JokeButton;

    BUILDER  builder;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        JokeButton = findViewById(R.id.button);

        JokeButton.setOnClickListener(view -> {

            builder = new BUILDER();

            builder.testAllThatJazz(this);



        });

    }
}