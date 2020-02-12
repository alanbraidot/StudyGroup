package com.example.studygroup.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studygroup.R;
import com.example.studygroup.domain.Group;
import com.example.studygroup.holders.MyGroupHolder;

import java.util.List;

public class MyGroupAdapter extends RecyclerView.Adapter<MyGroupHolder>  {
    private List<Group> mDataset;

    public MyGroupAdapter(List<Group> myDataset) {
        mDataset = myDataset;
    }

    @NonNull
    @Override
    public MyGroupHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = (View) LayoutInflater.from(parent.getContext()).inflate(R.layout.fila_groups, parent, false);
        MyGroupHolder holder = new MyGroupHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyGroupHolder holder, int position) {
        Group group = mDataset.get(position);
        holder.tvNombre.setText(group.getNombre());
        //TODO Cargar informacion en TextViews
        /*holder.tvMateria.setText(group.getSubject().getMateriaEnum().toString());
        holder.tvFacultad.setText(group.getFaculty().getFacultadEnum().toString());*/
        holder.tvTutor.setText(new StringBuffer(group.getTeacher().getApellido()+", "+ group.getTeacher().getNombre()));
        holder.btnMasInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO Mostrar pantalla informativa de group.
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

}
