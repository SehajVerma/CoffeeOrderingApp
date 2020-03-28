package com.example.coffeeorderingapp;

public class Tea {
    private  String name;
    private String desc;
    private int imageId;

    public static final Tea[] tea= {
            new Tea("Green Tea","Description for Green Tea",R.drawable.cappuccino),
            new Tea("Black Tea","Description for Black Tea",R.drawable.cappuccino),
            new Tea("Herbal Tea","Description for Herbal Tea ",R.drawable.espresso),
            new Tea("White Tea","Description for White Tea",R.drawable.espresso),
            new Tea("Fermented Tea","Description for Fermented Tea",R.drawable.espresso)

    };

    //Constructor

    private Tea(String name, String desc, int imageId)
    {
        this.name=name;
        this.desc=desc;
        this.imageId=imageId;
    }

    public  String getName()
    {
        return name;
    }
    public  String getDesc()
    {
        return desc;
    }
    public  int getImageId()
    {
        return imageId;
    }
    public String toString()
    {
        return this.name;
    }
}
