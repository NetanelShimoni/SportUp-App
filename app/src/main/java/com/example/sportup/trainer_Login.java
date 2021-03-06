package com.example.sportup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class trainer_Login extends AppCompatActivity {
TextView name , password;
    Button go;
    DatabaseReference trainerDbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trainer__login);
        name=findViewById(R.id.editTextTextEmailAddress);
        password=findViewById(R.id.editTextTextPassword);
        go=findViewById(R.id.button4);

        FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
        trainerDbRef = mDatabase.getInstance().getReference("Trainer");

        go.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                trainerDbRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        boolean flag=false;

                        for (DataSnapshot ds : snapshot.getChildren()){
                            String name1 =name.getText().toString();
                            String pass1 =password.getText().toString();
                            if(ds.child("name").getValue().equals(name1) && ds.child("password").getValue().equals(pass1)){
                                String phone=ds.child("phone_num").getValue().toString();
                                Tranier move = new Tranier(name1,pass1,phone);
                                flag=true;
                                Toast.makeText(trainer_Login.this,"OK!!!",Toast.LENGTH_LONG).show();


                                Intent j = new Intent(trainer_Login.this , trainer_Home.class);
                                j.putExtra("trainer", move);

                                startActivity(j);
                            }
                        }
                        if(!flag){
                            Toast.makeText(trainer_Login.this,"Sorry , try again :(",Toast.LENGTH_LONG).show();


                        }


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }
        });

    }
}