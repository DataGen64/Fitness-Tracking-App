package com.example.calorietrackerapp;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.calorietrackerapp.Steps;
import com.example.calorietrackerapp.StepsDao;

@Database(entities = {Steps.class}, version = 2, exportSchema = false)

public abstract class StepsDatabase extends RoomDatabase {
    public abstract StepsDao StepsDao();
    private static volatile StepsDatabase INSTANCE;
    static StepsDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (StepsDatabase.class) {
                if (INSTANCE == null) { INSTANCE =
                        Room.databaseBuilder(context.getApplicationContext(), StepsDatabase.class, "stepsdatabase")
                                .build();
                } }
        }
        return INSTANCE; }
}