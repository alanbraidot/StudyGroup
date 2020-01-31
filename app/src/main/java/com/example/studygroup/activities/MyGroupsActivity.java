package com.example.studygroup.activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.studygroup.R;

public class MyGroupsActivity extends AppCompatActivity {

    ImageView fotoPerfil;
    TextView nombre;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_groups);
        ActionBar actionBar= getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        fotoPerfil = (ImageView) findViewById(R.id.image_foto_perfil_grupos);
        nombre = (TextView) findViewById(R.id.tv_nombre_perfil_grupos);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_my_groups);


    }
}
