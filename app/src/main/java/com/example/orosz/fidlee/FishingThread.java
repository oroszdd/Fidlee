package com.example.orosz.fidlee;

import android.util.Log;

public class FishingThread extends Thread {

    // Declaring variables for the passage of time
    private long currentTime, previousTime = 0;

    FishingThread(){

    }

    // Getting called by .start() (In GamePanel)
    @Override
    public void run() {

        while (true) {

            // Ask system for current time in millis
            currentTime = System.currentTimeMillis();

            // Check if enough time has passed since the last loop to make changes
            if (currentTime - previousTime >= 1000) {
                previousTime = currentTime;

                // Main Loop body

                Item item = Item.get();

                //itemName = new String();

                //itemName = "item" + i;

                //Item itemName = Item.get();

                // Add item to Data dump
                GamePanel.user.items.add(0,item);


                // For test purposes
                Log.i("loop", "Value of the item: " + GamePanel.user.items.get(0).sell()+ ", Size: " + GamePanel.user.items.size() + ", Capacity: " + GamePanel.user.items.capacity());
                //Log.i("Loop", "Looping...");
            }
        }
    }
}
