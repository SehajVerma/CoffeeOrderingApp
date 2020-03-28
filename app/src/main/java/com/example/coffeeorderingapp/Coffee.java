package com.example.coffeeorderingapp;

public class Coffee {
    private  String name;
    private String desc;
    private int imageId;

    public static final Coffee[] coffees= {
            new Coffee("Latte","Description for latte",R.drawable.cappuccino),
            new Coffee("Cappuccino","Description for cappuccino",R.drawable.cappuccino),
            new Coffee("Espresso","Description for Espresso",R.drawable.espresso),
            new Coffee("Flat White","Description for Flat White",R.drawable.espresso),
            new Coffee("Mocha","Description for Mocha",R.drawable.espresso),
            new Coffee("Americano","Description for Americano",R.drawable.espresso),
            new Coffee("Macchiato","Description for Macchiato",R.drawable.espresso)
    };

    //Constructor

    private Coffee(String name, String desc, int imageId)
        {
            this.name=name;
            this.desc=desc;
            this.imageId=imageId;
        }

     public String getName()
     {
         return name;
     }
    public String getDesc()
    {
        return desc;
    }
    public int getImageId()
    {
        return imageId;
    }
    public String toString()
    {
        return this.name;
    }
}
