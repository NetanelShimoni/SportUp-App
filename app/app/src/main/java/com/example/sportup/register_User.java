package com.example.sportup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class register_User extends AppCompatActivity {
    EditText etName, etPhone, etCity, etPassword;
    Spinner etWeight, etHigh;
    Switch aSwitch;
    Button join;
    DatabaseReference trainerDbRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register__user);
        etName = findViewById(R.id.user_name);
        etPassword = findViewById(R.id.user_password);
        etCity = findViewById(R.id.user_city);
        etPhone = findViewById(R.id.user_phone);
        join = (Button) findViewById(R.id.user_join);
        aSwitch = findViewById(R.id.chak_is_healty);
        etHigh = findViewById(R.id.spinner_trainer_muselse);
        etWeight = findViewById(R.id.spinner_user_weight);
        FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
        trainerDbRef = mDatabase.getInstance().getReference("User");
        join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = etName.getText().toString();
                String password = etPassword.getText().toString();
                String phone = etPhone.getText().toString();
                String city = etCity.getText().toString();
                String high = etHigh.getSelectedItem().toString();
                String weight = etWeight.getSelectedItem().toString();

                String id = trainerDbRef.push().getKey();
                if (aSwitch.isChecked()) {
                    User new_user = new User(name, phone, city, high, password, weight);
                    trainerDbRef.child(id).setValue(new_user);
                    Toast.makeText(register_User.this, "Data inserted!", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent( register_User.this,success_join.class);
                    startActivity(i);
                } else {
                    Toast.makeText(register_User.this, "checking Switch please!",
                            Toast.LENGTH_LONG).show();
                }


            }
        });
    }


    }
