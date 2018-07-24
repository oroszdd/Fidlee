package com.example.orosz.fidlee;

public class Territory {

    private DepthLayer[] layers;

    public Territory (DepthLayer[] layers){
        this.layers = layers;
    }

    public Item getItemFromDepth(float depth){
        int i = 0;
        while(!(this.layers[i].isInLayer(depth)) && i < this.layers.length){
            i++;
        }
        if(i >= this.layers.length){
            return null;
        }

        DepthLayer layer = this.layers[i];
        for(;i < this.layers.length; i++){
            if(this.layers[i].isInLayer(depth)){
                layer.addDepthLayer(this.layers[i]);
            }
        }

        return layer.getRandomItem();
    }


}
