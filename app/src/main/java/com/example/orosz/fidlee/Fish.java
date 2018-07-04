package com.example.orosz.fidlee;

public class Fish extends Item {

    private int val;

    private String typ;

    //Constructor
    public Fish(int value,String type){
            val = value;
            typ = type;

    }

    @Override
    public int sell() {
        return val;
    }

}
