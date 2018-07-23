package com.example.orosz.fidlee;

import android.graphics.Canvas;
import android.view.MotionEvent;

import java.util.ArrayList;

/*  SceneManager
    Giving rights from -> GamePanel
                   to  -> Active Scene
 */
public class SceneManager {
    private ArrayList<Scene> scenes = new ArrayList<>();
    public static int ACTIVE_SCENE;

    // Existing Scenes must be implemented HERE
    public SceneManager(){
        ACTIVE_SCENE = 0;
        scenes.add(new FishingGraphicScene());
        scenes.add(new FishingScene());
        scenes.add(new InfoScene());
        scenes.add(new BackpackScene());
    }

    public void motionEventHandler(MotionEvent event){
        scenes.get(ACTIVE_SCENE).motionEventHandler(event);
    }

    public void update(){
        scenes.get(ACTIVE_SCENE).update();

        // Always run the fishing scene even in the background
        if(ACTIVE_SCENE != 0){
            scenes.get(0).update();
        }
    }

    public void draw(Canvas canvas){
        scenes.get(ACTIVE_SCENE).draw(canvas);
    }
}
