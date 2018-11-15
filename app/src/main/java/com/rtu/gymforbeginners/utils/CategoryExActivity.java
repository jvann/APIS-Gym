package com.rtu.gymforbeginners.utils;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.rtu.gymforbeginners.ExcerciseActivity;
import com.rtu.gymforbeginners.R;
import com.rtu.gymforbeginners.classes.Excercise;
import com.rtu.gymforbeginners.classes.Workout;

import java.util.ArrayList;
import java.util.List;


public class CategoryExActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private List<Workout> workouts = new ArrayList<>();
    private List<Excercise> excercises;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_ex);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_ex);
        setSupportActionBar(toolbar);

        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setDisplayShowHomeEnabled(false);
        }

        ListView listView = findViewById(R.id.routine_listview_2);
        initializeData();

        CategoryExActivity.WorkoutAdapter workoutAdapter = new CategoryExActivity.WorkoutAdapter();
        listView.setAdapter(workoutAdapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }
        return super.onOptionsItemSelected(item);
    }

    private void initializeData(){
        excercises = new ArrayList<>();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Excercise excercise = excercises.get(position);
        Intent intent = new Intent(CategoryExActivity.this,ExcerciseActivity.class);
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
