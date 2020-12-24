package com.example.sportup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class edit_user_profile extends AppCompatActivity {
    TextView welcome;
    Intent intent;
    User user;
    EditText etweight, etpassword, etcity;
    Button bJoin;
    DatabaseReference userDbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit__user_profile);
        this.intent = getIntent();
        user = (User) this.intent.getSerializableExtra("name");
        welcome = findViewById(R.id.welcome_profile_user);
        welcome.setText("Hello " + user.name + "\n Update details");
        bJoin = findViewById(R.id.change_details_btn);
        FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
        userDbRef = mDatabase.getInstance().getReference("User");
//        String password = etpassword.getText().toString();
//        String weight = etpassword.getText().toString();
//        String city = etcity.getText().toString();

        bJoin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                userDbRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (isPasswordchanged() || isweightchanged() || iscitychanged()) {
                            isPasswordchanged();
                            isweightchanged();
                            iscitychanged();
                            Toast.makeText(edit_user_profile.this, "Data has been updated", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(edit_user_profile.this, "You did not type anything", Toast.LENGTH_LONG).show();
                        }
//                        boolean flag = false;
//                        for (DataSnapshot ds : snapshot.getChildren()) {
//                            if (ds.child("name").getValue().equals(name) && ds.child("password").getValue().equals(password)) {
//                                Object object = ds.getValue(Object.class);
//
//                                String json = new Gson().toJson(object);
//                                User user = new Gson().fromJson(json, User.class);
//
//                                flag = true;
//                                Toast.makeText(user_Login.this, "OK!!!", Toast.LENGTH_LONG).show();
//                                Intent i = new Intent(user_Login.this, user_Home.class);
//                                i.putExtra("name", user);
//                                startActivity(i);
//                            }
//                        }
//                        if (!flag) {
//                            Toast.makeText(user_Login.this, "Sorry , try again :(", Toast.LENGTH_LONG).show();
//
//                        }

                    }

//                    public void update(View v) {
//                        if (isPasswordchanged() || isweightchanged() || iscitychanged()) {
//                          Toast.makeText(edit_Profile.this, "Data has been updated", Toast.LENGTH_LONG).show();
//                        } else {
//                            Toast.makeText(edit_Profile.this, "You did not type anything", Toast.LENGTH_LONG).show();
//                        }
//                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                    private boolean isPasswordchanged() {
                        etpassword = findViewById(R.id.change_password);
                        if(etpassword.getText().toString().trim().length() != 0) {
                            String password=etpassword.getText().toString();
                            userDbRef.child(user.getName()).child("password").setValue(password);
                            user.setPassword(password);
//                            user.password = password;
                            return true;
                        } else
                            return false;
                    }

                    private boolean isweightchanged() {
                        etweight = findViewById(R.id.new_weight);
                        if(etweight.getText().toString().trim().length() != 0) {
                            String weight=etweight.getText().toString();
                            userDbRef.child(user.name).child("weight").setValue(weight);
//                            user.weight = weight;
                            user.setWeight(weight);
                            return true;
                        } else
                            return false;
                    }

                    private boolean iscitychanged() {
                        etcity = findViewById(R.id.new_weight);
                        if(etcity.getText().toString().trim().length() != 0) {
                            String city=etcity.getText().toString();
                            userDbRef.child(user.name).child("city").setValue(city);
                            //                           user.city = city;
                            user.setCity(city);
                            return true;
                        } else
                            return false;
                    }
                });
            }
        });


    }

}