package com.example.ass;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MusclesActivity extends AppCompatActivity {
    private String username,option;
    private ArrayList<Muscle> list=new ArrayList<>();
    @SuppressLint({"ResourceAsColor", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_methods);
         username=getIntent().getStringExtra("username");
         option=getIntent().getStringExtra("option");
        System.out.println(option);
        Spinner spinner = findViewById(R.id.spinner);
         fillMuscles();
        ((TextView)findViewById(R.id.headerMethodsActivity)).setText(option);
        ArrayAdapter<Muscle> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, list);
        adapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        findViewById(R.id.backToMainButton).setBackgroundColor(R.color.primaryDarkColor);
        findViewById(R.id.backToMainButton).setOnClickListener(e-> returnToMainAcitivity(username));
        findViewById(R.id.confirm_button_MethodsActivity).setOnClickListener(e->{
            if(spinner.getSelectedItem()==null)
                Toast.makeText(this, "Nothing select", Toast.LENGTH_SHORT);
             else
                startExerciseActivity(spinner.getSelectedItem().toString());
        });

    }

private void fillMuscles(){
        list=new ArrayList<>();
        switch (option){
            case"Gym Exercises":
                list.add(new Muscle("Chest"));
                list.add(new Muscle( "Back"));
                list.add(new Muscle("Shoulders"));
                list.add(new Muscle( "Biceps"));
                break;
            case"Home Exercises":
                list.add(new Muscle("Chest"));
                list.add(new Muscle("Legs"));
                list.add(new Muscle( "Abs"));
                break;
            case "Street Exercises":
                list.add(new Muscle("Back"));
                list.add(new Muscle("Triceps"));
                list.add(new Muscle("Legs"));
                list.add(new Muscle("Full Body"));
                break;
            default:
                returnToMainAcitivity(username);
                break;
        }
    }
    private void startExerciseActivity(String muscle){
        Intent intent=new Intent(this, ExercisesActivity.class);
        intent.putExtra("muscle",muscle);
        startActivity(intent);
    }
    private void returnToMainAcitivity(String username){
        Intent intent=new Intent(this,MainActivity.class);
        intent.putExtra("username",username);
        startActivity(intent);
        finish();
    }
}