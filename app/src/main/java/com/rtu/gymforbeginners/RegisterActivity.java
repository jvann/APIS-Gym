package com.rtu.gymforbeginners;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final EditText etUserName = findViewById(R.id.etUsername);
        final EditText etPassword = findViewById(R.id.etPassword);
        Button btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences preferences = getSharedPreferences("Registration", 0);
                String newUser = etUserName.getText().toString();
                String newPassword = etPassword.getText().toString();

                if(newUser.length()>0 || newPassword.length()>0)
                {
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("Name", newUser);
                    editor.putString("Password",newPassword);
                    editor.putString("Email",null);
                    editor.putString("Birthday",null);
                    editor.putString("Weight",null);
                    editor.putString("Height",null);
                    editor.putString("Gender",null);

                    editor.commit();
                    Intent loginScreen = new Intent(RegisterActivity.this,LoginActivity.class);
                    startActivity(loginScreen);
                    finish();
                }
                else
                {

                    Toast.makeText(RegisterActivity.this, "Inavlid username or password",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}
