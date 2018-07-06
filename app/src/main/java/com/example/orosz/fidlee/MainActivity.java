package com.example.orosz.fidlee;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // User data
    public static User user;

    // Fragment manager object for fragment managing
    public static FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize user
        user = new User();

        // Necessary in the following commands
        fragmentManager = getSupportFragmentManager();

        // Is container available? ( If it is not null, then not )
        if(findViewById(R.id.fragment_container)!=null){

            // Is it resumed?
            if(savedInstanceState!=null){
                return;
            }

            // Creating the main fragment and putting it on screen
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            FishingFragment fishingFragment = new FishingFragment();

            fragmentTransaction.add(R.id.fragment_container,fishingFragment,null);

            fragmentTransaction.commit();

            }
        }
    }
