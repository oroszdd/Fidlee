package com.example.orosz.fidlee;

public class Fish_Bronze extends Fish {

    private static int valMax = 5;
    private static int valMin = 1;

    public Fish_Bronze(){
        this.value = rand.nextInt(valMax - valMin + 1) + valMin;
    }

    public static Fish_Bronze get(){
        return new Fish_Bronze();
    }

    public String getName(){
        return "Bronze";
    }

    public int sell(){
        return this.value;
    }

    public int getId(){
        return 0;
    }

}
