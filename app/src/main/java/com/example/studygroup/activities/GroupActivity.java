package com.example.studygroup.activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.studygroup.R;
import com.example.studygroup.controllers.GroupController;
import com.example.studygroup.domain.Group;
import com.example.studygroup.domain.Person;
import com.example.studygroup.utils.Converters;
import com.google.android.gms.maps.MapView;
import com.google.gson.reflect.TypeToken;

public class GroupActivity extends AppCompatActivity {

    private TextView textViewName;
    private TextView textViewUniversity;
    private TextView textViewFaculty;
    private TextView textViewCareer;
    private TextView textViewSubject;
    private ListView listViewStudents;
    private TextView textViewTeacher;
    private MapView mapViewLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);
        ActionBar actionBar= getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("");

        textViewName = findViewById(R.id.tv_nombregrupo_group_activity);
        textViewUniversity = findViewById(R.id.tv_universidad_group_activity);
        textViewFaculty = findViewById(R.id.tv_facultad_group_activity);
        textViewCareer = findViewById(R.id.tv_carrera_group_activity);
        textViewSubject = findViewById(R.id.tv_materia_group_activity);
        listViewStudents = findViewById(R.id.lv_integrantes_group_activity);
        textViewTeacher = findViewById(R.id.tv_tutor_group_activity);
        mapViewLocation = findViewById(R.id.mapView_ubicacion_group_activity);

        Group group = Converters.stringToGroup(getIntent().getExtras().getString("Group"));

        textViewName.setText(group.getNombre());
        textViewUniversity.setText(group.getUniversity().toString());
        textViewFaculty.setText(group.getFaculty().toString());
        textViewCareer.setText(group.getCareer().toString());
        Object[] students = group.getIntegrantes().toArray();
        String[] studentsNames = new String[group.getIntegrantes().size()];
        for(int i=0; i<students.length;i++){
            studentsNames[i] = (((Person)students[i]).getNombre() + " " + ((Person)students[i]).getApellido());
        }
        listViewStudents.setAdapter(new ArrayAdapter<String>(this, R.layout.simple_list_item, R.id.tv_simple_list_item, studentsNames));
        textViewTeacher.setText(("Profesor: " + group.getTeacher().getNombre() + " " + group.getTeacher().getApellido()));
        //TODO Configurar map fragment para que muestre la ubicacion del grupo.

    }
}
