package com.example.studygroup.domain;

import android.graphics.Bitmap;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;

import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "estudiante")
public class Estudiante extends Persona{
    @Ignore
    private Carrera carrera;

    //TODO Convertir para almacenar
    @Ignore
    private Carrera.CarreraEnum carreraEnum;

    public Estudiante(){}

    public Estudiante(String nombre, String apellido, String email, Domicilio domicilio, Bitmap foto, Carrera carrera) {
        super(nombre, apellido, email, domicilio, foto);
        this.carrera = carrera;
    }

    public Carrera getCarrera() {
        return carrera;
    }

}
