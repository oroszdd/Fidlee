package com.example.orosz.fidlee;

// Loop on a new thread



import android.util.Log;

public class MyThread extends Thread {

    Thread thread = new Thread(this);

    private long currentTime, previousTime = 0;

    public MyThread(){

    }

    @Override
    public void run() {
        while (true) {
            currentTime = System.currentTimeMillis();
            if (currentTime - previousTime >= 1000) {
                Log.i("loop", "Eltelt 1 sec");

                previousTime = currentTime;
            }
        }
    }
}
