package com.example.sportup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter  extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context ct ;
    String s1[],s2[];
    int image[];

    public MyAdapter (Context ct , String s1[],String s2[], int image[]){
        this.ct=ct;
        this.s1=s1;
        this.s2=s2;
        this.image=image;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(ct);
        View view= inflater.inflate(R.layout.activity_trainer__home,parent,false);
        return new  MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
    holder.t1.setText(s1[position]);
    holder.t2.setText(s2[position]);
    holder.imageView.setImageResource(image[position]);
    }

    @Override
    public int getItemCount() {
        return s1.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
    TextView t1,t2;
    ImageView imageView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            t1=itemView.findViewById(R.id.masuels);
            t2=itemView.findViewById(R.id.descrip);
            imageView=itemView.findViewById(R.id.image_masuels);
        }
    }
}
