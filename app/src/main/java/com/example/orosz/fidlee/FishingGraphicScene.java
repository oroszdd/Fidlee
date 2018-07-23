package com.example.orosz.fidlee;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.MotionEvent;

import static com.example.orosz.fidlee.GamePanel.user;

public class FishingGraphicScene implements Scene {

    private float depth = 0.f;
    private float sink = 0.1f;
    private Territory territory;


    FishingGraphicBackground fishingGraphicBackground;
    FishingGraphicDepthMeter fishingGraphicDepthMeter;
    FishingGraphicHook fishingGraphicHook;
    Rect hookrect;

    FishingGraphicScene(){
        this.fishingGraphicBackground = new FishingGraphicBackground(0);
        this.fishingGraphicDepthMeter = new FishingGraphicDepthMeter(0);
        this.fishingGraphicHook = new FishingGraphicHook();
        this.hookrect = new Rect(Constants.SCREEN_WIDTH/2-200,0,Constants.SCREEN_WIDTH/2+200,Constants.SCREEN_HEIGHT/3*2);

        // Tömböket ide h baszódnál meg
        this.territory = new Territory();
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
            //territory.getFishFromDepth(depth);
            // Did catch a fish?
            if (territory.getFishFromDepth(depth) != null){
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
