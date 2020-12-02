package com.example.sportup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void trainer_Login(View v){
        Intent intent = new Intent(this,trainer_Login.class);
        startActivity(intent);

    }
    public void register_Screen(View v){
        Intent intent = new Intent(this,register_Screen.class);
        startActivity(intent);

    }
    public void user_Login(View v){
        Intent intent = new Intent(this,user_Login.class);
        startActivity(intent);

    }

}