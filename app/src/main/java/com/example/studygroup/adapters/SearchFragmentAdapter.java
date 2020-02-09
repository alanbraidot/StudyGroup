package com.example.studygroup.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studygroup.R;
import com.example.studygroup.domain.Grupo;
import com.example.studygroup.holders.SearchFragmentHolder;

import java.util.List;


public class SearchFragmentAdapter extends RecyclerView.Adapter<SearchFragmentHolder> {

    private List<Grupo> mDataset;

    public SearchFragmentAdapter(List<Grupo> myDataset) {
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
        Grupo grupo = mDataset.get(position);
        holder.tvNombre.setText(grupo.getNombre());
        holder.tvMateria.setText(grupo.getMateria().getMateriaEnum().toString());
        holder.tvFacultad.setText(grupo.getFacultad().getFacultadEnum().toString());
        holder.tvTutor.setText(new StringBuffer(grupo.getTutor().getApellido()+", "+grupo.getTutor().getNombre()));
        holder.btnMasInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO Mostrar pantalla informativa de grupo.
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

}
