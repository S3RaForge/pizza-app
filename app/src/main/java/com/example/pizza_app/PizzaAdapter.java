package com.example.pizza_app;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class PizzaAdapter extends ArrayAdapter<Pizza> {
    private Context context;
    private Pizza[] pizzas;
    public PizzaAdapter (Context context, Pizza[] pizzas) {
        super(context, R.layout.pizza_item, pizzas);
        this.context = context;
        this.pizzas = pizzas;
        Log.d("XXX", this.pizzas.toString());
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.pizza_item, parent, false);

        TextView tvName = view.findViewById(R.id.tvName);
        ImageView ivPizza = view.findViewById(R.id.ivPizza);
        Button btnPrice = view.findViewById(R.id.btnPrice);


        tvName.setText(pizzas[position].getName());
        ivPizza.setImageResource(pizzas[position].getImage());
        btnPrice.setText(String.valueOf(pizzas[position].getPrice())+"0$");

        btnPrice.setOnClickListener(v -> {
            Intent intent = new Intent(context, AdditionsActivity.class);

            intent.putExtra("pizza_name", pizzas[position].getName());

            context.startActivity(intent);
        });
        return view;
    }
}
