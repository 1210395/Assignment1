package com.example.ass;


public class Exercise {
    private String name;
    private String type;
    private String muscle;

    public Exercise(String name, String type, String muscle) {
        this.name = name;
        this.type = type;
        this.muscle = muscle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMuscle() {
        return muscle;
    }

    public void setMuscle(String muscle) {
        this.muscle = muscle;
    }

    @Override
    public String toString() {
        return  name + ' ' + type + ' ' + ' ' + muscle + ' ';
    }
}
