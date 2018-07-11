package com.example.orosz.fidlee;

import android.graphics.Canvas;
import android.view.MotionEvent;

public class FishingGraphicScene implements Scene {

    FishingGraphicBackground fishingGraphicBackground;
    FishingGraphicDepthMeter fishingGraphicDepthMeter;

    FishingGraphicScene(){
        this.fishingGraphicBackground = new FishingGraphicBackground(0);
        this.fishingGraphicDepthMeter = new FishingGraphicDepthMeter(0);
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

    }

    @Override
    public void terminate() {

    }
}
