package com.example.orosz.fidlee;

public class Territory {

    private int[][] availableItemIds;
    private double[][] chances;
    private int[] depths;

    public Territory (int[][] availableItemIds, double[][] chances, int[] depths){

        for(int i = 0; i < availableItemIds.length; i++){
            for(int j = 0; j < availableItemIds[i].length; j++){
                this.availableItemIds[i][j] = availableItemIds[i][j];
            }
        }

        for(int i = 0; i < chances.length; i++){
            for(int j = 0; j < chances[i].length; j++){
                this.chances[i][j] = chances[i][j];
            }
        }

        for(int i = 0; i< depths.length; i++){
            this.depths[i] = depths[i];
        }
    }

    public Item getFishFromDepth(int depth){
        int max = 0;
        for(int i = 0; i < depths.length; i++){
            max = max + depths[i];
            if(max >= depth){
                if(availableItemIds[i].length != 0){
                    for(int j = 0; j < availableItemIds[i].length; j++){
                        if(Item.randomPossibility(chances[i][j])){
                            return Item.getItemById(availableItemIds[i][j]);
                        }
                    }
                    return null;
                }
                return null;
            }
        }
        return null;
    }

}
