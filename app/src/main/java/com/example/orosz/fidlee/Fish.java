package com.example.orosz.fidlee;

import java.util.Random;

// getFish(user stat) halat ad vissza
// Constructor()
// getType() 10x es váltó random főosztály (bronze, silver, gold, platinum, diamond)
// getRank() 10x es váltó alrag (peasant, knight, baron, viscount, king)
// getValue() főosztály és alrang függő gold coin bronze(1-3) osztályonként x10, rangonként x2


public abstract class Fish extends Item {

    protected int value;

    //Returns a random fish
    public static Fish get() {

        int[] possibilities = new int[5];
        possibilities[0] = 10000;
        possibilities[1] = 1000;
        possibilities[2] = 100;
        possibilities[3] = 10;
        possibilities[4] = 1;

        return Fish.getFishById(Item.randomize(possibilities));
    }


    public static Fish getFishById(int id){
        switch (id){
            case 1:
                return new Fish_Bronze();

            case 2:
                return new Fish_Silver();

            case 3:
                return new Fish_Gold();

            case 4:
                return new Fish_Platinum();

            case 5:
                return new Fish_Diamond();
        }
        return null;
    }

}
