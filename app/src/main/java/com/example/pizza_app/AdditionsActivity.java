package com.example.pizza_app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AdditionsActivity extends AppCompatActivity {
    private RadioGroup radioGroup;
    private Button btnContinue;
    private CheckBox cbCheese;
    private CheckBox cbMushrooms;
    private CheckBox cbOlives;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_additions);

        Intent finalIntent = new Intent(AdditionsActivity.this, FinalActivity.class);
        Intent intent = getIntent();
        finalIntent.putExtras(intent.getExtras());

        radioGroup = findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener((g, id) -> {
            RadioButton radioButton = findViewById(id);
            finalIntent.putExtra("pizza_size", radioButton.getText().toString());
        });

        boolean[] additions = { false, false, false };

        cbCheese = findViewById(R.id.cbCheese);
        cbMushrooms = findViewById(R.id.cbMushrooms);
        cbOlives = findViewById(R.id.cbOlives);
        cbCheese.setOnCheckedChangeListener((v, flag) -> {
            additions[0] = flag;
        });
        cbMushrooms.setOnCheckedChangeListener((v, flag) -> {
            additions[1] = flag;
        });
        cbOlives.setOnCheckedChangeListener((v, flag) -> {
            additions[2] = flag;
        });
        finalIntent.putExtra("pizza_additions", additions);

        btnContinue = findViewById(R.id.btnContinue);
        btnContinue.setOnClickListener(v -> {
            startActivity(finalIntent);
        });
    }
}
