package com.example.ass;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class ExercisesActivity extends AppCompatActivity {
    private ListView listView;
    private String muscle;
    private ArrayList<Exercise> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises);

        list=new ArrayList<>();
        muscle=getIntent().getStringExtra("muscle");
        listView=findViewById(R.id.listView);
        fillExercises();
        ArrayAdapter<Exercise> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);
        findViewById(R.id.check).setOnClickListener(e-> Toast.makeText(this,"Congrats!!!!",Toast.LENGTH_SHORT).show());
        findViewById(R.id.closeApp).setOnClickListener(e-> System.exit(0));
        HandleListClicked();

    }

    private void HandleListClicked() {
        listView.setOnItemClickListener((parent, view, position, id) -> {
             String selectedItem = parent.getItemAtPosition(position).toString();
             Toast.makeText(getApplicationContext(),"you selected "+selectedItem,Toast.LENGTH_SHORT).show();
        });
    }
        private void fillExercises(){
        list=new ArrayList<>();
        switch (muscle){
            case"Chest":
                list.add(new Exercise("Bench Press", "Gym", "Chest"));
                list.add(new Exercise("Push-Up", "Home", "Chest"));
                break;
            case"Biceps":
                list.add(new Exercise("Bicep Curl", "Gym", "Biceps"));
                break;
            case"Back":
                list.add(new Exercise("Pull-Up", "Street", "Back"));
                list.add(new Exercise("Deadlift", "Gym", "Back"));
                list.add(new Exercise("Lat Pulldown", "Gym", "Back"));
                break;
            case "Shoulders":
                list.add(new Exercise("Shoulder Press", "Gym", "Shoulders"));
                break;
            case "Triceps":
                list.add(new Exercise("Dips", "Street", "Triceps"));
                break;
            case "Abs":
                list.add(new Exercise("Crunch", "Home", "Abs"));
                list.add(new Exercise("Plank", "Home", "Abs"));
                break;
            case "Legs":
                list.add(new Exercise("Running", "Street", "Legs"));
                list.add(new Exercise("Bodyweight Squat", "Home", "Legs"));
                break;
            case "Full Body":
                list.add(new Exercise("Burpees", "Street", "Full Body"));
                list.add(new Exercise("Burpees", "Street", "Full Body"));
                list.add(new Exercise("Mountain Climbers", "Home", "Full Body"));
                list.add(new Exercise("Kettlebell Swings", "Home", "Full Body"));
                list.add(new Exercise("Lunges", "Gym", "Full Body"));
                list.add(new Exercise("Push-ups", "Home", "Full Body"));
                list.add(new Exercise("Pull-ups", "Gym", "Full Body"));
                list.add(new Exercise("Dips", "Outdoor", "Full Body"));
                list.add(new Exercise("Squats", "Home", "Full Body"));
                list.add(new Exercise("Deadlifts", "Gym", "Full Body"));
                list.add(new Exercise("Overhead Press", "Gym", "Full Body"));
                break;

        }
    }
}