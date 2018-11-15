package com.rtu.gymforbeginners;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.rtu.gymforbeginners.classes.Excercise;


public class ExcerciseActivity extends AppCompatActivity {

    TextView tvMainMuscle;
    TextView tvOtherMuscles;
    TextView tvName;
    TextView tvSetsReps;
    TextView tvEquipment;
    TextView tvType;
    TextView tvInfo;
    ImageView ivImage;
    Drawable drawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excercise);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_ex);
        setSupportActionBar(toolbar);

        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setDisplayShowHomeEnabled(false);

        }

        Excercise excercise = (Excercise) getIntent().getExtras().getSerializable("excercise");
        tvMainMuscle = findViewById(R.id.exMainMuscleText);
        tvOtherMuscles = findViewById(R.id.exOtherMusclesText);
        tvName = findViewById(R.id.exName);
        tvSetsReps = findViewById(R.id.exSetsReps);
        tvEquipment = findViewById(R.id.exEquipmentText);
        tvType = findViewById(R.id.exTypeText);
        tvInfo = findViewById(R.id.exInfo);
        ivImage = findViewById(R.id.exImage);
        drawable = getResources().getDrawable(excercise.getImage());

        tvName.setText(excercise.getName());
        tvMainMuscle.setText(excercise.getMainMuscle());
        tvOtherMuscles.setText(excercise.getOtherMuscles());
        tvSetsReps.setText(Integer.toString(excercise.getSets()) + " sets of "
                + Integer.toString(excercise.getReps()) + " reps");
        tvEquipment.setText(excercise.getEquipment());
        tvType.setText(excercise.getType());
        tvInfo.setText(getString(R.string.barbell_bench_press));
        ivImage.setImageDrawable(drawable);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }


}
