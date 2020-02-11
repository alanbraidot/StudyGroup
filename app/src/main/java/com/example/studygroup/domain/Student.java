package com.example.studygroup.domain;

import android.graphics.Bitmap;

import androidx.room.Entity;
import androidx.room.Ignore;

@Entity(tableName = "estudiante")
public class Student extends Person {
    @Ignore
    private Career career;

    //TODO Convertir para almacenar
    @Ignore
    private Career.CarreraEnum carreraEnum;

    public Student(){}

    public Student(String nombre, String apellido, String email, Address address, Bitmap foto, Career career) {
        super(nombre, apellido, email, address, foto);
        this.career = career;
    }

    public Career getCareer() {
        return career;
    }

}
