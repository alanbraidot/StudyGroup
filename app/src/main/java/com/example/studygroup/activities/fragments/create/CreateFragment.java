package com.example.studygroup.activities.fragments.create;

import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.icu.text.StringPrepParseException;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.studygroup.R;
import com.example.studygroup.domain.Universidad;

public class CreateFragment extends Fragment {

    private EditText etNombre;
    private Spinner spinnerUniversidad;
    private Spinner spinnerFacultad;
    private Spinner spinnerCarrera;
    private Spinner spinnerMateria;
    private EditText etLugarEncuentro;
    private Button btnLugarEncuentro;
    private EditText etIntegrantes;
    private Button btnIntegrantes;
    private EditText etTutor;
    private Button btnTutor;
    private Button btnCrear;

    private CreateViewModel mViewModel;
    private Context context;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mViewModel = ViewModelProviders.of(this).get(CreateViewModel.class);
        View root = inflater.inflate(R.layout.fragment_create, container, false);
        context = root.getContext();

        etNombre = root.findViewById(R.id.et_nombregrupo_crear);
        spinnerUniversidad = root.findViewById(R.id.spinner_universidad_crear_grupo);
        spinnerFacultad = root.findViewById(R.id.spinner_facultad_crear_grupo);
        spinnerCarrera = root.findViewById(R.id.spinner_carrera_crear_grupo);
        spinnerMateria = root.findViewById(R.id.spinner_materia_crear_grupo);
        etLugarEncuentro = root.findViewById(R.id.et_ubicacion_crear_grupo);
        etIntegrantes = root.findViewById(R.id.et_lista_integrantes_crear_grupo);
        etTutor = root.findViewById(R.id.et_tutor_crear_grupo);
        btnLugarEncuentro = root.findViewById(R.id.btn_seleccionar_ubicacion_crear);
        btnIntegrantes = root.findViewById(R.id.btn_agregar_integrantes_crear);
        btnTutor = root.findViewById(R.id.btn_agregar_tutor_crear);
        btnCrear = root.findViewById(R.id.btn_crearGrupo_crear);

        spinnerUniversidad.setAdapter(new ArrayAdapter<Universidad.UniversidadEnum>(context, R.layout.support_simple_spinner_dropdown_item, Universidad.UniversidadEnum.values()));
        //TODO Cargar Spinners restantes con las opciones filtradas.

        btnLugarEncuentro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO Pasar a MapActivity para seleccionar.
            }
        });

        btnIntegrantes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO Cargar MultiOption dialog con estudiantes de la misma carrera y facultad.
            }
        });

        btnTutor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO Cargar MultiOption dialog con tutores apto para la materia seleccionada.
            }
        });

        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO Verificar campos y crear grupo.
            }
        });

        return root;
    }

}
