package com.rtu.gymforbeginners.tabs;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;


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
 * Created by Edwin on 15/02/2015.
 */
public class Tab2 extends Fragment implements View.OnClickListener{

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
                i7.putExtra("exList", exAll);
                i7.putExtra("is_add",false);
                getContext().startActivity(i7);
                break;
        }
    }

    private void initializeData(){
        exArm.add(new Excercise("Dips",3, 6,"Triceps",
                "Chest","Dip Station","Strenght", getString(R.string.dips),
                getResources().getIdentifier("dips", "drawable",BuildConfig.APPLICATION_ID)));
        exArm.add(new Excercise("Triceps Pushdown",3, 6,"Triceps",
                "None","Cable Pulley Station","Strenght",getString(R.string.triceps_pushdown),
                getResources().getIdentifier("tricep_pushdown", "drawable",BuildConfig.APPLICATION_ID)));
        exArm.add(new Excercise("Barbell Curl",3, 6, "Biceps",
                "None","Barbell","Strenght",getString(R.string.barbell_curl),
                getResources().getIdentifier("barbell_curl", "drawable",BuildConfig.APPLICATION_ID)));
        exArm.add(new Excercise("Dumbbell Bicep Curl",2, 6, "Biceps",
                "None","Dumbbell","Strenght",getString(R.string.dumbbell_bicep_curl),
                getResources().getIdentifier("dumbell_bicep_curl", "drawable",BuildConfig.APPLICATION_ID)));

        exLeg.add(new Excercise("Leg Press",3, 6,"Legs",
                "None","Leg Press Machine","Strenght",getString(R.string.leg_press),
                getResources().getIdentifier("leg_press", "drawable",BuildConfig.APPLICATION_ID)));
        exLeg.add(new Excercise("Barbell Squat",3, 6,"Legs",
                "Lower Back","Squat Rack","Strenght",getString(R.string.barbell_squat),
                getResources().getIdentifier("barbell_squat", "drawable",BuildConfig.APPLICATION_ID)));

        exChest.add(new Excercise("Barbell Bench Press",3, 6,"Chest",
                "Shoulders, Triceps","Barbell, Bench","Strenght",getString(R.string.barbell_bench_press),
                getResources().getIdentifier("barbell_bench_press", "drawable",BuildConfig.APPLICATION_ID)));
        exChest.add(new Excercise("Dumbbell Flyes",3, 6,"Chest",
                "Shoulders","Dumbbell","Strenght",getString(R.string.dumbbell_flyes),
                getResources().getIdentifier("dumbell_flyes", "drawable",BuildConfig.APPLICATION_ID)));

        exShoulder.add(new Excercise("Seated Barbell Press",3, 6,"Shoulders",
                "Trapezius","Barbell","Strenght",getString(R.string.seated_barbell_press),
                getResources().getIdentifier("seated_barbell_press", "drawable",BuildConfig.APPLICATION_ID)));
        exShoulder.add(new Excercise("Power Partials",3, 6,"Shoulders",
                "Trapezius","Dumbbell","Strenght",getString(R.string.power_partials),
                getResources().getIdentifier("power_partials", "drawable",BuildConfig.APPLICATION_ID)));

        exAbs.add(new Excercise("Decline Crunch",3, 6,"Abdominals",
                "Lower Back, Core","Decline Bench","Strenght",getString(R.string.decline_crunch),
                getResources().getIdentifier("decline_crunch", "drawable",BuildConfig.APPLICATION_ID)));
        exAbs.add(new Excercise("Leg Raise on Parallel Bars",4, 10,"Abdominals",
                "Lower Back","Vertical Leg Raise Bench","Strenght",getString(R.string.leg_raise_parrallel_bars),
                getResources().getIdentifier("leg_raise_parallel_bars", "drawable",BuildConfig.APPLICATION_ID)));

        exBack.add(new Excercise("Wide-Grip Lat Pulldown",3, 6,"Back",
                "Biceps","Machine","Strenght",getString(R.string.wide_grip_lat_pulldown),
                getResources().getIdentifier("wide_grip_lat_pulldown", "drawable",BuildConfig.APPLICATION_ID)));
        exBack.add(new Excercise("Elevated Cable Rows",3, 6,"Back",
                "Biceps","Machine","Strenght",getString(R.string.elevated_cable_rows),
                getResources().getIdentifier("elevated_cable_rows", "drawable",BuildConfig.APPLICATION_ID)));

    }
}