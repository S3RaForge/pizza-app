package com.example.pizza_app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class FinalActivity extends AppCompatActivity {
    private TextView tvName;
    private TextView tvSize;
    private TextView tvAdditionsList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        tvName = findViewById(R.id.tvName);
        tvSize = findViewById(R.id.tvSize);
        tvAdditionsList = findViewById(R.id.tvAdditionsList);

        Intent intent = getIntent();

        tvName.setText(String.format("%s %s", tvName.getText(), intent.getStringExtra("pizza_name")));

        String size = intent.getStringExtra("pizza_size");
        if (size == null) {
            size = "Normal";
        }
        tvSize.setText(String.format("%s %s", tvSize.getText(), size));

        boolean[] selectedAdditions = intent.getBooleanArrayExtra("pizza_additions");
        String additionsString = "";
        if (selectedAdditions[0]) additionsString += "Cheese ";
        if (selectedAdditions[1]) additionsString += "Mushrooms ";
        if (selectedAdditions[2]) additionsString += "Olives ";
        tvAdditionsList.setText(additionsString);
    }
}
