package com.example.coffeeorderingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class TeaActivity extends AppCompatActivity {

    ImageView iv;
    TextView tv1;
    TextView tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tea);

        iv=findViewById(R.id.latte_pic);
        tv1=findViewById(R.id.dt_latte);
        tv2=findViewById(R.id.dd_latte);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String desc  =intent.getStringExtra("desc");
        Integer image = intent.getIntExtra("image",0);

        iv.setImageResource(image);
        tv1.setText(name);
        tv2.setText(desc);

    }
}
