package com.example.studygroup.domain;

import android.graphics.Bitmap;

import androidx.room.Entity;
import androidx.room.Ignore;

import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "teachers")
public class Teacher extends Person {
    //TODO Convertir para almacenar
    @Ignore
    private List<Subject> materiasHabilitadas;

    public Teacher(String nombre, String apellido, String email, Address address, Bitmap foto) {
        super(nombre, apellido, email, address, foto);
        this.materiasHabilitadas = new ArrayList<>();
    }

    public Teacher(){}

    public List<Subject> getMateriasHabilitadas() {
        return materiasHabilitadas;
    }

}
