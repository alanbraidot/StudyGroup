package com.example.studygroup.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.FileProvider;

import android.content.Intent;
import android.graphics.Bitmap;
import android.icu.text.StringPrepParseException;
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import com.example.studygroup.R;
import com.example.studygroup.domain.Carrera;
import com.example.studygroup.domain.Domicilio;
import com.example.studygroup.domain.Facultad;
import com.example.studygroup.domain.Tutor;
import com.example.studygroup.domain.Universidad;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RegistroDatos extends AppCompatActivity {

    private ImageView fotoPerfil;
    private Button btnAgregarFoto;
    private Switch switchEsTutor;
    private Spinner spinnerPais;
    private Spinner spinnerProvincia;
    private Spinner spinnerCiudad;
    private Spinner spinnerUniversidad;
    private Spinner spinnerFacultad;
    private Spinner spinnerCarrera;
    private Spinner spinnerMaterias;
    private ConstraintLayout layoutEstudiante;
    private ConstraintLayout layoutTutor;
    private Button btnGuardar;

    static final int REQUEST_IMAGE_CAPTURE = 1;
    static final int REQUEST_IMAGE_SAVE = 2;
    private String pathFoto = "images/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_datos);
        ActionBar actionBar= getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        actionBar.setTitle("Completar registro");

        fotoPerfil = (ImageView) findViewById(R.id.imageView_foto_perfil_registro);
        btnAgregarFoto = (Button) findViewById(R.id.btn_agregar_foto_registro);
        switchEsTutor = (Switch) findViewById(R.id.switch_tutor);
        spinnerPais = (Spinner) findViewById(R.id.spinner_pais_registro);
        spinnerProvincia = (Spinner) findViewById(R.id.spinner_provincia_registro);
        spinnerCiudad = (Spinner) findViewById(R.id.spinner_ciudad_registro);
        spinnerUniversidad = (Spinner) findViewById(R.id.spinner_universidad_registro);
        spinnerFacultad = (Spinner) findViewById(R.id.spinner_facultad_registro);
        spinnerCarrera = (Spinner) findViewById(R.id.spinner_carrera_registro);
        spinnerMaterias = (Spinner) findViewById(R.id.spinner_materias);
        layoutEstudiante = (ConstraintLayout) findViewById(R.id.layoutEstudiante);
        layoutTutor = (ConstraintLayout) findViewById(R.id.layoutTutor);
        btnGuardar = (Button) findViewById(R.id.btn_guardar_registro);

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

        spinnerPais.setAdapter(new ArrayAdapter<Domicilio.PaisEnum>(this, R.layout.support_simple_spinner_dropdown_item, Domicilio.PaisEnum.values()));
        spinnerProvincia.setAdapter(new ArrayAdapter<Domicilio.ProvinciaEnum>(this, R.layout.support_simple_spinner_dropdown_item, Domicilio.ProvinciaEnum.values()));
        spinnerCiudad.setAdapter(new ArrayAdapter<Domicilio.CiudadEnum>(this, R.layout.support_simple_spinner_dropdown_item, Domicilio.CiudadEnum.values()));
        spinnerUniversidad.setAdapter(new ArrayAdapter<Universidad.UniversidadEnum>(this, R.layout.support_simple_spinner_dropdown_item, Universidad.UniversidadEnum.values()));
        spinnerFacultad.setAdapter(new ArrayAdapter<Facultad.FacultadEnum>(this, R.layout.support_simple_spinner_dropdown_item, Facultad.FacultadEnum.values()));
        spinnerCarrera.setAdapter(new ArrayAdapter<Carrera.CarreraEnum>(this, R.layout.support_simple_spinner_dropdown_item, Carrera.CarreraEnum.values()));
        //TODO Crear spinner multi-select para materias;

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(switchEsTutor.isChecked()){
                    //TODO Crear tutor;
                }
                else{
                    //TODO Crear estudiante;
                }
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
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
                Uri photoURI = FileProvider.getUriForFile(this,
                        "com.example.android.fileprovider",
                        photoFile);
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
        pathFoto = image.getAbsolutePath();
        return image;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_IMAGE_SAVE && resultCode == RESULT_OK) {
            File file = new File(pathFoto);
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
