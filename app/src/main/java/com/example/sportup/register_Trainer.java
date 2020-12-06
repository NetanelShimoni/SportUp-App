package com.example.sportup;

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

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.FileNotFoundException;
import java.io.IOException;

public class register_Trainer extends AppCompatActivity {

    EditText etName,etPhone,etCity,etPassword;
    Button btnJoin,uplod;
    CheckBox box;
    int SELECT_PHOTO =1;
    Uri uri ;
    ImageView imageView;
    DatabaseReference trainerDbRef;
    private CircleImageView ProfileImage;
    private static final int PICK_IMAGE = 1;
    Uri imageUri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register__trainer);
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

                String id = trainerDbRef.push().getKey();
                if (box.isChecked()){
                    Tranier t = new Tranier(name, city, phone,password);
                    trainerDbRef.child(id).setValue(t);
                    Toast.makeText(register_Trainer.this, "Data inserted!", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent( register_Trainer.this,success_join.class);
                    startActivity(i);
                }else {
                    Toast.makeText(register_Trainer.this, "checking box please!",
                            Toast.LENGTH_LONG).show();
                }
            }});
    }
    public void success_join(View v){
        Intent i = new Intent(this,success_join.class);
        startActivity(i);
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

}





