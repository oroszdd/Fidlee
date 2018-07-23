package com.example.orosz.fidlee;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.media.Image;


public class FishingGraphicBackground {

    private float depth;

    private Bitmap background;
    private Image backg;

    //test integer
    private int integer = 0;

    public FishingGraphicBackground(float depth){

        this.depth = depth;

        this.background = BitmapFactory.decodeResource(Constants.CURRENT_CONTEXT.getResources(),R.drawable.background2);

    }

    public void update(float depth) {

        this.depth = depth;

    }

    public void draw(Canvas canvas) {

        //! Blue from vivid to dark based on depth

        canvas.drawColor(Color.rgb(100,184,255));
        canvas.drawColor(Color.argb((int)depth*2,0,0,0));



        //= 10 different sized fishes based on common fishes in this depth

    }

}
