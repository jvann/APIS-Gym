package com.rtu.gymforbeginners.classes;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import com.rtu.gymforbeginners.ExcerciseListActivity;
import com.rtu.gymforbeginners.MainActivity;
import com.rtu.gymforbeginners.R;
import com.rtu.gymforbeginners.WorkoutActivity;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.PersonViewHolder> {

    public static class PersonViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        TextView title;
        TextView day;
        TextView sets;

        public PersonViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            title = (TextView)itemView.findViewById(R.id.wo_title);
            day = (TextView)itemView.findViewById(R.id.wo_day);
            sets = (TextView) itemView.findViewById(R.id.wo_reps);
        }
    }

    List<Workout> workouts;
    Context context;

    public RVAdapter(List<Workout> workouts){
        this.workouts = workouts;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview, viewGroup, false);
        PersonViewHolder pvh = new PersonViewHolder(v);
        return pvh;

    }

    @Override
    public void onBindViewHolder(PersonViewHolder personViewHolder, final int i) {
        personViewHolder.title.setText(workouts.get(i).woTitle);
        personViewHolder.day.setText(workouts.get(i).woDay);
        personViewHolder.sets.setText(Integer.toString(workouts.get(i).woSets));
        final Context context = personViewHolder.title.getContext();

        personViewHolder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, WorkoutActivity.class);
                intent.putExtra("exList", workouts.get(i).woExcList);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return workouts.size();
    }
}


