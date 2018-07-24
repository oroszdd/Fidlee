package com.example.orosz.fidlee;

public class Fish_Diamond extends Fish {

    private static int valMax = 1000;
    private static int valMin = 500;

    public Fish_Diamond(){
        this.value = rand.nextInt(valMax - valMin + 1) + valMin;
    }

    public String getName(){
        return "Diamond";
    }

    public int sell(){
        return this.value;
    }

    public int getId(){
        return 5;
    }

}
