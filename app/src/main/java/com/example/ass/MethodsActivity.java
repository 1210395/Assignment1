package com.example.ass;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MethodsActivity extends AppCompatActivity {
    private Spinner spinner;
    private String username,option;
    private ArrayList<Exercise> list=new ArrayList<>();
    @SuppressLint({"ResourceAsColor", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_methods);
         username=getIntent().getStringExtra("username");
         option=getIntent().getStringExtra("option");
        System.out.println(option);
         spinner=findViewById(R.id.spinner);
         fillExercises();
        ((TextView)findViewById(R.id.headerMethodsActivity)).setText(option);
        ArrayAdapter<Exercise> adapter = new ArrayAdapter<Exercise>(getApplicationContext(),  android.R.layout.simple_spinner_dropdown_item, list);
        adapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        findViewById(R.id.backToMainButton).setBackgroundColor(R.color.primaryDarkColor);
        findViewById(R.id.backToMainButton).setOnClickListener(e->{
            returnToMainAcitivity(username);
        });

    }
    private void fillExercises(){
        list=new ArrayList<>();
        switch (option){
            case"Gym Exercises":
                list.add(new Exercise("Bench Press", "Gym", "Chest"));
                list.add(new Exercise("Deadlift", "Gym", "Back"));
                list.add(new Exercise("Lat Pulldown", "Gym", "Back"));
                list.add(new Exercise("Shoulder Press", "Gym", "Shoulders"));
                list.add(new Exercise("Bicep Curl", "Gym", "Biceps"));
                break;
            case"Home Exercises":
                list.add(new Exercise("Push-Up", "Home", "Chest"));
                list.add(new Exercise("Bodyweight Squat", "Home", "Legs"));
                list.add(new Exercise("Crunch", "Home", "Abs"));
                list.add(new Exercise("Plank", "Home", "Abs"));
                break;
            case "Street Exercises":
                list.add(new Exercise("Pull-Up", "Street", "Back"));
                list.add(new Exercise("Dips", "Street", "Triceps"));
                list.add(new Exercise("Running", "Street", "Legs"));
                list.add(new Exercise("Burpees", "Street", "Full Body"));
                break;
            default:
                returnToMainAcitivity(username);
                break;
        }
    }
    private void returnToMainAcitivity(String username){
        Intent intent=new Intent(this,MainActivity.class);
        intent.putExtra("username",username);
        startActivity(intent);
        finish();
    }
}