package com.example.coffeeorderingapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class CoffeeActivity extends AppCompatActivity {

    int quantity = 1;
    int price = 0;
    ImageView iv;
    TextView tv1;
    //TextView tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee);

        iv = findViewById(R.id.latte_pic);
        tv1 = findViewById(R.id.dt_latte);
        //tv2 = findViewById(R.id.dd_latte);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        //String desc = intent.getStringExtra("desc");
        Integer image = intent.getIntExtra("image", 0);

        iv.setImageResource(image);
        tv1.setText(name);
       // tv2.setText(desc);

    }
    public void increment(View view) {
        if (quantity == 100) {
            Toast.makeText(this, "You can't have more than 100 coffee", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity + 1;
        DisplayOrder();
    }

    public void decrement(View view) {
        if (quantity == 1) {
            Toast.makeText(this, "You can't have less than 1 coffee", Toast.LENGTH_LONG).show();
            return;

        }
        quantity = quantity - 1;
        DisplayOrder();
    }
    private void DisplayOrder()
    {
        displayQuantity(quantity);
        price = calculatePrice();
        String pricemessage = createOrderSummary(price);
        displayMessage(pricemessage);
    }
    private void displayQuantity(int numberOfCoffees) {
        TextView quantityTextView = (TextView) findViewById(R.id.tV_quantity);
        quantityTextView.setText(" " + numberOfCoffees);
    }

    public void call(View view) {
        //progress;
    }

    public void submitOrder(View view) {
        /*Find the users name.*/
        EditText nameField =  findViewById(R.id.name_field);
        String name = nameField.getText().toString();

        /*Find the user address.*/
        EditText addressField = findViewById(R.id.address_field);
        String address = addressField.getText().toString();

        /*Find the user mobile.*/
        EditText phoneField = findViewById(R.id.phone_field);
        String phone = phoneField.getText().toString();

        String pricemessageE = createOrderSummary2(name, address, phone);
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:vermasehaj84@gmail.com")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Please Deliver the Order At Following Address");
        intent.putExtra(Intent.EXTRA_TEXT, pricemessageE);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    private int calculatePrice() {
        int baseprice = 5;
        return baseprice * quantity;
    }

    private String createOrderSummary(int price) {
         String pricemessage = "";

        pricemessage += "\nQuantity:" + quantity;
        pricemessage += "\nTotal Price:₹" + price;
        return pricemessage;
    }
    private String createOrderSummary2(String name, String address, String  phone) {
        String pricemessageE = "";

        pricemessageE += "\nYour Name:" +name;
        pricemessageE += "\nMobile No:" +phone;
        pricemessageE += "\nAddress:" +address;
        pricemessageE += "\nQuantity:" + quantity;
        pricemessageE += "\nTotal Price:₹" + price;
        pricemessageE += "\n" + getString(R.string.Thank_You);
        return pricemessageE;
    }
    private void displayMessage(String message) {
        TextView priceTextView = findViewById(R.id.tV_price);
        priceTextView.setText(message);

    }
}
