package com.example.orosz.fidlee;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class FishingGraphicDepthMeter {

    private float depth;

    //test integer
    private int integer = 0;

    public FishingGraphicDepthMeter(float depth){

        this.depth = depth;

    }


    public void update() {
        integer++;
        if(integer == 1){
            depth = depth + 0.1f;
            if(depth > 125){
                depth = 0;
            }
            integer = 0;
        }
    }


    public void draw(Canvas canvas) {

        //= Depth value
        Paint paint = new Paint();
        paint.setColor(Color.argb(255,255,0,0));
        paint.setTextSize(25);

        for(int i = 0; i <= depth + 10; i = i + 5){
            if(i > depth - 10)
            canvas.drawText(i+"m",Constants.SCREEN_WIDTH/5*4,Constants.SCREEN_HEIGHT/2 + Constants.SCREEN_HEIGHT*(i-depth)/10,paint);
        }

    }
}
