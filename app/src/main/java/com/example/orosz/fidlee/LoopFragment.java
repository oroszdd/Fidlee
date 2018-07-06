package com.example.orosz.fidlee;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoopFragment extends Fragment implements Runnable {

    // Create a new thread object targeting this class
    Thread thread = null;

    // Declaring variables for the passage of time
    private long currentTime, previousTime = 0;

    //private Item item;
    private String itemName;
    private int i = 0;


    public LoopFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_loop, container, false);

        // Starting thread (run()) method
        thread = new Thread(this);
        thread.start();

        return view;
    }

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
                MainActivity.user.items.add(0,item);

                // For test purposes
                Log.i("loop", "Value of the item: " + MainActivity.user.items.get(0).sell()+ ", Size: " + MainActivity.user.items.size() + ", Capacity: " + MainActivity.user.items.capacity());

                }
        }
    }
}
