package com.example.sportup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;

public class MainActivity extends AppCompatActivity {
int SELECT_PHOTO =1;
Uri uri ;
ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void trainer_Login(View v,int x){
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