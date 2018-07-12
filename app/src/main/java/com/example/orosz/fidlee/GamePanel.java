package com.example.orosz.fidlee;

// https://www.youtube.com/watch?v=OojQitoAEXs

/*
    This is the Top level of the structure
    Only Android-Lifecycle related measurements can leave this class
 */

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GamePanel extends SurfaceView implements SurfaceHolder.Callback {

    public static User user;

    // Initializing the Main thread which is used for Scene and UI management
    private MainThread mainThread;

    // Initializing the FishingThread
    private FishingThread fishingThread;

    // Initializing the SceneManager responsible for swapping the current scene
    public static SceneManager sceneManager;

    // Constructor
    public GamePanel(Context context){
        super(context);

        // Creating User
        // Adding 100 null objects for FishingScene
        user = new User();
        for( int i = 0; i < 100; i++){
            user.fishes.add(null);
        }

        // Callback
        getHolder().addCallback(this);

        Constants.CURRENT_CONTEXT = context;

        // Creating the Main thread (most probably duplicate keeping for further observation)
        //thread = new MainThread(getHolder(), this);

        // Creating the FishingThread thread
        fishingThread = new FishingThread();
        fishingThread.start();

        // Creating the SceneManager
        sceneManager = new SceneManager();

        // No idea (, to be honest: I don't even care about it)
        setFocusable(true);
    }


    // SurfaceHolder related override
    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height){

    }

    // Method running when GamePanel is (re)created
    @Override
    public void surfaceCreated(SurfaceHolder holder){

        // Creating the main thread and starting it
        mainThread = new MainThread(getHolder(), this);
        mainThread.setRunning(true);
        mainThread.start();
    }

    // SurfaceHolder related override
    @Override
    public void surfaceDestroyed(SurfaceHolder holder){

        // End the Main thread on destroy
        boolean retry = true;
        while (true){
            try{
                mainThread.setRunning(false);
                mainThread.join();
            }catch(Exception e){
                e.printStackTrace();
            }
            retry = false;
        }
    }

    // Event handling
    @Override
    public boolean onTouchEvent(MotionEvent event){

        // Giving event handling rights to SceneManager
        sceneManager.motionEventHandler(event);

        return true;
    }

    // Update (Main thread)
    public void update(){

        // Giving update handling rights to SceneManager
        sceneManager.update();

    }

    // Drawing on Screen (Main thread)
    @Override
    public void draw(Canvas canvas){
        super.draw(canvas);

        // Giving draw handling rights to SceneManager
        sceneManager.draw(canvas);

    }
}
