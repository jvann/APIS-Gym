package com.rtu.gymforbeginners;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.rtu.gymforbeginners.classes.Excercise;
import com.rtu.gymforbeginners.utils.CategoryExActivity;

import java.util.ArrayList;

public class ExcerciseListActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    ArrayList<Excercise> excercises;
    boolean boolIsAdd = false;
    Drawable drawable;
    ImageView excerciseFoto;
    TextView excerciseName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excercise_list);
        ListView listView = findViewById(R.id.excercise_listview);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_ex);
        setSupportActionBar(toolbar);

        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setDisplayShowHomeEnabled(false);
        }

        excercises = new ArrayList<>();
        excercises = (ArrayList<Excercise>)getIntent().getSerializableExtra("exList");
        boolIsAdd = getIntent().getExtras().getBoolean("is_add");

        ExcerciseAdapter excerciseAdapter = new ExcerciseAdapter();
        listView.setAdapter(excerciseAdapter);
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

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Excercise excercise = excercises.get(position);

        if (boolIsAdd){
            Intent i = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("excercise", excercise);
            i.putExtras(bundle);
            setResult(Activity.RESULT_OK,i);
            finish();
        }
        else {
        Intent intent = new Intent(ExcerciseListActivity.this,ExcerciseActivity.class);
        intent.putExtra("excercise", excercise);
        startActivity(intent);}
    }





    class ExcerciseAdapter extends BaseAdapter {

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
            //drawable = getResources().getDrawable(excercises.get(i).getImage());
            //excerciseFoto = (ImageView)findViewById(R.id.thumbnail);
            excerciseName = (TextView)view.findViewById(R.id.excercise_name);
            //excerciseFoto.setImageDrawable(drawable);

            excerciseName.setText(excercises.get(i).getName());
            return view;
        }
    }

}
