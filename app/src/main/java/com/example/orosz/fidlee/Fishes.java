package com.example.orosz.fidlee;


import android.graphics.Color;

public enum Fishes {
    Bronze, Silver, Gold, Platinum, Diamond;

    public int getColor(){
        int[] colors = new int[Fishes.values().length];

        colors[Fishes.Bronze.ordinal()] = Color.argb(255, 205,127,50);
        colors[Fishes.Silver.ordinal()] = Color.argb(255, 192,192,192);
        colors[Fishes.Gold.ordinal()] = Color.argb(255, 212,172,55);
        colors[Fishes.Platinum.ordinal()] = Color.argb(255,229,228,226);
        colors[Fishes.Diamond.ordinal()] = Color.argb(255,185,242,255);

        return colors[this.ordinal()];
    }

}
