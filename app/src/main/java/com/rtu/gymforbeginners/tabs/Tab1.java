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
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rtu.gymforbeginners.AddWorkoutActivity;
import com.rtu.gymforbeginners.BuildConfig;
import com.rtu.gymforbeginners.ExcerciseActivity;
import com.rtu.gymforbeginners.R;
import com.rtu.gymforbeginners.classes.Excercise;
import com.rtu.gymforbeginners.classes.RVAdapter;
import com.rtu.gymforbeginners.classes.Workout;

/**
 */

public class Tab1 extends Fragment {

    private List<Workout> workouts = new ArrayList<>();
    private RecyclerView rv;
    FirebaseDatabase database;
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

        database.getReference().child("excercise").addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Excercise exercise = snapshot.getValue(Excercise.class);

                    switch (exercise.getMainMuscle()){
                        case "Triceps":
                        case "Biceps":
                            exMonday.add(exercise);
                            break;
                        case "Legs":
                            exThursday.add(exercise);
                            break;
                        case "Chest":
                            exThursday.add(exercise);
                            break;
                        case "Shoulders":
                            exTuesday.add(exercise);
                            break;
                        case "Abdominals":
                            exFriday.add(exercise);
                            break;
                        case "Back":
                            exTuesday.add(exercise);
                            break;
                    }


                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                Log.v("Error", "German");

            }

        });


        Log.v("e", String.valueOf(exMonday.size()));

        workouts.add(new Workout("Biceps and Tricep", "Monday", 4, exMonday));
        workouts.add(new Workout("Shoulders and Back", "Tuesday", 4, exTuesday));
        workouts.add(new Workout("Chest and Legs", "Thursday", 4, exThursday));
        workouts.add(new Workout("Abs", "Friday", 2, exFriday));
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
