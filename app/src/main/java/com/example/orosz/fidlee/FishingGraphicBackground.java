package com.example.orosz.fidlee;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

public class FishingGraphicBackground {

    private float depth;

    //test integer
    private int integer = 0;

    public FishingGraphicBackground(float depth){

        this.depth = depth;

    }

    public void update() {
        integer++;
        if(integer == 30){
            depth++;
            if(depth > 400){
                depth = 0;
            }
            integer = 0;
        }
    }

    public void draw(Canvas canvas) {

        //! Blue from vivid to dark based on depth
        for( int i = 0; i < 100; i++ ){
            Paint paint = new Paint();
            if(depth <= 100) {
                paint.setColor(Color.argb(255, 200 - ((int)depth + i), 200 - ((int)depth + i), 255));
            }
            else{
                if(depth + i <= 200){
                    paint.setColor(Color.argb(255, 200 - ((int)depth + i), 200 - ((int)depth + i), 255));
                }
                if(depth + i > 200){
                    paint.setColor(Color.argb(255, 0, 0, 255-((int)depth+i-200)));
                }
                if(depth > 355){
                    paint.setColor(Color.argb(255, 0, 0, 0));
                }
            }
            //l,t,r,b
            canvas.drawRect(new RectF(0,Constants.SCREEN_HEIGHT*i/100,Constants.SCREEN_WIDTH,Constants.SCREEN_HEIGHT*(i+1)/100),paint);
        }

        //= 10 different sized fishes based on common fishes in this depth

    }

}
