package com.example.studygroup.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.FileProvider;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import com.example.studygroup.R;
import com.example.studygroup.domain.Career;
import com.example.studygroup.domain.Address;
import com.example.studygroup.domain.Faculty;
import com.example.studygroup.domain.Subject;
import com.example.studygroup.domain.University;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class RegisterActivity extends AppCompatActivity {

    private CircleImageView fotoPerfil;
    private Button btnAgregarFoto;
    private Switch switchEsTutor;
    private Spinner spinnerPais;
    private Spinner spinnerProvincia;
    private Spinner spinnerCiudad;
    private Spinner spinnerUniversidad;
    private Spinner spinnerFacultad;
    private Spinner spinnerCarrera;
    private Button btnSeleccionarMaterias;
    private ConstraintLayout layoutEstudiante;
    private ConstraintLayout layoutTutor;
    private Button btnGuardar;
    private EditText materiasSeleccionadas;
    private ArrayList<Integer> mUserSubjects = new ArrayList<>();
    static final int REQUEST_IMAGE_CAPTURE = 1;
    static final int REQUEST_IMAGE_SAVE = 2;
    private String pathPhoto = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ActionBar actionBar= getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        pathPhoto=null;

        actionBar.setTitle("Completar registro");

        fotoPerfil = (CircleImageView) findViewById(R.id.imageView_foto_perfil_registro);
        btnAgregarFoto = (Button) findViewById(R.id.btn_agregar_foto_registro);
        switchEsTutor = (Switch) findViewById(R.id.switch_tutor);
        spinnerPais = (Spinner) findViewById(R.id.spinner_pais_registro);
        spinnerProvincia = (Spinner) findViewById(R.id.spinner_provincia_registro);
        spinnerCiudad = (Spinner) findViewById(R.id.spinner_ciudad_registro);
        spinnerUniversidad = (Spinner) findViewById(R.id.spinner_universidad_registro);
        spinnerFacultad = (Spinner) findViewById(R.id.spinner_facultad_registro);
        spinnerCarrera = (Spinner) findViewById(R.id.spinner_carrera_registro);
        btnSeleccionarMaterias = (Button) findViewById(R.id.btn_select_subjects);
        layoutEstudiante = (ConstraintLayout) findViewById(R.id.layoutEstudiante);
        layoutTutor = (ConstraintLayout) findViewById(R.id.layoutTutor);
        btnGuardar = (Button) findViewById(R.id.btn_guardar_registro);
        materiasSeleccionadas = (EditText) findViewById(R.id.et_subjects_register);

        btnAgregarFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tomarGuardarFoto();
            }
        });

        switchEsTutor.setChecked(false);
        layoutTutor.setVisibility(View.GONE);
        switchEsTutor.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    layoutEstudiante.setVisibility(View.GONE);
                    layoutTutor.setVisibility(View.VISIBLE);
                }
                else{
                    layoutEstudiante.setVisibility(View.VISIBLE);
                    layoutTutor.setVisibility(View.GONE);
                }
            }
        });

        spinnerPais.setAdapter(new ArrayAdapter<Address.CountryEnum>(this, R.layout.support_simple_spinner_dropdown_item, Address.CountryEnum.values()));
        spinnerProvincia.setAdapter(new ArrayAdapter<Address.ProvinceEnum>(this, R.layout.support_simple_spinner_dropdown_item, Address.ProvinceEnum.values()));
        spinnerCiudad.setAdapter(new ArrayAdapter<Address.CityEnum>(this, R.layout.support_simple_spinner_dropdown_item, Address.CityEnum.values()));
        spinnerUniversidad.setAdapter(new ArrayAdapter<University.UniversityEnum>(this, R.layout.support_simple_spinner_dropdown_item, University.UniversityEnum.values()));
        spinnerFacultad.setAdapter(new ArrayAdapter<Faculty.FacultyEnum>(this, R.layout.support_simple_spinner_dropdown_item, Faculty.FacultyEnum.values()));
        spinnerCarrera.setAdapter(new ArrayAdapter<Career.CareerEnum>(this, R.layout.support_simple_spinner_dropdown_item, Career.CareerEnum.values()));

        final Subject.SubjectEnum[] subjectEnums = Subject.SubjectEnum.values();
        final String[] subjectsList = new String[subjectEnums.length];
        for (int i=0; i<subjectEnums.length; i++){
            subjectsList[i]=subjectEnums[i].toString();
        }
        final boolean[] checkedSubjects = new boolean[subjectsList.length];

        btnSeleccionarMaterias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(RegisterActivity.this)
                        .setMultiChoiceItems(subjectsList, checkedSubjects, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int position, boolean isChecked) {
                                if(isChecked){
                                    if(!mUserSubjects.contains(position))
                                        mUserSubjects.add(position);
                                    else
                                        mUserSubjects.remove(position);
                                }

                            }
                        });
                mBuilder.setCancelable(false);
                mBuilder.setPositiveButton(R.string.ok_button, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //TODO Completar EditText con materias seleccionadas.
                        String item = "";
                        for(int i=0; i< mUserSubjects.size(); i++){
                            item = item + subjectsList[mUserSubjects.get(i)];
                            if(i != mUserSubjects.size() -1){
                                item = item + ", ";
                            }
                        }
                        materiasSeleccionadas.setText(item);
                    }
                });
                mBuilder.setNegativeButton(R.string.cancel_button, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mUserSubjects.clear();
                    }
                });

                AlertDialog  mDialog = mBuilder.create();
                mDialog.show();
            }
        });

        spinnerPais.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                if(pathPhoto!=null)
                    i.putExtra("Photo",pathPhoto);
                i.putExtra("Is_teacher",switchEsTutor.isChecked());
                i.putExtra("Country",spinnerPais.getSelectedItem().toString());
                i.putExtra("Province",spinnerProvincia.getSelectedItem().toString());
                i.putExtra("City",spinnerCiudad.getSelectedItem().toString());
                if(!switchEsTutor.isChecked()){
                    i.putExtra("University",spinnerUniversidad.getSelectedItem().toString());
                    i.putExtra("Faculty",spinnerFacultad.getSelectedItem().toString());
                    i.putExtra("Career", spinnerCarrera.getSelectedItem().toString());
                }
                else {
                    //TODO Agregar al intent las materias seleccionadas por el profesor.
                }
                setResult(RESULT_OK);
                finish();
            }
        });
    }

    private void tomarGuardarFoto() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) { }
            if (photoFile != null) {
                Uri photoURI = FileProvider.getUriForFile(this,"com.example.android.fileprovider", photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_SAVE);
            }
        }
    }

    private File createImageFile() throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File dir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(imageFileName, /* prefix */".jpg", /* suffix */dir /* directory */);
        pathPhoto = image.getAbsolutePath();
        return image;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_IMAGE_SAVE && resultCode == RESULT_OK) {
            File file = new File(pathPhoto);
            Bitmap imageBitmap = null;
            try {
                imageBitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), Uri.fromFile(file));
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (imageBitmap != null) {
                fotoPerfil.setImageBitmap(imageBitmap);
            }
        }
    }
}
