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
    @Ignore
    private List<Grupo> grupos;

    @ColumnInfo(name = "carrera_enum")
    private Carrera.CarreraEnum carreraEnum;

    public Estudiante(String nombre, String apellido, String email, Domicilio domicilio, Bitmap foto, Carrera carrera) {
        super(nombre, apellido, email, domicilio, foto);
        this.carrera = carrera;
        this.carreraEnum = carrera.getCarreraEnum();
        this.grupos = new ArrayList<>();
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public List<Grupo> getGrupos() {
        return grupos;
    }
}
