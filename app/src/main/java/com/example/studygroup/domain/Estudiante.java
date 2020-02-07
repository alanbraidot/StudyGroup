package com.example.studygroup.domain;

import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.List;

public class Estudiante extends Persona{
    private Carrera carrera;
    private List<Grupo> grupos;

    public Estudiante(String nombre, String apellido, String email, Domicilio domicilio, Bitmap foto, Carrera carrera) {
        super(nombre, apellido, email, domicilio, foto);
        this.carrera = carrera;
        this.grupos = new ArrayList<>();
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public List<Grupo> getGrupos() {
        return grupos;
    }
}
