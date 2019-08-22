package com.example.calorietrackerapp;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

@Entity
public class Steps {
        @PrimaryKey(autoGenerate = true) public int userid;
        @ColumnInfo(name = "number of Steps") public int stepCount;

        public Steps(int stepCount)
        {
            this.stepCount=stepCount;
        }

        public int getId()
        {
            return userid;
        }

        public int getStepCount()
        {
            return stepCount;
        }

        public void setStepCount(int stepCount )
        {
            this.stepCount = stepCount;
        }

}
