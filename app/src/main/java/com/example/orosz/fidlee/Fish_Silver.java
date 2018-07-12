package com.example.orosz.fidlee;

public class Fish_Silver extends Fish {

    private static int valMax = 20;
    private static int valMin = 10;

    public Fish_Silver(){
        this.value = rand.nextInt(valMax - valMin + 1) + valMin;
    }

    public static Fish_Silver get(){
        return new Fish_Silver();
    }

    public String getName(){
        return "Silver";
    }

    public int sell(){
        return this.value;
    }

    public int getId(){
        return 1;
    }

}
