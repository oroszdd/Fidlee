package com.example.orosz.fidlee;

import java.util.Random;

public abstract class Item {

    //To use randomized numbers
    static Random rand = new Random();

    // Constructor
    public Item(){

    }

    // Give back a random item
    public static Item get() {

        return Fish.get();

    }

    // Sell item
    public abstract int sell();

    //Get name
    public abstract String getName();


}
