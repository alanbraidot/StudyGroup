package com.example.studygroup.domain;

import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.List;

public class Estudiante extends Persona{
    private List<Carrera> carreras;
    private List<Grupo> grupos;

    public Estudiante(String nombre, String apellido, String email, Bitmap foto) {
        super(nombre, apellido, email, foto);
        this.carreras = new ArrayList<>();
        this.grupos = new ArrayList<>();
    }

    public List<Carrera> getCarrera() {
        return carreras;
    }

    public List<Grupo> getGrupos() {
        return grupos;
    }
}
