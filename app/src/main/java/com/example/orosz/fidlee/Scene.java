package com.example.orosz.fidlee;

import android.graphics.Canvas;
import android.view.MotionEvent;

// Interface that all Scenes must implement
public interface Scene {
    public void motionEventHandler(MotionEvent event);
    public void update();
    public  void draw(Canvas canvas);
    public void terminate();
}
