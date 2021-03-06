package com.example.sportup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import de.hdodenhof.circleimageview.CircleImageView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.webkit.ValueCallback;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.io.FileNotFoundException;
import java.io.IOException;

public class register_Trainer extends AppCompatActivity {

    EditText etName,etPhone,etCity,etPassword,etid;
    Button btnJoin,uplod;
    CheckBox box;
    int SELECT_PHOTO =1;
    Uri uri ;
    ImageView imageView;
    DatabaseReference trainerDbRef;
    private CircleImageView ProfileImage;
    private static final int PICK_IMAGE = 1;
    Uri imageUri;
    boolean is_exit= false;
    FirebaseAuth firebaseAuto;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register__trainer);
        firebaseAuto =firebaseAuto.getInstance();

       // ProfileImage = (CircleImageView) findViewById(R.id.profile_image);
//        ProfileImage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent galery = new Intent();
//                galery.setType("image/*");
//                galery.setAction(Intent.ACTION_GET_CONTENT);
//                startActivityForResult(Intent.createChooser(galery,"Select CV (ONLY PICTURE)"),PICK_IMAGE);
//            }
//        });

        etName = findViewById(R.id.editTextTextPersonName);
        etPassword = findViewById(R.id.password_trainer);
        etCity = findViewById(R.id.city);
        etid= findViewById(R.id.id_trainer);
        etPhone = findViewById(R.id.phone_tranier);
        btnJoin = (Button) findViewById(R.id.button7);
        box = findViewById(R.id.checkBox2);
        FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
        trainerDbRef = mDatabase.getInstance().getReference("Trainer");

        btnJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etName.getText().toString();
                String password = etPassword.getText().toString();
                String phone = etPhone.getText().toString();
                String city = etCity.getText().toString();
                String id_trainer=etid.getText().toString();
                System.out.println("id trainer"+id_trainer);
                String id = trainerDbRef.push().getKey();
                if (box.isChecked()) {
                    if(idExists(id_trainer)==false) {
                        Tranier t = new Tranier(name, city, phone, password, id_trainer);

                        trainerDbRef.child(id).setValue(t);
                        Toast.makeText(register_Trainer.this, "Data inserted!", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(register_Trainer.this, success_join.class);
                        startActivity(i);
                    }else{
                        Toast.makeText(register_Trainer.this, "UserName is exist",
                                Toast.LENGTH_LONG).show();
                    }


                } else {
                    Toast.makeText(register_Trainer.this, "checking box please!",
                            Toast.LENGTH_LONG).show();
                    }

            }});
    }



    private boolean idExists(String id) {
        is_exit=false;
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("Trainer");
        databaseReference.orderByChild("id").equalTo(id).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()) {
                    for (DataSnapshot childSnapshot : dataSnapshot.getChildren()) {
                        if (childSnapshot.child("id").getValue().equals(id)) {
                            System.out.println("valye is: "+childSnapshot.child("id").getValue());
                            System.out.println("id is:" + childSnapshot.child("id").getValue().equals(id));
                            is_exit = true;

                        } else {
                            is_exit = false;
                        }
                        // no such user exists
                    }
                }}

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) { // ToDo: Do something for errors too

                }
            });
        System.out.println("if exist:"+is_exit);
        return is_exit;
    }


    public void success_join(View v){
        Intent i = new Intent(this,success_join.class);
        startActivity(i);
    }



    }
//        @Override
//        protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//            super.onActivityResult(requestCode, resultCode, data);
//            if(requestCode== PICK_IMAGE && data.getData()!=null && requestCode== RESULT_OK && data!= null)
//            {
//                imageUri =data.getData();
//                try {
//                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),imageUri);
//                    ProfileImage.setImageBitmap(bitmap);
//                    System.out.println("yes in in!!");
//                }  catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }







