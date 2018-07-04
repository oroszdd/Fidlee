package com.example.orosz.fidlee;

public abstract class Item {

    // Constructor
    public Item(){

    }

    // Give back a random item
    public Fish get() {

        return new Fish(3,"Simpleton");

    }

    // Sell item
    public abstract int sell();


}
