package com.example.calorietrackerapp;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Fragment;
import android.os.SystemClock;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import static android.support.v4.content.ContextCompat.getSystemService;

public class StepsFragment extends Fragment {
    View vDisplayUnit;
    StepsDatabase db = null;
    TextView textView_read = null;
    TextView textView_delete = null;
    TextView textView_update = null;
    TextView textView_insert = null;
    EditText editText;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        vDisplayUnit = inflater.inflate(R.layout.steps_fragment, container, false);

        db = Room.databaseBuilder(getActivity().getApplicationContext(), StepsDatabase.class, "StepsDatabase").fallbackToDestructiveMigration().build();

        Button addButton = (Button) vDisplayUnit.findViewById(R.id.addButton);
        editText = (EditText) vDisplayUnit.findViewById(R.id.editText);
        textView_insert = (TextView) vDisplayUnit.findViewById(R.id.textView);
        Button readButton = (Button) vDisplayUnit.findViewById(R.id.readButton);
        textView_read = (TextView) vDisplayUnit.findViewById(R.id.textView_read);


            final TextView textView = (TextView) vDisplayUnit.findViewById(R.id.textView);

        addButton.setOnClickListener(new View.OnClickListener() { //including onClick() method
            public void onClick(View v) {
          InsertDatabase insertDatabase = new InsertDatabase();
            insertDatabase.execute();
            }
                                     });


        readButton.setOnClickListener(new View.OnClickListener() {
            //including onClick() method
            public void onClick(View v) {
                ReadDatabase readDatabase = new ReadDatabase();
                readDatabase.execute();
            }
        });




        return vDisplayUnit;
    }

    private class InsertDatabase extends AsyncTask<Void, Void, String> {
        @Override
        protected String doInBackground(Void... params) {
            if (!(editText.getText().toString().isEmpty())) {
                String details = editText.getText().toString();
                Steps steps = new Steps(Integer.parseInt(details));
                long id = db.StepsDao().insert(steps);
                return (id + " " + Integer.parseInt(details));
            } else
                return "";
        }


        protected void onPostExecute(String details) {
            textView_insert.setText("Added Record: " + details);
        }
    }


    private class ReadDatabase extends AsyncTask<Void, Void, String> {
        @Override
        protected String doInBackground(Void... params) {
            List <Steps> steps = db.StepsDao().getAll();
            if (!(steps.isEmpty() || steps == null)) {
                String allUsers = "";
                for (Steps temp : steps) {
                    String userstr = (temp.getId()+ "  " + temp.getStepCount());
                    allUsers = allUsers +  userstr;
                }
                return allUsers;
            }
            else
                return "";
        }

        @Override
        protected void onPostExecute(String allUsers) {
            textView_read.setText("All data: " + allUsers);
        }
    }

}