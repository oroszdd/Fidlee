package com.example.orosz.fidlee;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.MotionEvent;

public class FishingGraphicScene implements Scene {

    FishingGraphicBackground fishingGraphicBackground;
    FishingGraphicDepthMeter fishingGraphicDepthMeter;
    FishingGraphicHook fishingGraphicHook;
    Rect hookrect;

    FishingGraphicScene(){
        this.fishingGraphicBackground = new FishingGraphicBackground(0);
        this.fishingGraphicDepthMeter = new FishingGraphicDepthMeter(0);
        this.fishingGraphicHook = new FishingGraphicHook();
        this.hookrect = new Rect(Constants.SCREEN_WIDTH/3,Constants.SCREEN_HEIGHT/3,Constants.SCREEN_WIDTH/3*2,Constants.SCREEN_HEIGHT/3*2);
    }

    @Override
    public void motionEventHandler(MotionEvent event) {
        // Add UI elements
    }

    @Override
    public void update() {

        fishingGraphicBackground.update();
        fishingGraphicDepthMeter.update();


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
