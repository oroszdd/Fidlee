package com.example.orosz.fidlee;

import android.graphics.Color;

public enum Ranks {
    Peasant, Knight, Baron, Viscount, King;

    public int getColor(){
        int[] colors = new int[Ranks.values().length];

        colors[Ranks.Peasant.ordinal()] = Color.argb(255, 0,0,0);
        colors[Ranks.Knight.ordinal()] = Color.argb(255, 50,0,0);
        colors[Ranks.Baron.ordinal()] = Color.argb(255, 100,0,0);
        colors[Ranks.Viscount.ordinal()] = Color.argb(255,175,0,0);
        colors[Ranks.King.ordinal()] = Color.argb(255,255,0,0);

        return colors[this.ordinal()];
    }
}
