package com.rtu.gymforbeginners;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import java.util.ArrayList;
import java.util.List;

import com.rtu.gymforbeginners.classes.Excercise;

public class WorkoutActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    ArrayList<Excercise> excercises;
    ArrayList<Excercise> allExcercises = new ArrayList<>();
    ListView listView;
    WorkoutAdapter workoutAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_workout);
        listView = findViewById(R.id.routine_listview);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_ex);
        setSupportActionBar(toolbar);

        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setDisplayShowHomeEnabled(false);
        }
        excercises = (ArrayList<Excercise>)getIntent().getSerializableExtra("exList");
        initializeData();
        workoutAdapter = new WorkoutAdapter();
        listView.setAdapter(workoutAdapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_excercise,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }
        if (item.getItemId() == R.id.add_workout)
        {
            Intent i = new Intent(this, ExcerciseListActivity.class);
            i.putExtra("exList", allExcercises);
            i.putExtra("is_add",true);
            startActivityForResult(i,2);

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 2 && resultCode == Activity.RESULT_OK)
        {
            Bundle bundle= data.getExtras();

            Excercise excercise = (Excercise)bundle.getSerializable("excercise");
            excercises.add(excercise);
            workoutAdapter.notifyDataSetChanged();

        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void initializeData(){


        allExcercises.add(new Excercise("Dips",3, 6,"Triceps",
                "Chest","Dip Station","Strenght", getString(R.string.dips),
                getResources().getIdentifier("dips", "drawable",BuildConfig.APPLICATION_ID)));
        allExcercises.add(new Excercise("Triceps Pushdown",3, 6,"Triceps",
                "None","Cable Pulley Station","Strenght",getString(R.string.triceps_pushdown),
                getResources().getIdentifier("tricep_pushdown", "drawable",BuildConfig.APPLICATION_ID)));
        allExcercises.add(new Excercise("Barbell Curl",3, 6, "Biceps",
                "None","Barbell","Strenght",getString(R.string.barbell_curl),
                getResources().getIdentifier("barbell_curl", "drawable",BuildConfig.APPLICATION_ID)));
        allExcercises.add(new Excercise("Dumbbell Bicep Curl",2, 6, "Biceps",
                "None","Dumbbell","Strenght",getString(R.string.dumbbell_bicep_curl),
                getResources().getIdentifier("dumbell_bicep_curl", "drawable",BuildConfig.APPLICATION_ID)));

        allExcercises.add(new Excercise("Leg Press",3, 6,"Legs",
                "None","Leg Press Machine","Strenght",getString(R.string.leg_press),
                getResources().getIdentifier("leg_press", "drawable",BuildConfig.APPLICATION_ID)));
        allExcercises.add(new Excercise("Barbell Squat",3, 6,"Legs",
                "Lower Back","Squat Rack","Strenght",getString(R.string.barbell_squat),
                getResources().getIdentifier("barbell_squat", "drawable",BuildConfig.APPLICATION_ID)));

        allExcercises.add(new Excercise("Barbell Bench Press",3, 6,"Chest",
                "Shoulders, Triceps","Barbell, Bench","Strenght",getString(R.string.barbell_bench_press),
                getResources().getIdentifier("barbell_bench_press", "drawable",BuildConfig.APPLICATION_ID)));
        allExcercises.add(new Excercise("Dumbbell Flyes",3, 6,"Chest",
                "Shoulders","Dumbbell","Strenght",getString(R.string.dumbbell_flyes),
                getResources().getIdentifier("dumbell_flyes", "drawable",BuildConfig.APPLICATION_ID)));

        allExcercises.add(new Excercise("Seated Barbell Press",3, 6,"Shoulders",
                "Trapezius","Barbell","Strenght",getString(R.string.seated_barbell_press),
                getResources().getIdentifier("seated_barbell_press", "drawable",BuildConfig.APPLICATION_ID)));
        allExcercises.add(new Excercise("Power Partials",3, 6,"Shoulders",
                "Trapezius","Dumbbell","Strenght",getString(R.string.power_partials),
                getResources().getIdentifier("power_partials", "drawable",BuildConfig.APPLICATION_ID)));

        allExcercises.add(new Excercise("Decline Crunch",3, 6,"Abdominals",
                "Lower Back, Core","Decline Bench","Strenght",getString(R.string.decline_crunch),
                getResources().getIdentifier("decline_crunch", "drawable",BuildConfig.APPLICATION_ID)));
        allExcercises.add(new Excercise("Leg Raise on Parallel Bars",4, 10,"Abdominals",
                "Lower Back","Vertical Leg Raise Bench","Strenght",getString(R.string.leg_raise_parrallel_bars),
                getResources().getIdentifier("leg_raise_parallel_bars", "drawable",BuildConfig.APPLICATION_ID)));

        allExcercises.add(new Excercise("Wide-Grip Lat Pulldown",3, 6,"Back",
                "Biceps","Machine","Strenght",getString(R.string.wide_grip_lat_pulldown),
                getResources().getIdentifier("wide_grip_lat_pulldown", "drawable",BuildConfig.APPLICATION_ID)));
        allExcercises.add(new Excercise("Elevated Cable Rows",3, 6,"Back",
                "Biceps","Machine","Strenght",getString(R.string.elevated_cable_rows),
                getResources().getIdentifier("elevated_cable_rows", "drawable",BuildConfig.APPLICATION_ID)));

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(WorkoutActivity.this,"Button 1 pressed", Toast.LENGTH_SHORT).show();
        Excercise excercise = excercises.get(position);
        Intent intent = new Intent(WorkoutActivity.this,ExcerciseActivity.class);
        intent.putExtra("excercise", excercise);
        startActivity(intent);
    }

    class WorkoutAdapter extends BaseAdapter{

        @Override
        public int getCount(){
            return excercises.size();
        }

        @Override
        public Excercise getItem(int i){
            return null;
        }

        @Override
        public long getItemId(int i){
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup){
            view = getLayoutInflater().inflate(R.layout.excercise_list,null);
            //ImageView excerciseFoto = (ImageView)findViewById(R.id.excercise_foto);
            TextView excerciseName = (TextView)view.findViewById(R.id.excercise_name);

            excerciseName.setText(excercises.get(i).getName());
            return view;
        }
    }
}
