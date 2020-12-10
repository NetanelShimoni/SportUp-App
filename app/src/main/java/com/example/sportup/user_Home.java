package com.example.sportup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class user_Home extends AppCompatActivity {
TextView welcome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__home);
        Intent intent = getIntent();
        String user_name= intent.getStringExtra("name");
        welcome= findViewById(R.id.welcome_user);
        welcome.setText("Welcome "+user_name+"\n Chose option please");
    }
    public void mainActivity(View v){

        Intent i = new Intent(user_Home.this, MainActivity.class);
        startActivity(i);
    }
    public void home_workout(View v){

        Intent i = new Intent(user_Home.this, home_Workout.class);
        startActivity(i);
    }
}