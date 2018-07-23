package com.example.orosz.fidlee;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;


public class FishingGraphicHook{

    private Bitmap hook;

    public FishingGraphicHook(){
        this.hook = BitmapFactory.decodeResource(Constants.CURRENT_CONTEXT.getResources(),R.drawable.hookandlongrope);
    }

    public void update(){

    }

    public void draw(Canvas canvas, Rect destination){
        Paint paint = new Paint();

        canvas.drawBitmap(hook,null,destination,paint);

    }

}
