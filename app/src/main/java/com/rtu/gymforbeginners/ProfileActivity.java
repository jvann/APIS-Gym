package com.rtu.gymforbeginners;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.rtu.gymforbeginners.classes.Excercise;


public class ProfileActivity extends AppCompatActivity {
    TextView tvGender;
    TextView tvEmail;
    TextView tvHeight;
    TextView tvBirthday;
    TextView tvWeight;
    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_ex);
        setSupportActionBar(toolbar);

        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ProfileActivity.this,EditProfileActivity.class);
                startActivityForResult(i,3);
            }
        });

        pref = getSharedPreferences("Registration", 0);
        tvGender = findViewById(R.id.profGender);
        tvEmail = findViewById(R.id.profEmail);
        tvHeight = findViewById(R.id.profHeight);
        tvWeight = findViewById(R.id.profWeight);
        tvBirthday = findViewById(R.id.profDate);

        tvGender.setText(pref.getString("Gender", "Male"));
        tvEmail.setText(pref.getString("Email", "hotmail"));
        tvBirthday.setText(pref.getString("Birthday", "15/02/1996"));
        tvHeight.setText(pref.getString("Height", "1.71 m"));
        tvWeight.setText(pref.getString("Weight", "80 kg"));
        getSupportActionBar().setTitle(pref.getString("Name", "Username"));
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
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 3 && resultCode == Activity.RESULT_OK)
        {
            String email = pref.getString("Email", "hotmail");
            tvGender.setText(pref.getString("Gender", "Male"));
            tvEmail.setText(pref.getString("Email", "hotmail"));
            tvBirthday.setText(pref.getString("Birthday", "15/02/1996"));
            tvHeight.setText(pref.getString("Height", "1.71 m"));
            tvWeight.setText(pref.getString("Weight", "80 kg"));
            tvGender.setText(pref.getString("Gender",""));
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
