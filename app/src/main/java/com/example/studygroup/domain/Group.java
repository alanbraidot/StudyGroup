package com.example.studygroup.domain;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.android.gms.maps.model.LatLng;

import java.util.List;

@Entity(tableName = "groups")
public class Group {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id_group")
    private Integer id;
    @Ignore
    private List<Person> integrantes;
    //TODO Convertir para almacenar
    @Ignore
    private Person teacher;
    @ColumnInfo(name = "name")
    private String nombre;
    //TODO Convertir para almacenar
    @Ignore
    private Career career;
    //TODO Convertir para almacenar
    @Ignore
    private Subject subject;
    //TODO Convertir para almacenar
    @Ignore
    private Faculty faculty;
    //TODO Convertir para almacenar
    @Ignore
    private LatLng lugarEncuentro;

    public Group(List<Person> integrantes, Person teacher, String nombre, Career career, Subject subject, Faculty faculty, LatLng lugarEncuentro) {
        this.integrantes = integrantes;
        this.teacher = teacher;
        this.nombre = nombre;
        this.career = career;
        this.subject = subject;
        this.faculty = faculty;
        this.lugarEncuentro = lugarEncuentro;
    }

    public Group(){}

    public Integer getId() {
        return id;
    }

    public List<Person> getIntegrantes() {
        return integrantes;
    }

    public Person getTeacher() {
        return teacher;
    }

    public String getNombre() {
        return nombre;
    }

    public Career getCareer() {
        return career;
    }

    public Subject getSubject() {
        return subject;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public LatLng getLugarEncuentro() {
        return lugarEncuentro;
    }

    public void setId(@NonNull Integer id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
