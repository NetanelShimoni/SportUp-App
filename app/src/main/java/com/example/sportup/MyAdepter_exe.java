package com.example.sportup;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdepter_exe extends RecyclerView.Adapter<MyAdepter_exe.ViewHolder> {
  //  Exersice[] Myexe;
    Context context;
    List<Exersice> Myexe;

    public MyAdepter_exe(List Myexe,home_Workout activity) {
        this.Myexe=new ArrayList<>();
        this.Myexe = Myexe;
        System.out.println("siitttzz!!!"+Myexe);
        this.context = activity;
    }

    @NonNull
    @Override
    public MyAdepter_exe.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.exersice_list,parent,false);
        MyAdepter_exe.ViewHolder viewHolder = new MyAdepter_exe.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Exersice MyexeDataList = Myexe.get(position);
        holder.textViewName.setText(MyexeDataList.trainer_name);
        holder.textViewName1.setText(MyexeDataList.trainer_phone);
        holder.textViewName2.setText(MyexeDataList.name);
        holder.textViewName3.setText(MyexeDataList.description);
        holder.videoView.setVideoURI(Uri.parse("android.resource://" + MyexeDataList.link + "/"));
        holder.videoView.start();

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, MyexeDataList.getName(), Toast.LENGTH_SHORT).show();
                Intent i = new Intent(context, trainer_add_Exersice.class);
               // i.putExtra("trainer", t);
               // i.putExtra("id_m",position);
                context.startActivity(i);

            }
        });
    }



    @Override
    public int getItemCount() {
        System.out.println("sizee!!"+Myexe.size());
        return Myexe.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView movieImage;
        TextView textViewName;
        TextView textViewName1;
        TextView textViewName2;
        TextView textViewName3;
        VideoView videoView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //movieImage = itemView.findViewById(R.id.imageview);
            textViewName = itemView.findViewById(R.id.name_trainer);
            textViewName1 = itemView.findViewById(R.id.phone_trainer);
            textViewName2 = itemView.findViewById(R.id.exe_name);
            textViewName3 = itemView.findViewById(R.id.text_discription);
            videoView = itemView.findViewById(R.id.videoView);

        }
    }

}
