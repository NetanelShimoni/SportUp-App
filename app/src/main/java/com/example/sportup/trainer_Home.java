package com.example.sportup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class trainer_Home extends AppCompatActivity {
    String s1[],s2[];
    int image []= {R.drawable.chest,R.drawable.six_pack,R.drawable.sulders,R.drawable.triceps1,R.drawable.kidmit};
    RecyclerView recyclerView;
    TextView welcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trainer__home);
        Intent intent = getIntent();
        welcome = findViewById(R.id.textView7);
        Tranier mover = (Tranier)intent.getSerializableExtra("trainer");
        welcome.setText("Welcome "+mover.getName()+"\nplease ADD EXERCISE");

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MyMuscles[] MyMuscles = new MyMuscles[]{
                new MyMuscles("Six-pack",R.drawable.six_pack),
                new MyMuscles("Chest",R.drawable.chest),
                new MyMuscles("Sulders",R.drawable.sulders),
                new MyMuscles("Legs",R.drawable.legs),
                new MyMuscles("Triceps",R.drawable.triceps1),
                new MyMuscles("Biceps",R.drawable.kidmit),
        };

        MyAdapter myMusclesAdapter = new MyAdapter(MyMuscles,trainer_Home.this,mover);
        recyclerView.setAdapter(myMusclesAdapter);

    }
}