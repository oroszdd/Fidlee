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

    public static int[] randomizeArray(int[] array){
        int[] readyArray = new int[array.length];
        int[] sequence = new int[array.length];

        for(int j = 0; j < array.length; j++){
            sequence[j] = -1;
        }

        int i = 0;
        int num;
        while(i < array.length){
            num = rand.nextInt(array.length);
            if(sequence[num] == -1){
                sequence[num] = i;
                i++;
            }
        }

        for(int j = 0; j < array.length; j++){
            readyArray[j] = array[sequence[i]];
        }

        return readyArray;
    }

    public static boolean randomPossibility(double chance){
        chance = chance*100000;
        int random = rand.nextInt(100000) + 1;
        return random < chance;
    }

    public static Item getItemById(int id){
        if(0 <= id && id < 500){
            return Fish.getFishById(id);
        }
        return null;
    }

    public static int[] addToArray(int[] array, int object){
        int[] arrayReady = new int[array.length + 1];
        for(int i = 0; i < array.length; i++){
            arrayReady[i] = array[i];
        }
        arrayReady[array.length] = object;
        return arrayReady;
    }

    public static double[] addToArray(double[] array, double object){
        double[] arrayReady = new double[array.length + 1];
        for(int i = 0; i < array.length; i++){
            arrayReady[i] = array[i];
        }
        arrayReady[array.length] = object;
        return arrayReady;
    }

}
