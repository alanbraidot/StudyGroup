package com.example.studygroup.domain;

import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.List;

public class Tutor extends Persona {
    private List<Materia> materiasHabilitadas;
    private List<Grupo> grupos;

    public Tutor(String nombre, String apellido, String email, Bitmap foto) {
        super(nombre, apellido, email, foto);
        this.materiasHabilitadas = new ArrayList<>();
        this.grupos = new ArrayList<>();
    }

    public List<Materia> getMateriasHabilitadas() {
        return materiasHabilitadas;
    }

    public List<Grupo> getGrupos() {
        return grupos;
    }
}
