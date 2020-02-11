package com.example.studygroup.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studygroup.R;
import com.example.studygroup.domain.Group;
import com.example.studygroup.holders.SearchFragmentHolder;

import java.util.List;


public class SearchFragmentAdapter extends RecyclerView.Adapter<SearchFragmentHolder> {

    private List<Group> mDataset;

    public SearchFragmentAdapter(List<Group> myDataset) {
        mDataset = myDataset;
    }

    @NonNull
    @Override
    public SearchFragmentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = (View) LayoutInflater.from(parent.getContext()).inflate(R.layout.fila_groups, parent, false);
        SearchFragmentHolder holder = new SearchFragmentHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull SearchFragmentHolder holder, int position) {
        Group group = mDataset.get(position);
        holder.tvNombre.setText(group.getNombre());
        holder.tvMateria.setText(group.getSubject().getMateriaEnum().toString());
        holder.tvFacultad.setText(group.getFaculty().getFacultadEnum().toString());
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
