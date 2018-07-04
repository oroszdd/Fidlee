package com.example.orosz.fidlee;

import java.util.Random;

public class Fish extends Item {

    //To use randomized numbers
    private static Random rand = new Random();

    private int val;
    private static final int valmax = 10;

    private Fishes typ;

    //Constructor
    public Fish(int value,Fishes type){
            val = value;
            typ = type;

    }

    //Returns a random fish (val: 1-valmax, typ: anything in Fishes)
    public static Fish get() {

        return new Fish(rand.nextInt(valmax) + 1, Fishes.values()[rand.nextInt(Fishes.values().length)]);

    }

    @Override
    public int sell() {
        return val;
    }

}
