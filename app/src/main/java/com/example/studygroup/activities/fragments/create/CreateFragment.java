package com.example.studygroup.activities.fragments.create;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
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
import android.widget.Toast;

import com.example.studygroup.R;
import com.example.studygroup.activities.CreateGroupMapsActivity;
import com.example.studygroup.activities.MainActivity;
import com.example.studygroup.controllers.GeneralController;
import com.example.studygroup.controllers.GroupController;
import com.example.studygroup.controllers.PersonController;
import com.example.studygroup.domain.Career;
import com.example.studygroup.domain.Faculty;
import com.example.studygroup.domain.Group;
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
    private Spinner spinnerTutor;
    private Button btnCrear;

    private LatLng ubicacion=null;
    private List<Person> studentsSelected = new ArrayList<>();
    private Person teacher=null;
    private University.UniversityEnum university = null;
    private Faculty.FacultyEnum faculty= null;
    private Career.CareerEnum career = null;
    private Subject.SubjectEnum subject = null;

    private CreateViewModel mViewModel;
    private Context context;

    private ArrayList<Integer> mUserStudents = new ArrayList<>();
    private boolean[] checkedStudents;
    private Person[] students;
    private String[] studentsList;

    private final int REQUEST_SELECCIONAR_UBICACION=1;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             final ViewGroup container, Bundle savedInstanceState) {
        mViewModel = ViewModelProviders.of(this).get(CreateViewModel.class);
        View root = inflater.inflate(R.layout.fragment_create, container, false);
        context = root.getContext();

        etNombre = root.findViewById(R.id.tv_nombregrupo_crear);
        spinnerUniversidad = root.findViewById(R.id.spinner_universidad_crear_grupo);
        spinnerFacultad = root.findViewById(R.id.spinner_facultad_crear_grupo);
        spinnerCarrera = root.findViewById(R.id.spinner_carrera_crear_grupo);
        spinnerMateria = root.findViewById(R.id.spinner_materia_crear_grupo);
        etLugarEncuentro = root.findViewById(R.id.et_ubicacion_crear_grupo);
        etLugarEncuentro.setEnabled(false);
        etIntegrantes = root.findViewById(R.id.et_lista_integrantes_crear_grupo);
        btnLugarEncuentro = root.findViewById(R.id.btn_seleccionar_ubicacion_crear);
        btnIntegrantes = root.findViewById(R.id.btn_agregar_integrantes_crear);
        spinnerTutor = root.findViewById(R.id.spinner_tutor_crear_grupo);
        btnCrear = root.findViewById(R.id.btn_crearGrupo_crear);
        spinnerUniversidad.setAdapter(new ArrayAdapter<University.UniversityEnum>(context, R.layout.support_simple_spinner_dropdown_item, University.UniversityEnum.values()));

        btnLugarEncuentro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, CreateGroupMapsActivity.class);
                startActivityForResult(i,REQUEST_SELECCIONAR_UBICACION);
            }
        });

        btnIntegrantes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO Cargar MultiOption dialog con estudiantes de la misma carrera y facultad.
                students = (Person[])PersonController.getInstance().findMembers((Career.CareerEnum)spinnerCarrera.getSelectedItem(),(Faculty.FacultyEnum)spinnerFacultad.getSelectedItem(),context).toArray();
                studentsList = new String[students.length];
                checkedStudents = new boolean[studentsList.length];
            }
        });

        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (MainActivity.usuarioActivo.isTeacher()) {
                    if (MainActivity.usuarioActivo.equals(teacher)) {
                        if (!etNombre.getText().toString().isEmpty() && ubicacion != null && !studentsSelected.isEmpty() && teacher != null) {
                            Group newGroup = new Group(etNombre.getText().toString(), university, faculty, career, subject, ubicacion, studentsSelected, teacher);
                            Toast.makeText(context, "El grupo " + R.string.se_creo_exitoso, Toast.LENGTH_LONG).show();
                            MainActivity.usuarioActivo.getGroups().add(newGroup);
                            GroupController.save(newGroup,context);
                        } else
                            Toast.makeText(context, R.string.incomplete_fields, Toast.LENGTH_LONG).show();
                    } else
                        Toast.makeText(context, "El tutor debe ser el usuario activo", Toast.LENGTH_LONG).show();
                } else {
                    if (!etNombre.getText().toString().isEmpty() && ubicacion != null && !studentsSelected.isEmpty() && teacher != null) {
                        Group newGroup = new Group(etNombre.getText().toString(), university, faculty, career, subject, ubicacion, studentsSelected, teacher);
                        Toast.makeText(context, "El grupo " + R.string.se_creo_exitoso, Toast.LENGTH_LONG).show();
                        MainActivity.usuarioActivo.getGroups().add(newGroup);
                        GroupController.save(newGroup,context);
                    } else
                        Toast.makeText(context, R.string.incomplete_fields, Toast.LENGTH_LONG).show();
                }
            }
        });

        spinnerUniversidad.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                university = (University.UniversityEnum)spinnerUniversidad.getSelectedItem();
                spinnerFacultad.setAdapter(new ArrayAdapter<Faculty.FacultyEnum>(context, R.layout.support_simple_spinner_dropdown_item, GeneralController.getInstance().getUniversity(university).getFacultyEnumList()));
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        spinnerFacultad.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                faculty= (Faculty.FacultyEnum)spinnerFacultad.getSelectedItem();
                spinnerCarrera.setAdapter(new ArrayAdapter<Career.CareerEnum>(context, R.layout.support_simple_spinner_dropdown_item, GeneralController.getInstance().getFaculty(faculty).getCareerEnumList()));
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        spinnerCarrera.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                career = (Career.CareerEnum)spinnerCarrera.getSelectedItem();
                spinnerMateria.setAdapter(new ArrayAdapter<Subject.SubjectEnum>(context, R.layout.support_simple_spinner_dropdown_item, GeneralController.getInstance().getCareer(career).getSubjectEnumList()));
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        spinnerMateria.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                subject = (Subject.SubjectEnum) spinnerMateria.getSelectedItem();
                spinnerTutor.setAdapter(new ArrayAdapter<Person>(context, R.layout.support_simple_spinner_dropdown_item, PersonController.findTeachersBySubject(subject,context)));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        spinnerTutor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                teacher = (Person) spinnerTutor.getSelectedItem();
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
