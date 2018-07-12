package com.example.orosz.fidlee;

public class Fish_Platinum extends Fish {

    private static int valMax = 200;
    private static int valMin = 100;

    public Fish_Platinum(){
        this.value = rand.nextInt(valMax - valMin + 1) + valMin;
    }

    public static Fish_Platinum get(){
        return new Fish_Platinum();
    }

    public String getName(){
        return "Platinum";
    }

    public int sell(){
        return this.value;
    }

    public int getId(){
        return 3;
    }

}
