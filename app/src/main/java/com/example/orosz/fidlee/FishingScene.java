package com.example.orosz.fidlee;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.MotionEvent;

public class FishingScene implements Scene {

    // Constructor
    public FishingScene(){

    }

    // Event handling
    @Override
    public void motionEventHandler(MotionEvent event) {
        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:
                if(event.getX() < Constants.SCREEN_WIDTH/3-5 && event.getY() > Constants.SCREEN_HEIGHT*9/10){
                    GamePanel.sceneManager.ACTIVE_SCENE = 1;
                }
                if(event.getX() < Constants.SCREEN_WIDTH*2/3-5 && event.getX() > Constants.SCREEN_WIDTH/3+5 && event.getY() > Constants.SCREEN_HEIGHT*9/10){
                    GamePanel.sceneManager.ACTIVE_SCENE = 0;
                }
                if(event.getX() > Constants.SCREEN_WIDTH*2/3+5 && event.getY() > Constants.SCREEN_HEIGHT*9/10){
                    GamePanel.sceneManager.ACTIVE_SCENE = 2;
                }
        }
    }

    // Updating the Scene
    @Override
    public void update() {

    }

    // Drawing the Scene
    @Override
    public void draw(Canvas canvas) {
        // Get a paint object
        Paint paint = new Paint();

        // Draw the background
        canvas.drawColor(Color.argb(255,150,200,255));

        // Set the UI
        paint.setColor(Color.argb(80,150,220,0));
        canvas.drawRect(new RectF(0,Constants.SCREEN_HEIGHT*9/10,Constants.SCREEN_WIDTH,Constants.SCREEN_HEIGHT),paint);
        paint.setColor(Color.argb(255,150,220,0));
        canvas.drawRect(new RectF(Constants.SCREEN_WIDTH/3+5,Constants.SCREEN_HEIGHT*9/10,Constants.SCREEN_WIDTH*2/3-5,Constants.SCREEN_HEIGHT),paint);

        paint.setColor(Color.argb(255,0,0,0));
        canvas.drawRect(new RectF(Constants.SCREEN_WIDTH/3-5,Constants.SCREEN_HEIGHT*9/10,Constants.SCREEN_WIDTH/3+5,Constants.SCREEN_HEIGHT),paint);
        canvas.drawRect(new RectF(Constants.SCREEN_WIDTH*2/3-5,Constants.SCREEN_HEIGHT*9/10,Constants.SCREEN_WIDTH*2/3+5,Constants.SCREEN_HEIGHT),paint);

        paint.setTextSize(30);
        canvas.drawText("Info",50,Constants.SCREEN_HEIGHT*19/20+10,paint);
        canvas.drawText("Fishing",190,Constants.SCREEN_HEIGHT*19/20+10,paint);
        canvas.drawText("Backpack",340,Constants.SCREEN_HEIGHT*19/20+10,paint);

        // Display messages and kill visibility slowly
        paint.setTextSize(25);
        paint.setColor(Color.WHITE);

        for( int i = 0; i < 16; i++){
            if(GamePanel.user.fishes.get(i) != null){
                paint.setColor(Color.argb(255 - i*15,0,0,0));
                //paint.setColor(GamePanel.user.fishes.get(i).getC);
                //canvas.drawText(GamePanel.user.fishes.get(i).getRank(),30, 60 + i*45, paint);
                //canvas.drawText(GamePanel.user.fishes.get(i).getRank()+" "+GamePanel.user.fishes.get(i).getType()+" -> "+GamePanel.user.fishes.get(i).getValue()+" Gold", 30, 60 + i*45, paint);
            }
        }
    }

    // Terminating current scene (Innate call)
    @Override
    public void terminate() {
        // Setting scene to the Main screen ( First in the array )
        SceneManager.ACTIVE_SCENE = 0;
    }
}
