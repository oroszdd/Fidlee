package com.example.orosz.fidlee;

import java.util.Random;

// getFish(user stat) halat ad vissza
// Constructor()
// getType() 10x es váltó random főosztály (bronze, silver, gold, platinum, diamond)
// getRank() 10x es váltó alrag (peasant, knight, baron, viscount, king)
// getValue() főosztály és alrang függő gold coin bronze(1-3) osztályonként x10, rangonként x2

/*
public class Fish extends Item {

    //To use randomized numbers
    private static Random rand = new Random();

    private int value;
    //private static final int valmax = 10;

    //private Fishes typ;

    //Constructor
    public Fish(int value){
            this.value = value;
            //this.type = type;

    }

    //Returns a random fish (val: 1-valmax, typ: anything in Fishes)
    public static Fish get() {

        return new Fish(rand.nextInt(valmax) + 1, Fishes.values()[rand.nextInt(Fishes.values().length)]);

    }

    @Override
    public int sell() {
        return val;
    }

    @Override
    public String getName() {
        return String.valueOf(typ);
    }

}
*/