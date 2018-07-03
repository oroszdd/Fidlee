package com.example.orosz.fidlee;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class UiFragment extends Fragment {

    private Button backpackButton, fishingButton, infoButton;

    public UiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ui, container, false);

        // Connect the button objects with the layout
        backpackButton = view.findViewById(R.id.backpackButton);
        fishingButton = view.findViewById(R.id.fishingButton);
        infoButton = view.findViewById(R.id.infoButton);

        // Set the buttons onClickListener
        // If clicked swap existing fragment with a corresponding new one
        // Tomi is a faggot
        backpackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new BackpackFragment(), null).commit();
            }
        });

        fishingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new FishingFragment(), null).commit();
            }
        });

        infoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new InfoFragment(), null).commit();
            }
        });

        return view;
    }

}
