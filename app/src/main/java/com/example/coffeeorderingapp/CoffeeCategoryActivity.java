package com.example.coffeeorderingapp;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CoffeeCategoryActivity extends ListActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ListView listCoffee = getListView();
        ArrayAdapter<Coffee> arrayAdapter = new ArrayAdapter<Coffee>(CoffeeCategoryActivity.this,android.R.layout.simple_list_item_1, Coffee.coffees);

        listCoffee.setAdapter(arrayAdapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {

        Intent intent = new Intent(CoffeeCategoryActivity.this, CoffeeActivity.class);
        intent.putExtra("name", Coffee.coffees[position].getName());
        intent.putExtra("desc", Coffee.coffees[position].getDesc());
        intent.putExtra("image", Coffee.coffees[position].getImageId());
        startActivity(intent);
    }
}
