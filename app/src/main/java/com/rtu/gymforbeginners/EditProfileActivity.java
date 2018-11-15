package com.rtu.gymforbeginners;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class EditProfileActivity extends AppCompatActivity {

    EditText etGender;
    EditText etBirthday;
    EditText etHeight;
    EditText etWeight;
    EditText etEmail;
    SharedPreferences pref;
    RadioGroup radioGroup;
    RadioButton rbGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setDisplayShowHomeEnabled(false);

        }

        radioGroup = findViewById(R.id.radiogroup);
        pref = getSharedPreferences("Registration", 0);
        etBirthday = findViewById(R.id.etBirthday);
        etHeight = findViewById(R.id.etHeight);
        etWeight = findViewById(R.id.etWeight);
        etEmail = findViewById(R.id.etEmail);
        etBirthday.setText(pref.getString("Birthday", "15/02/1996"));
        etEmail.setText(pref.getString("Email", "hotmail"));;
        etHeight.setText(pref.getString("Height", "1.71"));
        etWeight.setText(pref.getString("Weight", "80"));


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add_workout,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }
        if (item.getItemId() == R.id.save_workout)
        {   SharedPreferences.Editor editor = pref.edit();
            editor.putString("Email",etEmail.getText().toString());
            editor.putString("Birthday",etBirthday.getText().toString());
            editor.putString("Weight",etWeight.getText().toString());
            editor.putString("Height",etHeight.getText().toString());

            int genderId = radioGroup.getCheckedRadioButtonId();
            rbGender = findViewById(genderId);
            editor.putString("Gender",rbGender.getText().toString());
            editor.commit();
            Intent i = new Intent(EditProfileActivity.this,ProfileActivity.class);
            startActivity(i);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

}
