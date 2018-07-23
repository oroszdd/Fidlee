package com.example.orosz.fidlee;

import java.util.Random;
import java.util.Vector;

public class Chest extends Item {

    private static Random rand = new Random();

    private int lvl;
    private final int maxlvl = 5;

    //Constructor
    public Chest(int lvl){
        this.lvl = lvl;
    }

    public void incLvl(int num){
        if(lvl <= maxlvl-num){
            lvl = lvl + num;
        }
    }

    public void decLvl(int num){
        if(lvl >= num) {
            lvl = lvl-num;
        }
    }

    public Vector<Item> open(){
        Vector<Item> caught = new Vector<Item>();
        while(this.lvl > 0){
            caught.add(Fish.get());
            this.decLvl(rand.nextInt(maxlvl)+1);
        }
        return caught;
    }

    @Override
    public int sell(){
        Vector<Item> caught = this.open();
        int price = 0;
        while(!caught.isEmpty()){
            price = price + caught.remove(0).sell();
        }
        return price;

    }

    @Override
    public String getName() {
        return "Chest";
    }

    @Override
    public int getId() {
        return 0;
    }

}
