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
import com.example.studygroup.domain.Group;
import com.example.studygroup.holders.SearchFragmentHolder;

import java.util.ArrayList;
import java.util.List;


public class SearchFragmentAdapter extends RecyclerView.Adapter<SearchFragmentHolder> {

    private List<Group> mDataset = new ArrayList<>();
    private Context context;

    public SearchFragmentAdapter(List<Group> myDataset, Context context) {
        mDataset = myDataset;
        this.context = context;
    }

    @NonNull
    @Override
    public SearchFragmentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = (View) LayoutInflater.from(parent.getContext()).inflate(R.layout.fila_groups, parent, false);
        SearchFragmentHolder holder = new SearchFragmentHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final SearchFragmentHolder holder, int position) {
        final Group group = mDataset.get(position);
        holder.tvNombre.setText(group.getNombre());
        holder.tvMateria.setText(group.getSubject().toString());
        holder.tvFacultad.setText(group.getFaculty().toString());
        holder.tvTutor.setText(new StringBuffer(group.getTeacher().getApellido()+", "+ group.getTeacher().getNombre()));
        holder.btnMasInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, GroupActivity.class);
                i.putExtra("Id_group", group.getId());
                ((Activity)context).startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

}
