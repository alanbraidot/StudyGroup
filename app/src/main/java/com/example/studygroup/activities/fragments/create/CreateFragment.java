package com.example.studygroup.activities.fragments.create;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.studygroup.R;
import com.example.studygroup.activities.GroupMapsActivity;
import com.example.studygroup.controllers.GeneralController;
import com.example.studygroup.controllers.PersonController;
import com.example.studygroup.domain.Career;
import com.example.studygroup.domain.Faculty;
import com.example.studygroup.domain.Person;
import com.example.studygroup.domain.Subject;
import com.example.studygroup.domain.University;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

import static android.app.Activity.RESULT_OK;

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

    private LatLng ubicacion=null;
    private List<Person> integrantes=new ArrayList<>();
    private Person teacher =null;

    private CreateViewModel mViewModel;
    private Context context;

    private final int REQUEST_SELECCIONAR_UBICACION=1;
    private final int REQUEST_SELECCIONAR_INTEGRANTES=2;
    private final int REQUEST_SELECCIONAR_TUTOR=3;

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
        etLugarEncuentro.setEnabled(false);
        etIntegrantes = root.findViewById(R.id.et_lista_integrantes_crear_grupo);
        etTutor = root.findViewById(R.id.et_tutor_crear_grupo);
        btnLugarEncuentro = root.findViewById(R.id.btn_seleccionar_ubicacion_crear);
        btnIntegrantes = root.findViewById(R.id.btn_agregar_integrantes_crear);
        btnTutor = root.findViewById(R.id.btn_agregar_tutor_crear);
        btnCrear = root.findViewById(R.id.btn_crearGrupo_crear);
        spinnerUniversidad.setAdapter(new ArrayAdapter<University.UniversityEnum>(context, R.layout.support_simple_spinner_dropdown_item, University.UniversityEnum.values()));
        btnLugarEncuentro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, GroupMapsActivity.class);
                startActivityForResult(i,REQUEST_SELECCIONAR_UBICACION);
            }
        });

        btnIntegrantes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO Cargar MultiOption dialog con estudiantes de la misma carrera y facultad.
                ArrayList<Person> personas= new ArrayList<>();
                personas= PersonController.getInstance().findMembers((Career.CareerEnum)spinnerCarrera.getSelectedItem(),(Faculty.FacultyEnum)spinnerFacultad.getSelectedItem(),context);

            }
        });

        btnTutor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO Cargar SingleOption dialog con tutores apto para la materia seleccionada.
            }
        });

        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO Verificar campos y crear grupo.
            }
        });

        spinnerUniversidad.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                spinnerFacultad.setAdapter(new ArrayAdapter<Faculty.FacultyEnum>(context, R.layout.support_simple_spinner_dropdown_item, GeneralController.getInstance().getUniversity((University.UniversityEnum)spinnerUniversidad.getSelectedItem()).getFacultyEnumList()));
                spinnerFacultad.setEnabled(true);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        spinnerFacultad.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                spinnerCarrera.setAdapter(new ArrayAdapter<Career.CareerEnum>(context, R.layout.support_simple_spinner_dropdown_item, GeneralController.getInstance().getFaculty((Faculty.FacultyEnum)spinnerFacultad.getSelectedItem()).getCareerEnumList()));
                spinnerCarrera.setEnabled(true);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        spinnerCarrera.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                spinnerMateria.setAdapter(new ArrayAdapter<Subject.SubjectEnum>(context, R.layout.support_simple_spinner_dropdown_item, GeneralController.getInstance().getCareer((Career.CareerEnum)spinnerCarrera.getSelectedItem()).getSubjectEnumList()));
                spinnerMateria.setEnabled(true);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        return root;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUEST_SELECCIONAR_UBICACION && resultCode==RESULT_OK){
            ubicacion=new LatLng(data.getExtras().getDouble("Lat"), data.getExtras().getDouble("Lng"));
            etLugarEncuentro.setText("Lat: "+ubicacion.latitude+", Lng: "+ubicacion.longitude);
        }
    }
}
