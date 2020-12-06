package com.example.sportup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class trainer_Home extends AppCompatActivity {
    String s1[],s2[];
    int image []= {R.drawable.chest,R.drawable.six_pack,R.drawable.sulders,R.drawable.triceps1,R.drawable.kidmit};
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trainer__home);
        s1=getResources().getStringArray(R.array.recycaleview);
        s2=getResources().getStringArray(R.array.Discreption);
        recyclerView = findViewById(R.id.recycaleview);
        MyAdapter myAdapter = new MyAdapter (this,s1,s2,image);
    recyclerView.setAdapter(myAdapter);
    recyclerView.setLayoutManager(new LinearLayoutManager(this ));
    }
}