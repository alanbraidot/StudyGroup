package com.example.studygroup.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studygroup.R;
import com.example.studygroup.activities.GroupActivity;
import com.example.studygroup.controllers.GroupController;
import com.example.studygroup.domain.Group;
import com.example.studygroup.holders.MyGroupHolder;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;



public class MyGroupAdapter extends RecyclerView.Adapter<MyGroupHolder>  {
    private List<Group> mDataset = new ArrayList<>();
    private Context context;

    public MyGroupAdapter(List<Group> myDataset, Context context) {
        if(myDataset != null)
            mDataset = myDataset;
        this.context = context;
    }

    @NonNull
    @Override
    public MyGroupHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = (View) LayoutInflater.from(context).inflate(R.layout.fila_groups, parent, false);
        MyGroupHolder holder = new MyGroupHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyGroupHolder holder, int position) {
        final Group group = mDataset.get(position);
        holder.tvNombre.setText(group.getNombre());
        holder.tvMateria.setText(group.getSubject().toString());
        holder.tvFacultad.setText(group.getFaculty().toString());
        holder.tvTutor.setText(new StringBuffer(group.getTeacher().getApellido()+", "+ group.getTeacher().getNombre()));
        holder.btnMasInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(context, GroupActivity.class);
                Gson gson = new Gson();
                i.putExtra("Group",gson.toJson(group));
                ((Activity)context).startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

}
