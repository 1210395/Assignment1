package com.example.ass;

import androidx.annotation.NonNull;

public class Muscle {
    private final String muscle;

    public Muscle(String muscle) {
        this.muscle = muscle;
    }

    @NonNull
    @Override
    public String toString() {
        return  muscle;
    }
}
