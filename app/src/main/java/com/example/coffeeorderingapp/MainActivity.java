package com.example.coffeeorderingapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance();
        AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {
                    Intent intent = new Intent(MainActivity.this, CoffeeCategoryActivity.class);
                    startActivity(intent);
                }
                if (position == 1) {
                    Intent intent = new Intent(MainActivity.this, TeaCategoryActivity.class);
                    startActivity(intent);
                }
                /*if (position == 2) {
                    Intent intent = new Intent(MainActivity.this, SnacksCategoryActivity.class);
                    startActivity(intent);
                }
                if (position == 3) {
                    Intent intent = new Intent(MainActivity.this, OthersCategoryActivity.class);
                    startActivity(intent);
                }*/
            }
        };
        ListView lv = findViewById(R.id.ListView);
        lv.setOnItemClickListener(onItemClickListener);
    }
    @Override
    public void onBackPressed()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        builder.setTitle("Logout")
                .setMessage("Confirm Logout ?? ")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        firebaseAuth.signOut();
                        finish();
                        startActivity(new Intent(MainActivity.this, MainLogin.class));
                        //MainActivity.super.onBackPressed();
                    }
                })
                .setNegativeButton("No", null).setCancelable(false);
        AlertDialog alert = builder.create();
        alert.show();
    }
}
