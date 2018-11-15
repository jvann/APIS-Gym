package com.rtu.gymforbeginners.tabs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import com.rtu.gymforbeginners.AddWorkoutActivity;
import com.rtu.gymforbeginners.BuildConfig;
import com.rtu.gymforbeginners.ExcerciseActivity;
import com.rtu.gymforbeginners.R;
import com.rtu.gymforbeginners.classes.Excercise;
import com.rtu.gymforbeginners.classes.RVAdapter;
import com.rtu.gymforbeginners.classes.Workout;

/**
 * Created by Edwin on 15/02/2015.
 */

public class Tab1 extends Fragment {

    private List<Workout> workouts = new ArrayList<>();
    private RecyclerView rv;
    FloatingActionButton newWorkout;
    RVAdapter adapter;
    ArrayList<Excercise> exMonday = new ArrayList<>();
    ArrayList<Excercise> exTuesday = new ArrayList<>();
    ArrayList<Excercise> exWednesday = new ArrayList<>();
    ArrayList<Excercise> exThursday = new ArrayList<>();
    ArrayList<Excercise> exFriday = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.tab_1,container,false);
        newWorkout = v.findViewById(R.id.fabNewWorkout);

        rv = v.findViewById(R.id.recycler_view);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        initializeData();
        initializeAdapter();


        newWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //workouts.add(new Workout("Test", "Monday", 5, null));
                //initializeAdapter();
                Intent i = new Intent(getContext(), AddWorkoutActivity.class);
                startActivityForResult(i,1);
            }
        });

        return v;
    }

    private void initializeData(){

        exMonday.add(new Excercise("Barbell Bench Press",3, 6,"Chest",
                "Shoulders, Triceps","Barbell, Bench","Strenght",getString(R.string.barbell_bench_press),
                getResources().getIdentifier("barbell_bench_press", "drawable", BuildConfig.APPLICATION_ID)));
        exMonday.add(new Excercise("Dumbbell Flyes",3, 6,"Chest",
                "Shoulders","Dumbbell","Strenght",getString(R.string.dumbbell_flyes),
                getResources().getIdentifier("dumbell_flyes", "drawable",BuildConfig.APPLICATION_ID)));
       exMonday.add(new Excercise("Barbell Curl",3, 6, "Biceps",
                "None","Barbell","Strenght",getString(R.string.barbell_curl),
                getResources().getIdentifier("barbell_curl", "drawable",BuildConfig.APPLICATION_ID)));
        exMonday.add(new Excercise("Dumbbell Bicep Curl",2, 6, "Biceps",
                "None","Dumbbell","Strenght",getString(R.string.dumbbell_bicep_curl),
                getResources().getIdentifier("dumbell_bicep_curl", "drawable",BuildConfig.APPLICATION_ID)));

        exTuesday.add(new Excercise("Leg Press",3, 6,"Legs",
                "None","Leg Press Machine","Strenght",getString(R.string.leg_press),
                getResources().getIdentifier("leg_press", "drawable",BuildConfig.APPLICATION_ID)));
        exTuesday.add(new Excercise("Barbell Squat",3, 6,"Legs",
                "Lower Back","Squat Rack","Strenght",getString(R.string.barbell_squat),
                getResources().getIdentifier("barbell_squat", "drawable",BuildConfig.APPLICATION_ID)));

        exThursday.add(new Excercise("Seated Barbell Press",3, 6,"Shoulders",
                "Trapezius","Barbell","Strenght",getString(R.string.seated_barbell_press),
                getResources().getIdentifier("seated_barbell_press", "drawable",BuildConfig.APPLICATION_ID)));
        exThursday.add(new Excercise("Power Partials",3, 6,"Shoulders",
                "Trapezius","Dumbbell","Strenght",getString(R.string.power_partials),
                getResources().getIdentifier("power_partials", "drawable",BuildConfig.APPLICATION_ID)));
        exThursday.add(new Excercise("Decline Crunch",3, 6,"Abdominals",
                "Lower Back, Core","Decline Bench","Strenght",getString(R.string.decline_crunch),
                getResources().getIdentifier("decline_crunch", "drawable",BuildConfig.APPLICATION_ID)));
        exThursday.add(new Excercise("Leg Raise on Parallel Bars",4, 10,"Abdominals",
                "Lower Back","Vertical Leg Raise Bench","Strenght",getString(R.string.leg_raise_parrallel_bars),
                getResources().getIdentifier("leg_raise_parallel_bars", "drawable",BuildConfig.APPLICATION_ID)));

        exFriday.add(new Excercise("Wide-Grip Lat Pulldown",3, 6,"Back",
                "Biceps","Machine","Strenght",getString(R.string.wide_grip_lat_pulldown),
                getResources().getIdentifier("wide_grip_lat_pulldown", "drawable",BuildConfig.APPLICATION_ID)));
        exFriday.add(new Excercise("Elevated Cable Rows",3, 6,"Back",
                "Biceps","Machine","Strenght",getString(R.string.elevated_cable_rows),
                getResources().getIdentifier("elevated_cable_rows", "drawable",BuildConfig.APPLICATION_ID)));
        exFriday.add(new Excercise("Barbell Curl",3, 6, "Biceps",
                "None","Barbell","Strenght",getString(R.string.barbell_curl),
                getResources().getIdentifier("barbell_curl", "drawable",BuildConfig.APPLICATION_ID)));
        exFriday.add(new Excercise("Dumbbell Bicep Curl",2, 6, "Biceps",
                "None","Dumbbell","Strenght",getString(R.string.dumbbell_bicep_curl),
                getResources().getIdentifier("dumbell_bicep_curl", "drawable",BuildConfig.APPLICATION_ID)));


        workouts.add(new Workout("Chest and Triceps", "Monday", exMonday.size(), exMonday));
        workouts.add(new Workout("Legs", "Tuesday", exTuesday.size(), exTuesday));
        workouts.add(new Workout("Shoulder, Abs", "Thursday", exTuesday.size(), exThursday));
        workouts.add(new Workout("Back, Biceps", "Friday", exFriday.size(), exFriday));
    }

    private void initializeAdapter(){
        adapter = new RVAdapter(workouts);
        rv.setAdapter(adapter);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 1 && resultCode == Activity.RESULT_OK)
        {
            Bundle bundle=data.getExtras();
            String workoutName = bundle.getString("workoutName");
            String workoutDay = bundle.getString("workoutDay");
            workouts.add(new Workout(workoutName,workoutDay,0, null));
            initializeAdapter();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
