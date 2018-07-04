package com.example.orosz.fidlee;

import java.util.Vector;

public class CaughtList {

    private Vector<Item> CaughtItems = new Vector<>();

    //Constructor
    public CaughtList(){

    }

    public Item getFirstItem(){
        if (!CaughtItems.isEmpty()) {
            return CaughtItems.remove(0);
        }
        return null;
    }

    public void addItem(Item item){
        CaughtItems.add(item);
    }

    public boolean isEmpty(){
        return CaughtItems.isEmpty();
    }

    public void addAll(CaughtList caught){
        if(!caught.isEmpty()){
            this.CaughtItems.addAll(caught.CaughtItems);
        }
    }
}
