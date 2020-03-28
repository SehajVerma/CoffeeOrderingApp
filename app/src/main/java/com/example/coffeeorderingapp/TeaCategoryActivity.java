package com.example.coffeeorderingapp;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TeaCategoryActivity  extends ListActivity{
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            ListView listTea = getListView();
            ArrayAdapter<Tea> arrayAdapter = new ArrayAdapter<Tea>(TeaCategoryActivity.this, android.R.layout.simple_list_item_1, Tea.tea);

            listTea.setAdapter(arrayAdapter);
        }

        @Override
        public void onListItemClick(ListView l, View v, int position, long id) {
            Intent intent = new Intent(TeaCategoryActivity.this, TeaActivity.class);
            intent.putExtra("name", Tea.tea[position].getName());
            intent.putExtra("desc", Tea.tea[position].getDesc());
            intent.putExtra("image", Tea.tea[position].getImageId());
            startActivity(intent);
        }
}
