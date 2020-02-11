package com.example.studygroup.activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.studygroup.R;
import com.example.studygroup.adapters.SearchFragmentAdapter;

public class MyGroupsActivity extends AppCompatActivity {

    private ImageView fotoPerfil;
    private TextView tvNombre;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_groups);
        ActionBar actionBar= getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        fotoPerfil = (ImageView) findViewById(R.id.image_foto_perfil_grupos);
        tvNombre = (TextView) findViewById(R.id.tv_nombre_perfil_grupos);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_my_groups);

        fotoPerfil.setImageBitmap(MainActivity.usuarioActivo.getFoto());
        tvNombre.setText(MainActivity.usuarioActivo.getNombre().concat(MainActivity.usuarioActivo.getApellido()));

        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new SearchFragmentAdapter(MainActivity.usuarioActivo.getGroups());
        mRecyclerView.setAdapter(mAdapter);
    }
}
