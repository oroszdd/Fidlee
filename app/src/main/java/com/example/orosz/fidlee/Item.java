package com.example.orosz.fidlee;

import java.util.Random;

public abstract class Item {

    //To use randomized numbers
    protected static Random rand = new Random();

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

    //Get id
    public abstract int getId();


    // gets a random int from a number of different possibilities
    public static int randomize(int[] possibilities){
        int possibility = 0;
        int chosen = 0;

        for(int i = 0; i < possibilities.length; i++){
            possibility = possibility + possibilities[i];
        }

        chosen = rand.nextInt(possibility);
        possibility = 0;

        for(int i = 0; i < possibilities.length; i++){
            possibility = possibility + possibilities[i];
            if((possibility - possibilities[i]) <= chosen && chosen < possibility){
                return i+1;
            }
        }

        return 0;
    }

    public static boolean randomPossibility(double chance){
        chance = chance*100000;
        int random = rand.nextInt(100001);
        if(random < chance){
            return true;
        }
        return false;
    }

    public static Item getItemById(int id){
        if(0 <= id && id < 500){
            return Fish.getFishById(id);
        }
        return null;
    }

}
