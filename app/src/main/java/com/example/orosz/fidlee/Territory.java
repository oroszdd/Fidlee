package com.example.orosz.fidlee;

public class Territory {

    private int[][] avalibleItemIds;
    private double[][] chances;
    private int[] depths;

    public Territory (int[][] avalibleItemIds, double[][] chances, int[] depths){

        for(int i = 0; i < avalibleItemIds.length; i++){
            for(int j = 0; j < avalibleItemIds[i].length; j++){
                this.avalibleItemIds[i][j] = avalibleItemIds[i][j];
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
                if(avalibleItemIds[i].length != 0){
                    for(int j = 0; j < avalibleItemIds[i].length; j++){
                        if(Item.randomPossibility(chances[i][j])){
                            return Item.getItemById(avalibleItemIds[i][j]);
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
