package com.example.orosz.fidlee;

public class Fish_Gold extends Fish {

    private static int valMax = 100;
    private static int valMin = 50;

    public Fish_Gold(){
        this.value = rand.nextInt(valMax - valMin + 1) + valMin;
    }

    public String getName(){
        return "Gold";
    }

    public int sell(){
        return this.value;
    }

    public int getId(){
        return 3;
    }

}
