package com.example.orosz.fidlee;

import java.util.Vector;

public class User{

    // Item dump
    public Vector<Fish> fishes = new Vector<Fish>(100,100);
    // .add(x) : ads x as the last element
    // .size() : gets current size of the vector
    // .get(index("="0)) : gets the indexed value (first element)
    // .remove(index) : removes the indexed element
    // .indexOf("item") : gives back the index of the element

    public Territory activeTerritory;

    // Constructor
    User(){

    }



}
