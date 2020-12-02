package com.example.sportup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class register_Trainer extends AppCompatActivity {

    EditText etName,etPhone,etCity;
    EditText etRollno;
    Spinner spinnerCourses;
    Button btnJoin;
    DatabaseReference trainerDbRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register__trainer);
        java.text.DateFormat dateFormat = android.text.format.DateFormat.getDateFormat(getApplicationContext());

//
//        setContentView(R.layout.activity_register__trainer);
//
        etName = findViewById(R.id.editTextTextPersonName);
        etCity = findViewById(R.id.editTextTextPostalAddress3);
        etPhone = findViewById(R.id.editTextPhone3);

        trainerDbRef = FirebaseDatabase.getInstance().getReference("Trainer");

        btnJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.err.println("raffat!!!!");

                String name = etName.getText().toString();
                String city = etCity.getText().toString();
                String phone = etPhone.getText().toString();

                String id = trainerDbRef.push().getKey();

                Tranier t = new Tranier(name, city, phone);
                assert id != null;
                trainerDbRef.child(id).setValue(t);
                Toast.makeText(register_Trainer.this, "Data inserted!", Toast.LENGTH_SHORT).show();
            }
        });
    }

//    private void insertStudentData(){
//        try {
//
//        }catch (Exception e){
//            System.out.println("sddsdsd");
//        }
       }



























//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.annotation.SuppressLint;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.Toast;
//
//import com.google.android.material.textfield.TextInputLayout;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//
//import java.sql.DatabaseMetaData;
//import java.util.Calendar;
//
//public class register_Trainer extends AppCompatActivity {
//    FirebaseDatabase rootNode;
//    DatabaseReference reference;
//EditText regName , regPhonenum, regPassword,regCity;
//Button join;
//    //@SuppressLint("WrongViewCast")
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_register__trainer);
//
//        regName = findViewById(R.id.editTextTextPersonName2);
//        regCity = findViewById(R.id.editTextTextPostalAddress);
//        regPhonenum = findViewById(R.id.editTextPhone);
//        reference = FirebaseDatabase.getInstance().getReference().child("Trainer");
//
//        join.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //reference = rootNode.getReference("Trainer");
//                reference.setValue("hi my name is raafat naim li gam mod");
//            }
//        });
//
//    }
//    private void insereTranier(){
//        String name =regName.getText().toString();
//        String City =regCity.getText().toString();
//        String Pone =regPhonenum.getText().toString();
//        Tranier t = new Tranier(name,City,Pone);
//        reference.push().setValue(t);
//        Toast.makeText(register_Trainer.this, "Data insert",Toast.LENGTH_SHORT).show();
//    }}
//    //DatabaseReference rf = database.getReference();
//
//
