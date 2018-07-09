package com.example.orosz.fidlee;

import java.util.Random;

// getFish(user stat) halat ad vissza
// Constructor()
// getType() 10x es váltó random főosztály (bronze, silver, gold, platinum, diamond)
// getRank() 10x es váltó alrag (peasant, knight, baron, viscount, king)
// getValue() főosztály és alrang függő gold coin bronze(1-3) osztályonként x10, rangonként x2


public class Fish extends Item {

    //To use randomized numbers
    private static Random rand = new Random();

    private int value;

    private Fishes type;
    private Ranks rank;

    //Constructor
    public Fish(int value, Fishes type, Ranks rank){
            this.value = value;
            this.type = type;
            this.rank = rank;

    }

    //just for dummy fihes
    public Fish(){
        this.value = 0;
        this.type = Fishes.values()[0];
        this.rank = Ranks.values()[0];
    }

    //Returns a random fish
    public static Fish get() {

        Fishes type = Fishes.values()[0];
        Ranks rank = Ranks.values()[0];

        //gets a possibility array for the type
        int[] typePossibilities = new int[Fishes.values().length];
        typePossibilities[0] = 10000;
        for(int i = 1; i < typePossibilities.length; i++){
            typePossibilities[i] = typePossibilities[i-1] / 10;
        }

        //gets a random number
        int chosenType = Item.randomize(typePossibilities);

        //chooses fish type based off number
        for(int i = 1; i <= Fishes.values().length; i++){
            if(chosenType == i){
                type = Fishes.values()[i-1];
            }
        }

        //gets a possibility array for the rank
        int[] rankPossibilities = new int[Fishes.values().length];
        rankPossibilities[0] = 10000;
        for(int i = 1; i < rankPossibilities.length; i++){
            rankPossibilities[i] = rankPossibilities[i-1] / 10;
        }
        //-||-
        int chosenRank = Item.randomize(rankPossibilities);
        //-||- rank
        for(int i = 1; i <= Ranks.values().length; i++){
            if(chosenRank == i){
                rank = Ranks.values()[i-1];
            }
        }

        //gets the value of the fish
        int value = rand.nextInt(3) + 1; //random base value
        for(int i = 1; i < chosenType; i++){
            value = value*10; //type multiplier
        }
        for(int i = 1; i < chosenRank; i++){
            value = value*2; //rank multiplier
        }

        return new Fish(value, type, rank);

    }

    public String getType(){
        return this.type.name();
    }

    public String getRank(){
        return this.rank.name();
    }

    public int getValue(){
        return this.value;
    }

    public int getTypeId(){
        return this.type.ordinal();
    }

    public int getRankId(){
        return this.rank.ordinal();
    }

    @Override
    public int sell() {
        return value;
    }

    @Override
    public String getName() {
        return this.getType();
    }

}
