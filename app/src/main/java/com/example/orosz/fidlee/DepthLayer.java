package com.example.orosz.fidlee;

public class DepthLayer {

    private int minDepth;
    private int maxDepth;
    private int[] avalibleItemIds;
    private double[] chances;

    public DepthLayer(int minDepth, int maxDepth, int[] avalibleItemIds, double[] chances){
        this.avalibleItemIds = new int[99];
        this.chances = new double[99];

        this.minDepth = minDepth;
        this.maxDepth = maxDepth;
        this.avalibleItemIds = avalibleItemIds;
        this.chances = chances;
    }

    public void changeDepths(int[] depths){
        this.minDepth = depths[0];
        this.maxDepth = depths[1];
    }

    public boolean isInLayer(float depth){
        if(this.minDepth <= depth && depth <= this.maxDepth){
            return true;
        }
        return false;
    }

    public int[] getAvalibleItemIds(){
        return this.avalibleItemIds;
    }

    public double[] getChances(){
        return this.chances;
    }

    public void changeItemId(int num, int id){
        this.avalibleItemIds[num] = id;
    }

    public void changeItemChance(int num, double chance){
        this.chances[num] = chance;
    }

    public void changeItemAttributes(int num, int id, double chance){
        this.avalibleItemIds[num] = id;
        this.chances[num] = chance;
    }

    public void addDepthLayer(DepthLayer layer){
        int j;
        for(int i = 0; i < layer.avalibleItemIds.length; i++){
            j = 0;
            while(!(layer.avalibleItemIds[i] == this.avalibleItemIds[j]) && j < this.avalibleItemIds.length){
                j++;
            }
            if(j >= this.avalibleItemIds.length){
                this.avalibleItemIds = Item.addToArray(this.avalibleItemIds, layer.avalibleItemIds[i]);
                this.chances = Item.addToArray(this.chances, layer.chances[i]);
            }
            this.chances[j] += layer.chances[i];
        }
    }

    public Item getRandomItem(){
        if(this.avalibleItemIds == null || this.avalibleItemIds.length != this.chances.length){
            return null;
        }

        int[] sequence = new int[this.avalibleItemIds.length];
        for(int i = 0; i < this.avalibleItemIds.length; i++){
            sequence[i] = i;
        }
        sequence = Item.randomizeArray(sequence);

        for(int i = 0; i < this.avalibleItemIds.length; i++){
            if(Item.randomPossibility(this.chances[sequence[i]])){
                if(this.avalibleItemIds[sequence[i]] == 0){
                    return null;
                }
                return Item.getItemById(this.avalibleItemIds[sequence[i]]);
            }
        }
        return null;
    }

}
