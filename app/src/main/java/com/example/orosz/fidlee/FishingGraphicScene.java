package com.example.orosz.fidlee;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.MotionEvent;

import static com.example.orosz.fidlee.GamePanel.user;

public class FishingGraphicScene implements Scene {

    private float depth = 0.0f;
    private float sink = 0.1f;

    //Initializing the number of layers and number of avalible items in layers
    DepthLayer[] layers;
    int[] avalibleItemIds;
    double[] chances;


    FishingGraphicBackground fishingGraphicBackground;
    FishingGraphicDepthMeter fishingGraphicDepthMeter;
    FishingGraphicHook fishingGraphicHook;
    Rect hookrect;

    FishingGraphicScene(){
        this.fishingGraphicBackground = new FishingGraphicBackground(0);
        this.fishingGraphicDepthMeter = new FishingGraphicDepthMeter(0);
        this.fishingGraphicHook = new FishingGraphicHook();
        this.hookrect = new Rect(Constants.SCREEN_WIDTH/2-200,0,Constants.SCREEN_WIDTH/2+200,Constants.SCREEN_HEIGHT/3*2);

        //Default Territory
        avalibleItemIds = new int[10];
        chances = new double[10];
        DepthLayer[] layers = new DepthLayer[6];

        //First layer 0 - 40m only bronze fish
        avalibleItemIds[0] = 1;

        chances[0] = 0.1;

        layers[0] = new DepthLayer(0, 40, avalibleItemIds, chances);

        //Second layer 40 - 80m only silver fish
        avalibleItemIds[1] = 2;

        chances[1] = 0.1;

        layers[1] = new DepthLayer(40, 80, avalibleItemIds, chances);

        //Third layer 80 - 120m only gold fish
        avalibleItemIds[2] = 3;

        chances[2] = 0.1;

        layers[2] = new DepthLayer(80, 120, avalibleItemIds, chances);

        //Fourth layer 120 - 160m only platinum fish
        avalibleItemIds[3] = 4;

        chances[3] = 0.1;

        layers[3] = new DepthLayer(120, 160, avalibleItemIds, chances);

        //Fifth layer 160 - 200m only diamond fish
        avalibleItemIds[4] = 5;

        chances[4] = 0.1;

        layers[4] = new DepthLayer(160, 200, avalibleItemIds, chances);

        //Safety layer 200 - 205m 100% bronze fish
        avalibleItemIds[5] = 1;

        chances[5] = 0.1;

        layers[5] = new DepthLayer(200, 205, avalibleItemIds, chances);

        //Creating territory
        GamePanel.user.activeTerritory = new Territory(layers);


    }

    @Override
    public void motionEventHandler(MotionEvent event) {
        // Add UI elements
    }

    @Override
    public void update() {

        // Updates
        depth += sink;

        // Incomplete
        // Can catch a fish?
        if(sink >= 0){

            // Did catch a fish?
            Item item = GamePanel.user.activeTerritory.getItemFromDepth(depth);
            if ( item != null){
                // If did catch, then go up
                sink = - 2*sink;
            }
        }
        // Reaching surface
        if(depth < 0){
            sink = 0.1f;
        }


        // Graphic updates
        fishingGraphicBackground.update(depth);
        fishingGraphicDepthMeter.update(depth);


    }

    @Override
    public void draw(Canvas canvas) {

        //! Draw Background
        fishingGraphicBackground.draw(canvas);
        fishingGraphicDepthMeter.draw(canvas);
        fishingGraphicHook.draw(canvas,hookrect);

    }

    @Override
    public void terminate() {

    }
}
