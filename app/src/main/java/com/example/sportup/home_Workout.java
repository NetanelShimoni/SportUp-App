package com.example.sportup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;

import java.security.spec.ECField;
import java.util.ArrayList;
import java.util.List;

public class home_Workout extends AppCompatActivity {
DatabaseReference exeref;
    List<Exersice> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home__workout);
        this.list= new ArrayList<>();



        FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
        exeref = mDatabase.getInstance().getReference("Exersice");
        exeref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot ds : snapshot.getChildren()) {
                    Object object = ds.getValue(Object.class);
                    String json = new Gson().toJson(object);
                    Exersice e= new Gson().fromJson(json, Exersice.class);
                    list.add(e);
                    System.out.println(e.link);
                }
                System.out.println("size in homw eorkout"+list.size());



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        Intent intent = getIntent();
        Tranier mover = (Tranier)intent.getSerializableExtra("trainer");
        System.out.println("size after!!"+list.size());
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        Exersice[] Myexe = new Exersice[]{
//                new Exersice(),
//                new Exersice("Chest",R.drawable.chest),
//                new Exersice("Sulders",R.drawable.sulders),
//                new Exersice("Legs",R.drawable.legs),
//                new Exersice("Triceps",R.drawable.triceps1),
//                new Exersice("Biceps",R.drawable.kidmit),
//        };

        MyAdepter_exe MyexeAdapter = new MyAdepter_exe(this.list,home_Workout.this);
        recyclerView.setAdapter(MyexeAdapter);

    }

    }
