package com.example.calorietrackerapp;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ReportFragment extends Fragment { View vDisplayUnit;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        vDisplayUnit = inflater.inflate(R.layout.report_fragment, container, false);
        return vDisplayUnit;


    }
}
