package com.example.calorietrackerapp;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;

import java.util.Calendar;
import java.util.Date;

public class ScheduledIntentService extends IntentService {

    Steps step;
    StepsDatabase db;

    static int counter=0;
    public ScheduledIntentService() {
        super("ScheduledIntentService");
    }
    @Override
    protected void onHandleIntent(Intent intent) {
         int steps  = step.getStepCount();
         db.StepsDao().deleteAll();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent,flags,startId);
    }

}
