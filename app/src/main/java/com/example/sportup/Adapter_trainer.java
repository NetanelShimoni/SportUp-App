package com.example.sportup;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter_trainer extends RecyclerView.Adapter<Adapter_trainer.ViewHolder> {
    Context context;
    List<Tranier> MyTrainers;
    User user;

    public Adapter_trainer(List MyTrainers,Find_trainer activity,User name) {
        this.MyTrainers=new ArrayList<>();
        this.MyTrainers = MyTrainers;
        this.context = activity;
        this.user=name;
    }

    @NonNull
    @Override
    public Adapter_trainer.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.trianer_list,parent,false);
        Adapter_trainer.ViewHolder viewHolder = new Adapter_trainer.ViewHolder(view);
        return viewHolder;
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Tranier MyexeDataList =MyTrainers.get(position);
      //  holder.textViewName.setTextColor(R.color.green_dark );
        holder.textViewName.setText("Trainer Name: "+MyexeDataList.getName());
      //  holder.textViewName0.setTextColor(R.color.green_dark );
        holder.textViewName0.setText("Trainer Phone: "+MyexeDataList.getPhone_num());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




            }
        });
    }



    @Override
    public int getItemCount() {
        return MyTrainers.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textViewName;
        TextView textViewName0;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.name_trainer_for_found);

            textViewName0 = itemView.findViewById(R.id.phone_trainer_for_found);





        }
    }

}
