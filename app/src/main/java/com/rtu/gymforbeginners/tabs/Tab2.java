package com.rtu.gymforbeginners.tabs;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rtu.gymforbeginners.BuildConfig;
import com.rtu.gymforbeginners.ExcerciseActivity;
import com.rtu.gymforbeginners.ExcerciseListActivity;
import com.rtu.gymforbeginners.R;
import com.rtu.gymforbeginners.WorkoutActivity;
import com.rtu.gymforbeginners.classes.Excercise;
import com.rtu.gymforbeginners.classes.Workout;
import com.rtu.gymforbeginners.utils.CategoryExActivity;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


/**
 *
 */
public class Tab2 extends Fragment implements View.OnClickListener{

    FirebaseDatabase database;
    ArrayList<Excercise> exArm = new ArrayList<>();
    ArrayList<Excercise> exChest = new ArrayList<>();
    ArrayList<Excercise> exLeg = new ArrayList<>();
    ArrayList<Excercise> exShoulder = new ArrayList<>();
    ArrayList<Excercise> exAbs = new ArrayList<>();
    ArrayList<Excercise> exBack = new ArrayList<>();
    ArrayList<Excercise> exAll = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab_2,container,false);

        initializeData();
        Button buttonCategory1 = v.findViewById(R.id.category_1);
        Button buttonCategory2 = v.findViewById(R.id.category_2);
        Button buttonCategory3 = v.findViewById(R.id.category_3);
        Button buttonCategory4 = v.findViewById(R.id.category_4);
        Button buttonCategory5 = v.findViewById(R.id.category_5);
        Button buttonCategory6 = v.findViewById(R.id.category_6);
        Button buttonCategory7 = v.findViewById(R.id.category_7);
        Context context = v.getContext();

        buttonCategory1.setOnClickListener(this);
        buttonCategory2.setOnClickListener(this);
        buttonCategory3.setOnClickListener(this);
        buttonCategory4.setOnClickListener(this);
        buttonCategory5.setOnClickListener(this);
        buttonCategory6.setOnClickListener(this);
        buttonCategory7.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.category_1:
                Intent i = new Intent(getContext(), ExcerciseListActivity.class);
                i.putExtra("exList", exArm);
                i.putExtra("is_add",false);
                getContext().startActivity(i);
                break;
            case R.id.category_2:
                Intent i2 = new Intent(getContext(), ExcerciseListActivity.class);
                i2.putExtra("exList", exChest);
                i2.putExtra("is_add",false);
                getContext().startActivity(i2);
                break;
            case R.id.category_3:
                Intent i3 = new Intent(getContext(), ExcerciseListActivity.class);
                i3.putExtra("exList", exAbs);
                i3.putExtra("is_add",false);
                getContext().startActivity(i3);
                break;
            case R.id.category_4:
                Intent i4 = new Intent(getContext(), ExcerciseListActivity.class);
                i4.putExtra("exList", exBack);
                i4.putExtra("is_add",false);
                getContext().startActivity(i4);
                break;
            case R.id.category_5:
                Intent i5 = new Intent(getContext(), ExcerciseListActivity.class);
                i5.putExtra("exList", exShoulder);
                i5.putExtra("is_add",false);
                getContext().startActivity(i5);
                break;
            case R.id.category_6:
                Intent i6 = new Intent(getContext(), ExcerciseListActivity.class);
                i6.putExtra("exList", exLeg);
                i6.putExtra("is_add",false);
                getContext().startActivity(i6);
                break;
            case R.id.category_7:
                Intent i7 = new Intent(getContext(), ExcerciseListActivity.class);
                System.out.print("GVP");
                Log.v("E", "hola");
                i7.putExtra("exList", exAll);
                i7.putExtra("is_add",false);
                getContext().startActivity(i7);
                break;
        }
    }

    private void initializeData(){

        Log.v("AAAA", "AAAAAAAAAA");

        database.getReference().child("excercise").addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Excercise exercise = snapshot.getValue(Excercise.class);

                    switch (exercise.getMainMuscle()){
                        case "Triceps":
                        case "Biceps":
                            exArm.add(exercise);
                            break;
                        case "Legs":
                            exLeg.add(exercise);
                            break;
                        case "Chest":
                            exChest.add(exercise);
                            break;
                        case "Shoulders":
                            exShoulder.add(exercise);
                            break;
                        case "Abdominals":
                            exAbs.add(exercise);
                            break;
                        case "Back":
                            exBack.add(exercise);
                            break;
                    }

                    exAll.add(exercise);
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                Log.v("Error", "German");

            }

        });

    }
}