package com.example.pizza_app;

import android.net.Uri;

public class Pizza {
    private double price;
    private String name;
    private int image;

    public Pizza(String name, double price, int image) {
         this.name = name;
         this.price = price;
         this.image = image;
    }

    public double getPrice() {
        return price;
    }
    public String getName() {
        return name;
    }
    public int getImage() { return image; }
}
