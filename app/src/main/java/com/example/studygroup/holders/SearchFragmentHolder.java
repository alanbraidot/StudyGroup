package com.example.studygroup.holders;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.studygroup.R;

public class SearchFragmentHolder extends RecyclerView.ViewHolder {

    public TextView tvNombre;
    public TextView tvMateria;
    public TextView tvFacultad;
    public TextView tvTutor;
    public Button btnMasInfo;

    public SearchFragmentHolder(View base){
        super(base);
        tvNombre = (TextView) base.findViewById(R.id.tv_nombre_grupo_recycler);
        tvMateria = (TextView) base.findViewById(R.id.tv_materia_recycler);
        tvFacultad = (TextView) base.findViewById(R.id.tv_facultad_recycler);
        tvTutor = (TextView) base.findViewById(R.id.tv_tutor_recyler);
        btnMasInfo = (Button) base.findViewById(R.id.btn_mas_informacion_recycler);
    }
}
