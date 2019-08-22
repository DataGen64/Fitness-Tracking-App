package com.example.calorietrackerapp;

import android.app.Fragment;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class HomeScreen extends Fragment {
    View vDisplayHome;
    String name;
    String calGoal;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        Date currentTime = Calendar.getInstance().getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String date = sdf.format(currentTime);
        System.out.println(date);
        name = getArguments().getString("fname");
        vDisplayHome = inflater.inflate(R.layout.home_screen, container, false);
        Button setCalories = vDisplayHome.findViewById(R.id.setCalButton);

        TextView dateview = (TextView) vDisplayHome.findViewById(R.id.DateView);
        dateview.setText(date);
        TextView welcomeView = (TextView) vDisplayHome.findViewById(R.id.HomeScreen_welcome);
        welcomeView.setText("Welcome to Calorie Tracker app " + name );
        final TextView setGoal = (TextView) vDisplayHome.findViewById(R.id.CalGoalSet);
        final EditText caloriesGoal = (EditText) vDisplayHome.findViewById(R.id.View_CalGoal);

        setCalories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                calGoal = caloriesGoal.getText().toString();
                setGoal.setText("Today Calorie Goal Set to: " + calGoal);
                SharedPreferences spMySteps = getActivity().getSharedPreferences("CalGoalEntered", getActivity().MODE_PRIVATE);
                String myCalGoal="Calorie Goal: " + calGoal ;
                String myName= name ;
                SharedPreferences.Editor eMyUnits = spMySteps.edit();
                eMyUnits.putString("calGoal", myCalGoal);
                eMyUnits.putString("name", myName);
                eMyUnits.apply();
            }});
       return vDisplayHome;
    }
}
