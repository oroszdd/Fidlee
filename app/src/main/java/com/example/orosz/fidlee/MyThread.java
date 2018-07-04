package com.example.orosz.fidlee;

// Loop on a new thread



import android.util.Log;

// Extends Thread for the run method ( and start method when called )
// Can be swapped to runnable?
public class MyThread extends Thread {

    // Create a new thread object targeting this class
    Thread thread = new Thread(this);

    // Declaring variables for the passage of time
    private long currentTime, previousTime = 0;

    private CaughtList caught = new CaughtList();

    private Item item = new Item() {
        @Override
        public int sell() {
            return 0;
        }
    };

    Fish fish = Fish.get();

    public MyThread(){

    }

    @Override
    public void run() {
        while (true) {

            // Ask system for current time in millis
            currentTime = System.currentTimeMillis();

            // Check if enough time has passed since the last loop to make changes
            if (currentTime - previousTime >= 6000) {
                previousTime = currentTime;

                // Main Loop body

                item = Item.get();

                // For test purposes
                Log.i("loop", "Value of the item: " + item.sell());

            }
        }
    }
}
