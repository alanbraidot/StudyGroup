package com.example.studygroup.domain;

import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.List;

public class Tutor extends Persona {
    private List<Materia> materiasHabilitadas;


    public Tutor(String nombre, String apellido, String email, Domicilio domicilio, Bitmap foto) {
        super(nombre, apellido, email, domicilio, foto);
        this.materiasHabilitadas = new ArrayList<>();
    }

    public List<Materia> getMateriasHabilitadas() {
        return materiasHabilitadas;
    }

}
