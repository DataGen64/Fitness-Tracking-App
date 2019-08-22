package com.example.calorietrackerapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class CalorieTrackFragment extends Fragment { View vDisplayUnit;

    String name;
    TextView calGoal;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        name = getArguments().getString("fname");
        vDisplayUnit = inflater.inflate(R.layout.calorietrack_fragment, container, false);
        calGoal = vDisplayUnit.findViewById(R.id.textView2);
        return vDisplayUnit;
    }

    public void onClick(View v) {
// Get myUnits file
 SharedPreferences myCalGoal =
        getActivity().getSharedPreferences("CalGoalEntered", getActivity().MODE_PRIVATE);
        String CalGoal = myCalGoal.getString("message",null);
        calGoal.setText(CalGoal);
    }
}