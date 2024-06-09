package com.example.pizza_app;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.pizzaList);
        Pizza[] pizzas = {
                new Pizza("Meat pizza", 3.90, R.drawable.pizza_meat),
                new Pizza("Four cheese", 2.40, R.drawable.pizza_cheese),
                new Pizza("Sea pizza", 4.20, R.drawable.pizza)
        };

        PizzaAdapter adapter = new PizzaAdapter(
                this,
                pizzas
        );

        listView.setAdapter(adapter);
    }
}