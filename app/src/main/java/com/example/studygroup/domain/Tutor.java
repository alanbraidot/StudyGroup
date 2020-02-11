package com.example.studygroup.domain;

import android.graphics.Bitmap;

import androidx.room.Entity;
import androidx.room.Ignore;

import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "teachers")
public class Tutor extends Persona {
    //TODO Convertir para almacenar
    @Ignore
    private List<Materia> materiasHabilitadas;

    public Tutor(String nombre, String apellido, String email, Domicilio domicilio, Bitmap foto) {
        super(nombre, apellido, email, domicilio, foto);
        this.materiasHabilitadas = new ArrayList<>();
    }

    public Tutor(){}

    public List<Materia> getMateriasHabilitadas() {
        return materiasHabilitadas;
    }

}
